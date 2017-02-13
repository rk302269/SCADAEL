package com.gepower.renewables.scadaedgelite.controller;

import java.util.Collection;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.AssetData;
import com.gepower.renewables.scadaedgelite.repository.LiveDataRepository;

@Repository
@RestController
public class LivedataController {

	LiveDataRepository liveDataRepository;
	
	public LivedataController(LiveDataRepository liveDataRepository){
		this.liveDataRepository =liveDataRepository;
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "/livedata", method = RequestMethod.GET)
	public Collection<AssetData> getLiveData(){
		return liveDataRepository.getLiveData();
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "kpidata", method = RequestMethod.GET)
	public Collection<AssetData> getLiveKpiData(){
		return liveDataRepository.getLiveKpiData();
	}
	
}
