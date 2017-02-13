package com.gepower.renewables.scadaedgelite.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.gepower.renewables.scadaedgelite.dao.AlarmMapper;
import com.gepower.renewables.scadaedgelite.dao.CmdEventLogMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Alarm;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.CmdEventLog;

@Repository
public class AlarmDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AlarmDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =jdbcTemplate;
	}
	
	
	
	public List<Alarm> getAlarmsList() {
       // String source = "SWPCL-09";
		List<Alarm> alarm;
			System.out.println("in null comdition");
			String sqlQuesry = "select * from scadael.alarm_data order by asset_name";
			alarm = jdbcTemplate.query(sqlQuesry, new AlarmMapper());	
		return alarm;
	}
	public List<Alarm> filterAlarmsList(String assetName) {
	       // String source = "SWPCL-09";
			List<Alarm> alarm;
			System.out.println("in value comdition"+assetName);
			String sqlQuesry = "select * from scadael.alarm_data where asset_name ='"+assetName+"'";
			alarm = jdbcTemplate.query(sqlQuesry, new AlarmMapper());	
			return alarm;
		}
	 public List<CmdEventLog> getCmdEventLogs() {
	        // String source = "SWPCL-09";
		 	List<CmdEventLog> cmdevntlogs;
	 		String sqlQuesry = "select * from scadael.cmd_event_log";
	 		cmdevntlogs = jdbcTemplate.query(sqlQuesry, new CmdEventLogMapper());
	 		return cmdevntlogs;
	 	}

	    public List<CmdEventLog> getCmdEventLogs(String assetName) {
	    	List<CmdEventLog> cmdevntlogs;
	 		String sqlQuesry = "select * from scadael.cmd_event_log where asset_name='"+assetName+"'";
	 		 cmdevntlogs = jdbcTemplate.query(sqlQuesry, new CmdEventLogMapper());
	 		return cmdevntlogs;
	 	}
}