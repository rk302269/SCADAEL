package com.gepower.renewables.scadaedgelite.opcuaclient.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.opcfoundation.ua.builtintypes.NodeId;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.controller.KPIdataController;
import com.gepower.renewables.scadaedgelite.opcuaclient.service.LivedataSubscriptionService;
import com.prosysopc.ua.client.MonitoredDataItem;
import com.prosysopc.ua.client.Subscription;
import com.prosysopc.ua.client.UaClient;

@Repository
public class LivedataSubscriptionServiceImpl implements LivedataSubscriptionService
{	
	public LivedataSubscriptionServiceImpl() 
	{
		super();		
	}
	

	public  void subscribeLivedataNodes()
	{	
		try {

			UaClient livedataUaClient = OPCClientConnection.getOPCUAClientConnection();

			if (livedataUaClient.isConnected() != false)
			{			
				int count=0;
				
				Subscription subscription;
				MonitoredDataItem monitoredDataItem;
				SubscriptionServiceImpl subscriptionServiceImpl = new SubscriptionServiceImpl();
				
				subscription= subscriptionServiceImpl.getSubscription(1000);
				
				Map<String,NodeId> nodeIdsMap = NodeIdBuilderServiceImpl.getNodeIds("10.119.166.35","livedata");								
			
				for(Entry<String, NodeId> entry  : nodeIdsMap.entrySet())
				{
					NodeId nodeId = entry.getValue();				
					monitoredDataItem = subscriptionServiceImpl.getMonitoredDataItem(nodeId);
					subscription.addItem(monitoredDataItem);					
					count++;
				}		
				
				KPIdataController readLivedata = new KPIdataController();
				
				subscription.addNotificationListener(readLivedata);
				
				livedataUaClient.addSubscription(subscription);
			
				System.out.println(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date())
						+ ":  Finished Subcribing to: "+count+" LiveData Nodes");
				

			}
		}
		catch (Exception e) {
			System.out.println("Exception in LiveDataSubscriptionServiceImp.class : "+e);
		}
	}
	
	
	
	


}
