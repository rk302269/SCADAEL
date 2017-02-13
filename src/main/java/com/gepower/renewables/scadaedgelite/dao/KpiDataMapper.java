package com.gepower.renewables.scadaedgelite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.AssetData;



public class KpiDataMapper implements RowMapper<AssetData> {
	@Override
	public AssetData mapRow(ResultSet rs, int row) throws SQLException {
		AssetData assets = new AssetData();
		assets.setTagValue(rs.getString("opctag_value"));
		assets.setOpcTagName(rs.getString("opctag_name"));
		return assets;
	}
}
