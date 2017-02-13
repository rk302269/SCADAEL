package com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RowCountJdbcImpl {

	@Autowired
	private static JdbcTemplate jdbcTemplate;

	@Autowired
	public RowCountJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}

	public int getRowCount(String tableName, int assetId, int tagId)
	{

		String selectSqlQuery = 
				"select count(*) from "+tableName+" where asset_id=? and opctag_id=?";

		Object[] params ={assetId,tagId};
		
		int rowCount = jdbcTemplate.queryForObject(selectSqlQuery, params,Integer.class);

		return rowCount;

	}

	public int getRowCount(String tableName)
	{

		String selectSqlQuery = 
				"select count(*) from "+tableName+" where opcserver_type='GE001656'";
		
		int rowCount = jdbcTemplate.queryForObject(selectSqlQuery, null, Integer.class);

		return rowCount;

	}
}
