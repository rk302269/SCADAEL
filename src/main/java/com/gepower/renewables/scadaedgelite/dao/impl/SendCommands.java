package com.gepower.renewables.scadaedgelite.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.opcfoundation.ua.builtintypes.NodeId;


public class SendCommands {
	
	private Map<String, String> turbineCommandMap;
	public void sendCommands(Map<String, String> turbineCommandMap)
	{
	
		List<NodeId> list = new ArrayList<NodeId>();
		for(Map.Entry<String, String> assetCommands : turbineCommandMap.entrySet())
		{
			//String nId = 
		//	list.add(NodeId.parseNodeId(nodeIdRef))
		}
		
	}

}
