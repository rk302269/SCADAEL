package com.gepower.renewables.scadaedgelite.opcuaclient.serviceimpl;

import org.opcfoundation.ua.builtintypes.NodeId;
import org.opcfoundation.ua.builtintypes.UnsignedInteger;
import org.opcfoundation.ua.core.Attributes;
import org.opcfoundation.ua.core.DataChangeFilter;
import org.opcfoundation.ua.core.DataChangeTrigger;
import org.opcfoundation.ua.core.DeadbandType;
import org.opcfoundation.ua.core.MonitoringMode;

import com.gepower.renewables.scadaedgelite.opcuaclient.service.SubscriptionService;
import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.client.MonitoredDataItem;
import com.prosysopc.ua.client.MonitoredDataItemListener;
import com.prosysopc.ua.client.Subscription;

public class SubscriptionServiceImpl implements SubscriptionService
{

	public MonitoredDataItem getMonitoredDataItem(NodeId nodeId,
			MonitoredDataItemListener monitoredDataItemListener,
			double samplingInterval) throws ServiceException
	{
		MonitoredDataItem monitoredDataItem = new 
				MonitoredDataItem(nodeId, Attributes.Value, MonitoringMode.Reporting);
		monitoredDataItem.setDiscardOldest(true);
		monitoredDataItem.setDataChangeListener(monitoredDataItemListener);
		monitoredDataItem.setSamplingInterval(samplingInterval);
		return monitoredDataItem;
	}

	public Subscription getSubscription(double publishingInterval) throws ServiceException
	{
		Subscription subscription= new Subscription();
		subscription.setPublishingInterval(publishingInterval);
		return subscription;

	}


	public MonitoredDataItem getMonitoredDataItem(NodeId nodeId) throws ServiceException, StatusException
	{
		MonitoredDataItem monitoredDataItem = new 
				MonitoredDataItem(nodeId, Attributes.Value, MonitoringMode.Reporting);
		monitoredDataItem.setDiscardOldest(true);
		
		DataChangeFilter dataChangeFilter = new DataChangeFilter(); 
		dataChangeFilter.setTrigger(DataChangeTrigger.StatusValueTimestamp);
		dataChangeFilter.setDeadbandType(UnsignedInteger.valueOf(DeadbandType.None.getValue()));
		dataChangeFilter.setDeadbandValue(Double.valueOf("0"));		
		monitoredDataItem.setDataChangeFilter(dataChangeFilter);
		
		return monitoredDataItem;
	}
	
}
