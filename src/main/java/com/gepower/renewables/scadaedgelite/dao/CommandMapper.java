package com.gepower.renewables.scadaedgelite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.Command;

public class CommandMapper implements RowMapper<Command>{ 
	 @Override
	    public Command mapRow(ResultSet rs, int row) throws SQLException {
	    		Command command = new Command();
	    		command.setTagId(rs.getInt("tag_id"));
	    		command.setTagName(rs.getString("opc_tag_name"));
	    		command.setDisplayName(rs.getString("display_name"));
	    		return command;
	    }
}
