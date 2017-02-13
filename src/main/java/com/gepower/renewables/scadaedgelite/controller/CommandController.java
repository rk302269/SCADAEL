package com.gepower.renewables.scadaedgelite.controller;

import java.util.Collection;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.CmdEventLog;
import com.gepower.renewables.scadaedgelite.repository.CommandRepository;


@Repository
@RestController
public class CommandController {
	
	private CommandRepository commandRepository; 
	public CommandController(CommandRepository commandRepository){
		this.commandRepository = commandRepository;
	}
	
	
		@RequestMapping(value = "sendCommand", method=RequestMethod.POST)
		public ResponseEntity<String> sendCommand(
				@RequestParam(value="assets", required=false) String[] assets,
				@RequestParam(value="commandId", required=false) Integer commandId
			   ,@RequestParam(value="cmdValue", required=false) String cmdValue) {
			
			commandRepository.sendCommand(assets,commandId,cmdValue);
			boolean validated = true;
			if(!validated)
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
				HttpHeaders httpHeaders = new HttpHeaders();
				return new ResponseEntity<String>("Action created successfully.", httpHeaders, HttpStatus.OK);
		}
		
		
		@CrossOrigin(origins = "http://localhost:9000")
		@RequestMapping(value = "/commandeventlogs", method = RequestMethod.GET)
		public Collection<CmdEventLog> getCommandEventlogs(
				@RequestParam(value="assetName", required=false) String []assetName,
				@RequestParam(value="startDate", required=false) String startDate,
				@RequestParam(value="endDate", required=false) String endDate
			){
		    /*startDate = "01/04/2017 08:49:23";
			endDate ="01/04/2017 08:51:46";*/
			System.out.println("assetName:::::"+assetName);
			System.out.println("startDate:::::"+startDate);
			System.out.println("endDate::::::::::::::"+endDate);
			
			System.out.println();
			if(startDate != null && endDate != null){
				return commandRepository.getCmdDataLogsByDate(startDate,endDate);
				
			}else{
				return commandRepository.getCmdDataLogs(assetName);
			}
			
		}
	}
