package com.gepower.renewables.scadaedgelite.opcuaclient.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.opcfoundation.ua.builtintypes.NodeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.AssetsJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl.OpctagsJdbcImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Asset;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Opctag;

@Repository
public class NodeIdBuilderServiceImpl 
{	
	@Autowired
	private static AssetsJdbcImpl assetsJdbc;
	private static OpctagsJdbcImpl opctagsJdbc;

	@Autowired
	public NodeIdBuilderServiceImpl(AssetsJdbcImpl assetsJdbc,OpctagsJdbcImpl opctagsJdbc)
	{
		this.assetsJdbc = assetsJdbc;
		this.opctagsJdbc = opctagsJdbc;
		
	}
	
	public static Map<String,NodeId> getNodeIds(String opcHostIP,String nodeType)
	{
		List<Asset> assets;
		List<Opctag> opctags = null;
		Map<String,NodeId> nodeIds = new HashMap<String,NodeId>();
		
		assets = assetsJdbc.getAssetsData(opcHostIP);
		
		switch(nodeType)
		{	
		
		case "livedata":
			opctags= opctagsJdbc.getKPIdataOPCtags1();
			break;
			
		case "alarm":
			opctags= opctagsJdbc.getAlarmOPCtags();
			break;
			
		default :
			opctags= opctagsJdbc.getKPIdataOPCtags1();
		}
		
		for(Asset asset : assets)
		 {			 
			 for(Opctag opctag :opctags)
			 {				
				 String ni = "ns=2;s="+asset.getAssetName()+"."+opctag.getOpctagName();				 
				 NodeId nodeId = NodeId.parseNodeId(ni);
				 String uniqueTagId = asset.getAssetId()+"-"+opctag.getTagId();
				 nodeIds.put(uniqueTagId, nodeId);
			 }
		
	}
		return nodeIds;
		
	}
}
