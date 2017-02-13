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

import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.AlarmDataJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.OpctagsJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Alarm;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Opctag;
import com.prosysopc.ua.MonitoredItemBase;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.client.MonitoredDataItem;
import com.prosysopc.ua.client.MonitoredEventItem;
import com.prosysopc.ua.client.Subscription;
import com.prosysopc.ua.client.SubscriptionNotificationListener;

@Repository
public class AlarmDataController implements SubscriptionNotificationListener{

	@Autowired
	private static OpctagsJdbcImpl opctagsJdbc;
	private static AlarmDataJdbcImpl alarmDataJdbc;

	@Autowired
	public AlarmDataController(OpctagsJdbcImpl opctagsJdbc, AlarmDataJdbcImpl alarmDataJdbc)
	{
		this.opctagsJdbc = opctagsJdbc;
		this.alarmDataJdbc = alarmDataJdbc;
	}

	public AlarmDataController() 
	{
		super();		
	}

	@Override
	public void onBufferOverflow(Subscription arg0, UnsignedInteger arg1, ExtensionObject[] arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDataChange(Subscription arg0, MonitoredDataItem arg1, DataValue arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Subscription arg0, Object arg1, Exception arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEvent(Subscription arg0, MonitoredEventItem arg1, Variant[] arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public long onMissingData(UnsignedInteger arg0, long arg1, long arg2, StatusCode arg3) {
		// TODO Auto-generated method stub
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
		List<Alarm> alarms = new ArrayList<Alarm>();

		for(MonitoredDataItem dataItem : changedItems)
		{


			Alarm alarm = new Alarm();

			String nodeId 			= 	dataItem.getNodeId().toString().trim().split(";s=")[1];

			String assetName 		= 	nodeId.split("\\.")[0];
			String tagName 			= 	nodeId.split("\\.")[1]; 		
			String tagValue 		=	dataItem.getValue().getValue().toString();

			Opctag opctag 			= 	opctagsJdbc.getOPCtagDetails(tagName);

			String alarmName 		= 	"EM"+opctag.getAlias().substring(5);	
			String timeStamp 		=	dataItem.getValue().getSourceTimestamp().toString().substring(0,17);
			String alarmDescription	=	opctag.getDescription();
			int rowCount;
			
			if(tagValue.equals("true") || tagValue == "true")
			{
				System.out.println(assetName+" | "+tagValue);
				rowCount = alarmDataJdbc.getRowCount(assetName,alarmName);
				
				if(rowCount!=1)
				{
					alarm.setAssetName(assetName);
					alarm.setAlarmName(alarmName);
					alarm.setDescription(alarmDescription);
					alarm.setState(tagValue);
					alarm.setTime(timeStamp);

					alarms.add(alarm);
				}
			}
			else if(tagValue.equals("false") || tagValue == "false")
			{
				rowCount = alarmDataJdbc.getRowCount(assetName,alarmName);
				if(rowCount==1)
				{
					alarmDataJdbc.deleteAlarmData(assetName, alarmName);
				}
			}
		}

		alarmDataJdbc.insertBatchAlarmData(alarms);


	}


	@Override
	public void onStatusChange(Subscription arg0, StatusCode arg1, StatusCode arg2, DiagnosticInfo arg3) {
		// TODO Auto-generated method stub

	}

}
