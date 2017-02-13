package com.gepower.renewables.scadaedgelite.opcuaclient.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.opcfoundation.ua.core.DataChangeNotification;
import org.opcfoundation.ua.core.MonitoredItemNotification;
import org.opcfoundation.ua.core.NotificationData;

import com.prosysopc.ua.MonitoredItemBase;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.client.MonitoredDataItem;
import com.prosysopc.ua.client.Subscription;

public class MonitoredDataServiceImpl {

	private MonitoredItemBase monitoredItemBase;
	
	private MonitoredDataItem monitoredDataItem;
	
	public List<MonitoredDataItem> onNotificationData(Subscription arg0, NotificationData notificationData) {
		
		List<MonitoredDataItem> monitoredDataItems = new ArrayList<MonitoredDataItem>();
		if((notificationData instanceof DataChangeNotification))
		{						
			DataChangeNotification  dataChangeNotification = (DataChangeNotification)notificationData;
			
			MonitoredItemNotification[] monitoredItemNotifications = dataChangeNotification.getMonitoredItems();
			
			monitoredItemBase = null;
			
			for(MonitoredItemNotification monitoredItemNotification : monitoredItemNotifications)
			{
				try 
				{
					monitoredItemBase = arg0.getItem(monitoredItemNotification.getClientHandle());
				} 
				catch (StatusException e) 
				{
					e.printStackTrace();
				}
				
				 monitoredDataItem = (MonitoredDataItem)monitoredItemBase;				
				 monitoredDataItems.add(monitoredDataItem);
			}
		}
		
		return monitoredDataItems;
		
		
		
	}



	

}
