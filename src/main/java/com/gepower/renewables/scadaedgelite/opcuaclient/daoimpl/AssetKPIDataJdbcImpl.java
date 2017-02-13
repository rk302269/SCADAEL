package com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.dao.AssetKPIDataJdbcDao;
import com.gepower.renewables.scadaedgelite.opcuaclient.daomapper.KPIDataColumnMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;

@Repository
public class AssetKPIDataJdbcImpl implements AssetKPIDataJdbcDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;	

	private static final String TABLE_NAME = "scadael.asset_livedata"; 
	private static final String SITE_TABLE_NAME = "scadael.site_kpi_data";
	
	@Autowired
	public AssetKPIDataJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}
		
	public AssetKPIDataJdbcImpl() 
	{
		super();		
	}

	
	
	@Override
	public int getRowCount(int assetId, int tagId)
	{

		String selectSqlQuery = 
				"select count(*) from "+TABLE_NAME+" where asset_id=? and opctag_id=?";

		Object[] params ={assetId,tagId};

		int rowCount = jdbcTemplate.queryForObject(selectSqlQuery, params,Integer.class);

		return rowCount;

	}
	
	@Override
    public KPIData getLiveData(int assetId, int tagId, String tableName)
	{

		String selectSqlQuery = 
				"select asset_id,opctag_id,opctag_value from "
						+ tableName
						+ " where asset_id= ? and opctag_id=?";

		Object[] params = {assetId,tagId};
		KPIData liveDataBean = 
				(KPIData)jdbcTemplate.queryForObject(selectSqlQuery,params, new KPIDataColumnMapper());
		return liveDataBean;
	}
	
	@Override
	public List<KPIData> getAssetKPIParamValue(String kPIParam)
	{
		String sqlQuery = 
				"select asset_id,opctag_id,opctag_value from "
				+ TABLE_NAME
				+ " where opctag_name =?";
		
		Object[] params = {kPIParam};
		List<KPIData> assetData = jdbcTemplate.query(sqlQuery,params, new KPIDataColumnMapper());
		return assetData;	
	}
	
	
	public List<KPIData> getAssetKPIParamValue(int assetId, int tagId1, int tagId2)
	{
		String sqlQuery = 
				"select asset_id,opctag_id,opctag_value from "
				+ TABLE_NAME
				+ " where asset_id = ? and opctag_id in (?,?)";
		
		Object[] params = {assetId,tagId1,tagId2};
		List<KPIData> assetData = jdbcTemplate.query(sqlQuery,params, new KPIDataColumnMapper());
		return assetData;	
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
		catch (Exception e) {
			System.out.println(e);
		}
	}
    
	@Override
	public void insertBatchLiveData(List<KPIData> livedata)
	{
		try{
			String insertSqlQuery = 
					"insert into "+ TABLE_NAME
					+ " (asset_id,asset_name,opctag_id,opctag_name,opctag_value,livedata_received_time) "
					+ "values(?,?,?,?,?,?)";

			jdbcTemplate.batchUpdate(insertSqlQuery, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					KPIData ld = livedata.get(i);
					ps.setInt(1, ld.getAssetId());
					ps.setString(2, ld.getAssetName());
					ps.setInt(3, ld.getTagId());
					ps.setString(4, ld.getOpctagName());
					ps.setString(5, ld.getOpctagValue());
					ps.setString(6, ld.getLivedataReceivedTime());
				}

				@Override
				public int getBatchSize() {

					return livedata.size();
				}
			});		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
  
	public void updateBatchLiveData(List<KPIData> livedata)
	{
		try{
			String updateSqlQuery = 
					"update  "+ TABLE_NAME
					+ " set opctag_value=?,livedata_received_time=? where asset_id= ? and opctag_id=?";

			jdbcTemplate.batchUpdate(updateSqlQuery, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					KPIData ld = livedata.get(i);
					
					ps.setString(1, ld.getOpctagValue());
					ps.setString(2, ld.getLivedataReceivedTime());
					ps.setInt(3, ld.getAssetId());
					ps.setInt(4, ld.getTagId());
	
				}

				@Override
				public int getBatchSize() {

					return livedata.size();
				}
			});		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Override
	public void updateLiveData(String tagValue, String timeStamp, int assetId, int tagId)
	{
		try{
			String updateSqlQuery = 
					"update "+TABLE_NAME
					+ " set opctag_value=?,livedata_received_time=? where asset_id= ? and opctag_id=?";

			Object[] params = {tagValue,timeStamp,assetId,tagId};
			jdbcTemplate.update(updateSqlQuery,params);

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void updateSiteKPIData(String sitePower, String timeStamp, int assetId, int tagId)
	{
		try{
			String deleteSqlQuery = 
					"update "+SITE_TABLE_NAME
					+ " set opctag_value=?,livedata_received_time=? where asset_id= ? and opctag_id=?";

			Object[] params = {sitePower,timeStamp,assetId,tagId};
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
		catch (Exception e) {
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
		catch (Exception e) {
			System.out.println(e);
		}
	}

	


	
	
}
