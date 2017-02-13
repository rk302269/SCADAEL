package com.gepower.renewables.scadaedgelite.opcuaclient.daomapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.Asset;


public class AssetDataColumnMapper implements RowMapper<Asset> {

	@Override
	public Asset mapRow(ResultSet resultSet, int row) throws SQLException {
		
		Asset assetBean = new Asset();
		assetBean.setAssetId(resultSet.getInt("asset_id"));
		assetBean.setAssetName(resultSet.getString("asset_name"));
		assetBean.setOpcserverType(resultSet.getString("opcserver_type"));
		assetBean.setAssetType(resultSet.getString("asset_type"));
		assetBean.setOem(resultSet.getString("oem"));
		assetBean.setAssetIp(resultSet.getString("asset_ip"));
		
		return assetBean;
	}
	
	

}
