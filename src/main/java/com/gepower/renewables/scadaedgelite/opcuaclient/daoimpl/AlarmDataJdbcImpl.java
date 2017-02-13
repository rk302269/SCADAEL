package com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.dao.AlarmDataJdbcDao;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Alarm;

@Repository
public class AlarmDataJdbcImpl implements AlarmDataJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;	

	private static final String TABLE_NAME = "scadael.alarm_data"; 

	@Autowired
	public AlarmDataJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}

	@Override
	public int getRowCount(String assetName, String alarmName)
	{

		String selectSqlQuery = 
				"select count(*) from "+TABLE_NAME+" where asset_name=? and alarm_name=?";

		Object[] params ={assetName,alarmName};

		int rowCount = jdbcTemplate.queryForObject(selectSqlQuery, params,Integer.class);

		return rowCount;

	}

	@Override
	public void insertAlarmData(String assetName,String alarmName, String alarmDescription, String tagValue, String timeStamp)
	{
		try{
			String insertSqlQuery = 
					"insert into  "+ TABLE_NAME
					+ " (asset_name,alarm_name,description,state,time_stamp) values(?,?,?,?,?)";

			Object[] params = {assetName, alarmName, alarmDescription, tagValue, timeStamp};
			jdbcTemplate.update(insertSqlQuery,params);

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}



	@Override
	public void insertBatchAlarmData(List<Alarm> alarms)
	{
		try{
			String insertSqlQuery = 
					"insert into "+ TABLE_NAME
					+ " (asset_name,alarm_name,description,state,time_stamp) "
					+ "values(?,?,?,?,?)";

			jdbcTemplate.batchUpdate(insertSqlQuery, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {

					Alarm alarm = alarms.get(i);

					
						ps.setString(1, alarm.getAssetName());
						ps.setString(2, alarm.getAlarmName());
						ps.setString(3, alarm.getDescription());
						ps.setString(4, alarm.getState());
						ps.setString(5, alarm.getTime());
					
				}

				@Override
				public int getBatchSize() {

					return alarms.size();
				}
			});		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}


	@Override
	public void updateAlarmData(String tagValue, String timeStamp, int assetId, int tagId)
	{
		try{
			String deleteSqlQuery = 
					"update "+ TABLE_NAME
					+ " set opctag_value=?,livedata_received_time=? where asset_id= ? and opctag_id=?";

			Object[] params = {tagValue,timeStamp,assetId,tagId};
			jdbcTemplate.update(deleteSqlQuery,params);

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteAlarmData(String assetName, String alarmName)
	{
		try{
			String deleteSqlQuery = 
					"delete from "+ TABLE_NAME
					+ " where asset_name= ? and alarm_name=?";

			Object[] params = {assetName,alarmName};
			jdbcTemplate.update(deleteSqlQuery,params);

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteAlarmData()
	{
		try{
			String deleteSqlQuery = "delete from "+TABLE_NAME;

			jdbcTemplate.update(deleteSqlQuery);

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}



}
