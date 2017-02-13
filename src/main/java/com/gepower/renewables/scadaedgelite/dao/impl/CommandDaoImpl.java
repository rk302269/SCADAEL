package com.gepower.renewables.scadaedgelite.dao.impl;


import java.sql.Types;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.dao.CmdEventLogMapper;
import com.gepower.renewables.scadaedgelite.dao.CommandMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.CmdEventLog;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Command;

@Repository
public class CommandDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}
	public List<Command> getTagList() {
		String sqlQuesry = "select * from scadael.opc_tags_master where type='cmd'";
		List<Command> command = jdbcTemplateObject.query(sqlQuesry, new CommandMapper());
		return command;
	}
	public boolean sendCommand(String assets,Integer commandId,String cmdValue){
		saveRecord(assets, commandId, cmdValue);
			return true;
		}
    public void saveRecord(String assets,Integer commandId,String cmdValue) {
        Object[] params = new Object[] { assets, commandId, cmdValue, new Date() };
        int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.TIMESTAMP };
        String insertSql = "insert into scadael.command_data_tracker(asset_name,cmd_tag_id,cmd_value,cmd_send_time) values(?,?,?,?)";
        int row = jdbcTemplateObject.update(insertSql, params, types);
        System.out.println(row + " row inserted.");
    }
	
    public List<CmdEventLog> getCmdEventLogs() {
    	List<CmdEventLog> cmdevntlogs;
    	String sqlQuesry = "select * from scadael.cmd_event_log";
    	cmdevntlogs= jdbcTemplateObject.query(sqlQuesry, new CmdEventLogMapper());
 		return cmdevntlogs;
 	}
    public List<CmdEventLog> getCmdEventLogs(String assetName) {
    	List<CmdEventLog> cmdevntlogs;
    	String sqlQuesry = "select * from scadael.cmd_event_log where asset_name='"+assetName+"'";
    	//String sqlQuesry = "select * from scadael.cmd_event_log where asset_name='"+assetName+"'";
 		cmdevntlogs= jdbcTemplateObject.query(sqlQuesry, new CmdEventLogMapper());
 		return cmdevntlogs;
 	}
    
    public List<CmdEventLog> getCmdEventLogsByDate(String startDate,String endDate) {
    	List<CmdEventLog> cmdevntlogs;
    	String sqlQuesry = "select * from scadael.cmd_event_log where log_time BETWEEN '"+startDate+"' AND '"+endDate+"'";
    	System.out.println("sqlQuesry:::::"+sqlQuesry);
    	cmdevntlogs= jdbcTemplateObject.query(sqlQuesry, new CmdEventLogMapper());
 		return cmdevntlogs;
 	}
}
