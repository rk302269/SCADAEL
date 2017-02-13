package com.gepower.renewables.scadaedgelite.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.dao.ControlDataMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;
	

@Repository
public class ControlsDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	public ControlsDaoImpl(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}
	public List<KPIData> getGeneralList(String assetName) {
			List<KPIData> general;
				String sqlQuesry = "select * from scadael.general_control_data where asset_name = '"+assetName+"'";
				general = jdbcTemplateObject.query(sqlQuesry, new ControlDataMapper());	
			return general;
		}
	public List<KPIData> getPitchData(String assetName) {
		List<KPIData> general;
			String sqlQuesry = "select * from scadael.pitch_control_data where asset_name = '"+assetName+"' order by opctag_id";
			System.out.println("sqlQuesry::::"+sqlQuesry);
			general = jdbcTemplateObject.query(sqlQuesry, new ControlDataMapper());	
		return general;
	}

	
}
