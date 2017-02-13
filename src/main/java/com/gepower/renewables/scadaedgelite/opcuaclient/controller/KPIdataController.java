package com.gepower.renewables.scadaedgelite.opcuaclient.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.opcfoundation.ua.builtintypes.DataValue;
import org.opcfoundation.ua.builtintypes.DiagnosticInfo;
import org.opcfoundation.ua.builtintypes.ExtensionObject;
import org.opcfoundation.ua.builtintypes.StatusCode;
import org.opcfoundation.ua.builtintypes.UnsignedInteger;
import org.opcfoundation.ua.builtintypes.Variant;
import org.opcfoundation.ua.core.DataChangeNotification;
import org.opcfoundation.ua.core.MonitoredItemNotification;
import org.opcfoundation.ua.core.NotificationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.AssetKPIDataJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.AssetsJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.OpctagsJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.RowCountJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.SiteKPIDataJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Asset;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Opctag;
import com.prosysopc.ua.MonitoredItemBase;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.client.MonitoredDataItem;
import com.prosysopc.ua.client.MonitoredEventItem;
import com.prosysopc.ua.client.Subscription;
import com.prosysopc.ua.client.SubscriptionNotificationListener;

@Repository
public class KPIdataController  implements SubscriptionNotificationListener{

	@Autowired
	private static AssetsJdbcImpl assetsJdbc;
	private static OpctagsJdbcImpl opctagsJdbc;
	private static AssetKPIDataJdbcImpl liveDataJdbc;
	
	@Autowired
	public KPIdataController(AssetsJdbcImpl assetsJdbc,OpctagsJdbcImpl opctagsJdbc,AssetKPIDataJdbcImpl liveDataJdbc, RowCountJdbcImpl rowCountJdbc, SiteKPIDataJdbcImpl siteKPIJdbc)
	{
		this.assetsJdbc = assetsJdbc;
		this.opctagsJdbc = opctagsJdbc;
		this.liveDataJdbc = liveDataJdbc;
	}

	public KPIdataController() 
	{
		super();		
	}

	@Override
	public void onBufferOverflow(Subscription arg0, UnsignedInteger arg1, ExtensionObject[] arg2) 
	{

	}

	@Override
	public void onDataChange(Subscription arg0, MonitoredDataItem arg1, DataValue arg2) 
	{

	}

	@Override
	public void onError(Subscription arg0, Object arg1, Exception arg2)
	{

	}

	@Override
	public void onEvent(Subscription arg0, MonitoredEventItem arg1, Variant[] arg2) 
	{

	}

	@Override
	public long onMissingData(UnsignedInteger arg0, long arg1, long arg2, StatusCode arg3) 
	{
		return 0;
	}

	@Override
	public void onNotificationData(Subscription subscription, NotificationData notificationData) 
	{
		if ((notificationData instanceof DataChangeNotification)) 
		{ 
			List<MonitoredDataItem> values = new ArrayList<MonitoredDataItem>();
			DataChangeNotification dataChangeNotification = (DataChangeNotification) notificationData;
			MonitoredItemNotification[] monitoredItemNotifications = dataChangeNotification.getMonitoredItems();
			MonitoredItemBase monitoredItemBase = null;
			for (MonitoredItemNotification notification : monitoredItemNotifications) 
			{			
				try 
				{ 
					monitoredItemBase = subscription.getItem(notification.getClientHandle()); 
				} 
				catch (StatusException e) 
				{ 
					e.printStackTrace(); 
				} 
				MonitoredDataItem monitoredDataItem = (MonitoredDataItem) monitoredItemBase;	           		       
				values.add(monitoredDataItem);

			}

			try{
				subscriptionsNotify(values);
			}
			catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
	
	public void subscriptionsNotify(List<MonitoredDataItem> changedItems) throws SQLException
	{
		List<KPIData> kpiDatavalues = new ArrayList<KPIData>();
	
		for(MonitoredDataItem dataItem : changedItems)
		{
			
			
			KPIData kpiData = new KPIData();
			
			String nodeId = dataItem.getNodeId().toString().trim().split(";s=")[1];
			String assetName = nodeId.split("\\.")[0];
			String tagName = nodeId.split("\\.")[1]; 		
			String tagValue = null;
	
			Opctag opctag = opctagsJdbc.getOPCtagDetails(tagName);
			Asset asset = assetsJdbc.getAssetDetails(assetName);
			int assetId = asset.getAssetId();
			int tagId = opctag.getTagId();
			String tagUnits= opctag.getUnits();
			int rowCount;

			if(opctag.getTagId()==10018)
			{								
				tagValue=	dataItem.getValue().getValue().toString();						
			}
			else
			{
				if(tagUnits!=null)
				{
				String tagVal = dataItem.getValue().getValue().toString();
				if(tagVal.indexOf(".")!=-1)
				{
					double opctagVal = Double.parseDouble(tagVal);
					tagValue = (double) Math.round(opctagVal* 100) / 100+" "+tagUnits;
				}
				else
				{
					tagValue = tagVal+" "+tagUnits;
				}
				}
			}
			String timeStamp =dataItem.getValue().getSourceTimestamp().toString().substring(0,17);
			
			rowCount = liveDataJdbc.getRowCount(assetId, tagId);
			if(rowCount==1)
			{
			kpiData.setAssetId(assetId);
			kpiData.setAssetName(assetName);
			kpiData.setTagId(tagId);
			kpiData.setOpctagName(opctag.getDisplayName());
			kpiData.setOpctagValue(tagValue);
			kpiData.setLivedataReceivedTime(timeStamp);			
			kpiDatavalues.add(kpiData);
			}
			else
			{
				liveDataJdbc.insertLiveData(assetId, assetName, tagId, opctag.getDisplayName(), tagValue, timeStamp);
			}
		}
										
				liveDataJdbc.updateBatchLiveData(kpiDatavalues);
				
	}


@Override
public void onStatusChange(Subscription arg0, StatusCode arg1, StatusCode arg2, DiagnosticInfo arg3) 
{		

}

}
