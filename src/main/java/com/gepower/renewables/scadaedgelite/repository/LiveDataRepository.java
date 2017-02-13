package com.gepower.renewables.scadaedgelite.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.dao.impl.AssetsDaoImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.AssetData;

@Repository
public class LiveDataRepository {

	private  Map<String, AssetData> liveDataMap = new HashMap<>();
	@Autowired
	private AssetsDaoImpl assetsDaoImpl;
	
	@Autowired
	public LiveDataRepository(AssetsDaoImpl assetsDaoImpl){
		this.assetsDaoImpl =assetsDaoImpl;
		
	}

	public Collection<AssetData> getLiveData(){
		List<AssetData> assetList = assetsDaoImpl.getAssetsList();
		String val="";
		int i = 1;
		for(Iterator<AssetData> iter=assetList.iterator();iter.hasNext();){
			i=i+1;
			val = Integer.toString(i);
			AssetData assets = iter.next();
			assets.setAssetName(assets.getAssetName());
			
			liveDataMap.put(val,assets);
			
		}
		return liveDataMap.values();
	}
	
	
	public Collection<AssetData> getLiveKpiData(){
		List<AssetData> kpitList = assetsDaoImpl.getLiveKpiData();
		return kpitList;
	}
}
