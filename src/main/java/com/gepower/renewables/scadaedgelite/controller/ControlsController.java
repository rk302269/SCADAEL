package com.gepower.renewables.scadaedgelite.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;
import com.gepower.renewables.scadaedgelite.repository.ControlsRepository;

@Repository
@RestController
public class ControlsController {
	@Autowired
	ControlsRepository controlsRepository;
	
	@Autowired
	public ControlsController(ControlsRepository controlsRepository){
		this.controlsRepository = controlsRepository;
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "/general", method = RequestMethod.GET)
	public Collection<KPIData> getGeneral(@RequestParam(value="assetName", required=false) String assetName){
		return controlsRepository.getGeneral(assetName);
	}
	
	
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "/pitch", method = RequestMethod.GET)
	public Collection<KPIData> getPitch(@RequestParam(value="assetName", required=false) String assetName){
		return controlsRepository.getPitch(assetName);
	}
	
	
}
