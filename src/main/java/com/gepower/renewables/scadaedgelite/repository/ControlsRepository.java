package com.gepower.renewables.scadaedgelite.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gepower.renewables.scadaedgelite.dao.impl.ControlsDaoImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;

@Repository
public class ControlsRepository {
	
	@Autowired
	private ControlsDaoImpl controlsDaoImpl;
	
	@Autowired
	public ControlsRepository(ControlsDaoImpl controlsDaoImpl){
		this.controlsDaoImpl = controlsDaoImpl;
	}
	
		
	public Collection<KPIData> getGeneral(String assetName){
		Map<String, KPIData> generalDataMap = new HashMap<>();
		List<KPIData> generalList = new ArrayList<KPIData>(); 
		generalList = controlsDaoImpl.getGeneralList(assetName);
			String val="";
			int i = 1;
			for(Iterator<KPIData> iter=generalList.iterator();iter.hasNext();){
				 i=i+1;
				 val = Integer.toString(i);
				 KPIData general = iter.next();
				 generalDataMap.put(val,general);
			}
			return generalDataMap.values();
	}
	
	
	public Collection<KPIData> getPitch(String assetName){
		List<KPIData> pitchDataList = new ArrayList<KPIData>(); 	
		
		Map<String, KPIData> pitchDataMap = new HashMap<>();
		
		pitchDataList = controlsDaoImpl.getPitchData(assetName);
			String val="";
			int i = 1;
		
			for(Iterator<KPIData> iter=pitchDataList.iterator();iter.hasNext();){
				 i=i+1;
				 val = Integer.toString(i);
				 KPIData general = iter.next();
				 pitchDataMap.put(val,general);
			}
			return pitchDataMap.values();
	}
	
}


