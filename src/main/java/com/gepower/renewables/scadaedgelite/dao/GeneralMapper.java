package com.gepower.renewables.scadaedgelite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;



public class GeneralMapper implements RowMapper<KPIData>{
	 @Override
	    public KPIData mapRow(ResultSet rs, int row) throws SQLException {
		 		KPIData general = new KPIData();
		 		general.setAssetName(rs.getString("asset_name"));
		 		general.setOpctagName(rs.getString("opctag_name"));
		 		general.setOpctagValue(rs.getString("opctag_value"));
	    		return general;
	    }
	}
