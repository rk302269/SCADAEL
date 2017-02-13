package com.gepower.renewables.scadaedgelite.opcuaclient.service;

import org.opcfoundation.ua.builtintypes.NodeId;

import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.client.MonitoredDataItem;
import com.prosysopc.ua.client.MonitoredDataItemListener;
import com.prosysopc.ua.client.Subscription;

public interface SubscriptionService {

	public MonitoredDataItem getMonitoredDataItem(NodeId nodeId,
			 MonitoredDataItemListener monitoredDataItemListener,
			 double samplingInterval) throws ServiceException;
	
	public Subscription getSubscription(double publishingInterval) throws ServiceException;
	
	
}
