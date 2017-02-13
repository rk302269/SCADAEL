package com.gepower.renewables.scadaedgelite.opcuaclient.daomapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;

public class KPIDataColumnMapper implements RowMapper<KPIData> {

	@Override
	public KPIData mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		KPIData liveDataBean = new KPIData();
		liveDataBean.setAssetId(resultSet.getInt("asset_id"));
		liveDataBean.setTagId(resultSet.getInt("opctag_id"));
		liveDataBean.setOpctagValue(resultSet.getString("opctag_value"));
		return liveDataBean;
	}

}
