package com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.dao.SiteKPIDataJdbcDao;
import com.gepower.renewables.scadaedgelite.opcuaclient.daomapper.KPIDataColumnMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;

@Repository
public class SiteKPIDataJdbcImpl implements SiteKPIDataJdbcDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;	

	private static final String TABLE_NAME = "scadael.site_kpi_data"; 

	@Autowired
	public SiteKPIDataJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}

	@Override
	public KPIData getLiveData(int assetId, int tagId)
	{

		String selectSqlQuery = 
				"select asset_id,opctag_id,opctag_value from "
						+ TABLE_NAME
						+ " where asset_id= ? and opctag_id=?";

		Object[] params = {assetId,tagId};
		KPIData liveDataBean = 
				(KPIData)jdbcTemplate.queryForObject(selectSqlQuery,params, new KPIDataColumnMapper());
		return liveDataBean;
	}	

	@Override
	public void insertLiveData(int assetId, String assetName, int tagId, String opctagName, String tagValue, String timeStamp)
	{
		try{
			String insertSqlQuery = 
					"insert into "+TABLE_NAME
					+ " (asset_id,asset_name,opctag_id,opctag_name,opctag_value,livedata_received_time) "
					+ "values(?,?,?,?,?,?)";

			Object[] params = {assetId,assetName,tagId,opctagName,tagValue,timeStamp};
			jdbcTemplate.update(insertSqlQuery,params);

		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	@Override
	public void updateLiveData(String tagValue, String timeStamp, int assetId, int tagId)
	{
		try{
			String deleteSqlQuery = 
					"update "+TABLE_NAME
					+ " set opctag_value=?,livedata_received_time=? where asset_id= ? and opctag_id=?";

			Object[] params = {tagValue,timeStamp,assetId,tagId};
			jdbcTemplate.update(deleteSqlQuery,params);

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteLiveData(int assetId, int tagId)
	{
		try{
			String deleteSqlQuery = 
					"delete from "+ TABLE_NAME
					+ " where asset_id= ? and opctag_id=?";

			Object[] params = {assetId,tagId};
			jdbcTemplate.update(deleteSqlQuery,params);

		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	@Override
	public void deleteLiveData()
	{
		try{
			String deleteSqlQuery = "delete from "+ TABLE_NAME;

			jdbcTemplate.update(deleteSqlQuery);

		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}


}
