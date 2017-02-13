package com.gepower.renewables.scadaedgelite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.Alarm;


public class AlarmMapper implements RowMapper<Alarm>{
	 @Override
	    public Alarm mapRow(ResultSet rs, int row) throws SQLException {
		 		Alarm alarm = new Alarm();
		 		alarm.setAssetName(rs.getString("asset_name"));
		 		alarm.setAlarmName(rs.getString("alarm_name"));
		 		alarm.setState(rs.getString("state"));
		 		alarm.setTime(rs.getString("time_stamp"));
		 		alarm.setDescription(rs.getString("description"));
	    		return alarm;
	    }

}
