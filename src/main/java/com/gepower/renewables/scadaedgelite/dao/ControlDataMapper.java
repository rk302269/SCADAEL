package com.gepower.renewables.scadaedgelite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;



public class ControlDataMapper implements RowMapper<KPIData>{
	 @Override
	    public KPIData mapRow(ResultSet rs, int row) throws SQLException {
		 		KPIData kpiData = new KPIData();
		 		kpiData.setAssetId(rs.getInt("asset_id"));
		 		kpiData.setAssetName(rs.getString("asset_name"));
		 		kpiData.setLivedataReceivedTime(rs.getString("data_received_time"));
		 		kpiData.setOpctagName(rs.getString("opctag_name"));
		 		kpiData.setOpctagValue(rs.getString("opctag_value"));
		 		kpiData.setTagId(rs.getInt("opctag_id"));
	    		return kpiData;
	    }
	}
