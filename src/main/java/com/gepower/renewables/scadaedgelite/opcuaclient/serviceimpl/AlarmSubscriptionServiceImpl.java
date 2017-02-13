package com.gepower.renewables.scadaedgelite.opcuaclient.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.opcfoundation.ua.builtintypes.NodeId;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.controller.AlarmDataController;
import com.gepower.renewables.scadaedgelite.opcuaclient.service.AlarmSubscriptionService;
import com.prosysopc.ua.client.MonitoredDataItem;
import com.prosysopc.ua.client.Subscription;
import com.prosysopc.ua.client.UaClient;

@Repository
public class AlarmSubscriptionServiceImpl implements AlarmSubscriptionService{

	public AlarmSubscriptionServiceImpl() 
	{
		super();
	}

	public void subscribeAlarmNodes()
	{
		try {

			UaClient alarmUaClient = OPCClientConnection.getOPCUAClientConnection();

			if (alarmUaClient.isConnected() != false)
			{
				int count=0;

				Subscription subscription;
				MonitoredDataItem monitoredDataItem;
				SubscriptionServiceImpl subscriptionServiceImpl = new SubscriptionServiceImpl();

				subscription= subscriptionServiceImpl.getSubscription(1000);			

				Map<String,NodeId> nodeIdsMap = NodeIdBuilderServiceImpl.getNodeIds("10.119.166.35","alarm");	


				for(Entry<String, NodeId> entry  : nodeIdsMap.entrySet())
				{
					NodeId nodeId = entry.getValue();	
					System.out.println("nodeId"+nodeId);
					monitoredDataItem = subscriptionServiceImpl.getMonitoredDataItem(nodeId);
					subscription.addItem(monitoredDataItem);					
					count++;
				}		
               
				AlarmDataController readAlarmdata = new AlarmDataController();

				subscription.addNotificationListener(readAlarmdata);

				alarmUaClient.addSubscription(subscription);

				System.out.println(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date())
						+ ":  Finished Subcribing to: "+count+" Alarm Nodes");
			}
		}						
		catch (Exception e) 
		{
			System.out.println("Alarm subscription Error : "+e);	
		}
	}
}
