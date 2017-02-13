package com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.dao.CommandJdbcDao;
import com.gepower.renewables.scadaedgelite.opcuaclient.daomapper.CommandsColumnMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Command;

@Repository
public class CommandJdbcImpl implements CommandJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	private static final String TABLE_NAME = "scadael.command_data_tracker"; 

	@Autowired
	public CommandJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}
	
	@Override
	public List<Command> getCommands() {
		
		String sqlQuery = 
				"select asset_name,cmd_tag_id,cmd_value,cmd_send_time,"
				+ "status_flag from  "+ TABLE_NAME
				+ " where status_flag is null";
		
		List<Command> commands = jdbcTemplate.query(sqlQuery, new CommandsColumnMapper());
		return commands;
		
	}
	
	@Override
	public void updateCommandData(int opcTagId)
	{
		try{
		String sqlQuery = 
				"update "+ TABLE_NAME
				+ " set status_flag = 'Processed' where cmd_tag_id=?";
		
		Object[] params = {opcTagId};
		jdbcTemplate.update(sqlQuery,params);
		System.out.println("Updated the Record in Command Data Tracker Table..!");
		
	}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
