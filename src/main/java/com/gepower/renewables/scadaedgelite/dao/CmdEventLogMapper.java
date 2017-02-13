package com.gepower.renewables.scadaedgelite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.CmdEventLog;


public class CmdEventLogMapper implements RowMapper<CmdEventLog>{
	    @Override
	    public CmdEventLog mapRow(ResultSet rs, int row) throws SQLException {
	    		CmdEventLog cmdeventlogs = new CmdEventLog();
	    		cmdeventlogs.setAssetName(rs.getString("asset_name"));
	    		cmdeventlogs.setLogType(rs.getString("log_type"));
	    		cmdeventlogs.setLogName(rs.getString("log_name"));
	    		cmdeventlogs.setLogDescription(rs.getString("log_description"));
	    		cmdeventlogs.setLogTime(rs.getString("log_time"));
	    		
	    		
	    		return cmdeventlogs;
	    }
	}

	
	

