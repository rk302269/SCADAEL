package com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.dao.AssetsJdbcDao;
import com.gepower.renewables.scadaedgelite.opcuaclient.daomapper.AssetDataColumnMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Asset;

@Repository
public class AssetsJdbcImpl implements AssetsJdbcDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	private static final String TABLE_NAME = "scadael.asset_master"; 
	
	@Autowired
	public AssetsJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}
	
	@Override
	public List<Asset> getAssetsData()
	{
		String sqlQuery = 
				"select asset_id,asset_name,opcserver_type,"
				+ "asset_type,oem,asset_ip from "+TABLE_NAME
				+ " where opc_host_ip='10.119.166.35'";
		List<Asset> assetData = jdbcTemplate.query(sqlQuery, new AssetDataColumnMapper());
		return assetData;	
	}
	
	@Override
	public List<Asset> getAssetsData(String hostIP)
	{
		String sqlQuery = 
				"select asset_id,asset_name,opcserver_type,"
				+ "asset_type,oem,asset_ip from "+TABLE_NAME
				+ " where opc_host_ip='10.119.166.35'";
		List<Asset> assetData = jdbcTemplate.query(sqlQuery, new AssetDataColumnMapper());
		return assetData;	
	}
	
	
	public Asset getAssetDetails(int assetId)
	{
		String sqlQuery = 
				"select asset_id,asset_name,opcserver_type,"
				+ "asset_type,oem,asset_ip from  "+TABLE_NAME
				+ " where asset_id=?";
		
		Object[] params ={assetId};
		Asset assetDetails = 
				(Asset)jdbcTemplate.queryForObject(sqlQuery,params, new AssetDataColumnMapper());
		return assetDetails;
	}
	
	
	public Asset getAssetDetails(String assetName)
	{
		String sqlQuery = 
				"select asset_id,asset_name,opcserver_type,"
				+ "asset_type,oem,asset_ip from  "+TABLE_NAME
				+ " where asset_name=?";
		
		Object[] params ={assetName};
		Asset assetDetails = 
				(Asset)jdbcTemplate.queryForObject(sqlQuery,params, new AssetDataColumnMapper());
		return assetDetails;
	}
	
	
	
}
