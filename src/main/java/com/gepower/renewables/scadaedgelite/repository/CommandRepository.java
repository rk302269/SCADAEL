package com.gepower.renewables.scadaedgelite.repository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gepower.renewables.scadaedgelite.dao.impl.CommandDaoImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.CmdEventLog;

@Repository
public class CommandRepository {
	@Autowired
	private CommandDaoImpl commandDaoImpl;
	@Autowired
	public CommandRepository(CommandDaoImpl commandDaoImpl)
	{
		this.commandDaoImpl = commandDaoImpl;
	}
	private Map<String, CmdEventLog> cmdEventLogsmap = new HashMap<>();
	
	public boolean sendCommand(String []assets,Integer commandId,String cmdValues){
		if(assets.length == 1){
			String asset = assets[0];
			commandDaoImpl.sendCommand(asset, commandId, cmdValues);
		}else{

			if(assets.length == 2){
				String asset = assets[0];
				commandDaoImpl.sendCommand(asset, commandId, cmdValues);
			}else{
				for(int i=0;i<assets.length-1;i++){
					String asset = assets[i];
					commandDaoImpl.sendCommand(asset, commandId, cmdValues);
				}
			}
		}
		return true;
	}

	public  Collection<CmdEventLog> getCmdDataLogs(String []assetName){
		//List<CmdEventLog> cmdeventLoglist = new ArrayList<CmdEventLog>();
		//long logEndTime =System.currentTimeMillis()/1000;
		//long logStartTime =(System.currentTimeMillis()/1000)-(24 * 60 * 60);
		String val="";
		int i = 1;
		List<CmdEventLog> firstList = new ArrayList<CmdEventLog>(); 	
		List<CmdEventLog> logList = new ArrayList<CmdEventLog>(); 
		String asset="";
		if(assetName == null || assetName.equals("") ){
			System.out.println("Rnter no value");
			logList = commandDaoImpl.getCmdEventLogs();

		}else{
			System.out.println("Enter in else"+assetName.length);
			for(int j=0;j<assetName.length;j++){
				asset = assetName[j];
				firstList = commandDaoImpl.getCmdEventLogs(asset);
				logList.addAll(firstList);
			}
		}
		for(Iterator<CmdEventLog> iter=logList.iterator();iter.hasNext();){
			i=i+1;
			val = Integer.toString(i);
			CmdEventLog cmdeventlog = iter.next();
			cmdEventLogsmap.put(val,cmdeventlog);
		}
		return cmdEventLogsmap.values();
	}
	
	public  Collection<CmdEventLog> getCmdDataLogsByDate(String startDate,String endDate){
		String val="";
		int i = 1;
		List<CmdEventLog> logList = new ArrayList<CmdEventLog>(); 
		Map<String, CmdEventLog> filtercmdEventLogsmap = new HashMap<>();
		logList = commandDaoImpl.getCmdEventLogsByDate(startDate,endDate);
		System.out.println("logList::::::::"+logList.size());
		
		
		for(Iterator<CmdEventLog> iter=logList.iterator();iter.hasNext();){
			i=i+1;
			val = Integer.toString(i);
			CmdEventLog cmdeventlog = iter.next();
			filtercmdEventLogsmap.put(val,cmdeventlog);
		}
		return filtercmdEventLogsmap.values();
	}
	
}
