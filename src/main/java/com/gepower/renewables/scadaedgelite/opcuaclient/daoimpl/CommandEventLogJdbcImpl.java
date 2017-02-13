package com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.dao.CommandEventLogJdbcDao;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.CmdEventLog;

@Repository
public class CommandEventLogJdbcImpl implements CommandEventLogJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;	

	private static final String TABLE_NAME = "scadael.cmd_event_log"; 

	@Autowired
	public CommandEventLogJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}

	@Override
	public void insertCommandEventlogs(String assetName, String logType, String logName, String logDescription,
			String logTime) {
		try{
			String insertSqlQuery = 
					"insert into  "+ TABLE_NAME
					+ "(asset_name,log_type,log_name,log_description,log_time) "
					+ "values(?,?,?,?,?)";

			Object[] params = {assetName,logType,logName,logDescription,logTime};
			jdbcTemplate.update(insertSqlQuery,params);

		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void insertBatchCommandEventLogs(List<CmdEventLog> commandEventLog) {
		try{
			String insertSqlQuery = 
					"insert into  "+ TABLE_NAME
					+ "(asset_name,log_type,log_name,log_description,log_time) "
					+ "values(?,?,?,?,?)";


			jdbcTemplate.batchUpdate(insertSqlQuery, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					CmdEventLog cel = commandEventLog.get(i);
					ps.setString(1, cel.getAssetName());
					ps.setString(2, cel.getLogType());
					ps.setString(3, cel.getLogName());
					ps.setString(4, cel.getLogDescription());
					ps.setString(5, cel.getLogTime());

				}

				@Override
				public int getBatchSize() {
					// TODO Auto-generated method stub
					return commandEventLog.size();
				}
			});		
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}


	@Override
	public void deleteCommandEventlogs(String assetName) {
		try{
			String deleteSqlQuery = 
					"delete from "+TABLE_NAME+" where asset_name= ?";

			Object[] params = {assetName};
			jdbcTemplate.update(deleteSqlQuery,params);

		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void deleteCommandEventlogs() {
		try{
			String deleteSqlQuery = "delete from "+TABLE_NAME;			

			jdbcTemplate.update(deleteSqlQuery);

		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
