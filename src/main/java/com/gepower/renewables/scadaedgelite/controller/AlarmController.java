package com.gepower.renewables.scadaedgelite.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Alarm;
import com.gepower.renewables.scadaedgelite.repository.AlarmSourceRepository;

@Repository
@RestController
public class AlarmController {
	@Autowired
	AlarmSourceRepository alarmSourceRepository;
	
	@Autowired
	public AlarmController(AlarmSourceRepository alarmSourceRepository){
		this.alarmSourceRepository = alarmSourceRepository;
	}
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "/alerts", method = RequestMethod.GET)
	public Collection<Alarm> getAlarms(@RequestParam(value="assetName", required=false) String [] assetName){
			return alarmSourceRepository.getAlarms(assetName);
	}
	
	
}
