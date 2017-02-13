package com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.dao.OpctagsJdbcDao;
import com.gepower.renewables.scadaedgelite.opcuaclient.daomapper.OpctagsColumnMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Opctag;

@Repository
public class OpctagsJdbcImpl implements OpctagsJdbcDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	private static final String TABLE_NAME = "scadael.opctags_master"; 

	@Autowired
	public OpctagsJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}

	
	public List<Opctag> getKPIdataOPCtags()
	{
		String sqlQuery = "select tag_id,opc_tag_name,display_name,description,"
				+ "units,type,alias,subs_interval,need_value,asset_type,has_permission,"
				+ "opcserver_type,oem,tag_datatype from "+ TABLE_NAME
				+ " where tag_id in(10001,10002,10003,10018') ";

		List<Opctag> opctags = jdbcTemplate.query(sqlQuery, new OpctagsColumnMapper());
		return opctags;
	}
	
	public List<Opctag> getKPIdataOPCtags1()
	{
		String sqlQuery = "select tag_id,opc_tag_name,display_name,description,"
				+ "units,type,alias,subs_interval,need_value,asset_type,has_permission,"
				+ "opcserver_type,oem,tag_datatype from "+ TABLE_NAME
				+ " where tag_id in(10001,10002,10003,10004,10005,10006,10007,10008,10009,"
				+ "10010,10011,10012,10013,10014,10015,10016,10017,10018,10226,10228,10230,10502,10466,10488,10899,11419,11721,"
				+ "11747,11748,11749,11667,11668,11691,11692,11693,11694,11695,11696,11711,"
				+ "11712,11713,11714,11720,11727,11728,11729,11730,11740,11722,11751,11752,11753,11754) ";
	
		List<Opctag> opctags = jdbcTemplate.query(sqlQuery, new OpctagsColumnMapper());
		return opctags;
	}
	
	public List<Opctag> getKPIdataOPCtags2()
	{
		String sqlQuery = "select tag_id,opc_tag_name,display_name,description,"
				+ "units,type,alias,subs_interval,need_value,asset_type,has_permission,"
				+ "opcserver_type,oem,tag_datatype from "+ TABLE_NAME
				+ " where tag_id in(10004,10899) ";
	
		List<Opctag> opctags = jdbcTemplate.query(sqlQuery, new OpctagsColumnMapper());
		return opctags;
	}

	@Override
	public List<Opctag> getAlarmOPCtags()
	{
		String sqlQuery = "select tag_id,opc_tag_name,display_name,description,"
				+ "units,type,alias,subs_interval,need_value,asset_type,has_permission,"
				+ "opcserver_type,oem,tag_datatype from "+ TABLE_NAME
				+ " where has_permission='true' and type='alarm'";

		List<Opctag> opctags = jdbcTemplate.query(sqlQuery, new OpctagsColumnMapper());
		return opctags;

	}

	@Override
	public List<Opctag> getGeneraldataOPCtags()
	{
		String sqlQuery = "select tag_id,opc_tag_name,display_name,description,"
				+ "units,type,alias,subs_interval,need_value,asset_type,has_permission,"
				+ "opcserver_type,oem,tag_datatype from "+ TABLE_NAME
				+ " where tag_id in (10001,10002,10009,10899,11419,11721,11747,11748,11749,"
				+ "11667,11668,11691,11692,11693,11694,11695,11696,11711,11712,11713,11714,"
				+ "11727,11728,11729,11730,11740,11722,11745,11746,11393,11394)";
		List<Opctag> opctags = jdbcTemplate.query(sqlQuery, new OpctagsColumnMapper());
		return opctags;

	}
	
	@Override
	public List<Opctag> getGeneralandYawdataOPCtags()
	{
		String sqlQuery = "select tag_id,opc_tag_name,display_name,description,"
				+ "units,type,alias,subs_interval,need_value,asset_type,has_permission,"
				+ "opcserver_type,oem,tag_datatype from "+ TABLE_NAME
				+ " where tag_id in (10001,10002,10009,10899,11419,11721,11722,11747,11748,11749,"
				+ "11745,11746,11393,11394)";

		List<Opctag> opctags = jdbcTemplate.query(sqlQuery, new OpctagsColumnMapper());
		return opctags;
	}
    
	@Override
	public List<Opctag> getPitchdataOPCtags()
	{
		String sqlQuery = "select tag_id,opc_tag_name,display_name,description,"
				+ "units,type,alias,subs_interval,need_value,asset_type,has_permission,"
				+ "opcserver_type,oem,tag_datatype from "+ TABLE_NAME
				+ " where tag_id in (10005,10006,10007,10488,"
				+ "10502,10466,10835,10836,10837,11751,11752,11753,11720,11754)";

		List<Opctag> opctags = jdbcTemplate.query(sqlQuery, new OpctagsColumnMapper());
		return opctags;

	}
	
	@Override
	public List<Opctag> getYawdataOPCtags()
	{
		String sqlQuery = "select tag_id,opc_tag_name,display_name,description,"
				+ "units,type,alias,subs_interval,need_value,asset_type,has_permission,"
				+ "opcserver_type,oem,tag_datatype from "+ TABLE_NAME
				+ " where tag_id in ('11393','11394','11745','11746')";

		List<Opctag> opctags = jdbcTemplate.query(sqlQuery, new OpctagsColumnMapper());
		return opctags;
	}
    
	
	public Opctag getOPCtagDetails(int opcTagId)
	{
		String sqlQuery = "select tag_id,opc_tag_name,display_name,description,"
				+ "units,type,alias,subs_interval,need_value,asset_type,has_permission,"
				+ "opcserver_type,oem,tag_datatype from "+ TABLE_NAME
				+ " where tag_id=?";

		Object[] params ={opcTagId};
		Opctag opctagDetails = 
				(Opctag)jdbcTemplate.queryForObject(sqlQuery,params, new OpctagsColumnMapper());
		return opctagDetails;
	}
	
	
	public Opctag getOPCtagDetails(String opcTagName)
	{
		String sqlQuery = "select tag_id,opc_tag_name,display_name,description,"
				+ "units,type,alias,subs_interval,need_value,asset_type,has_permission,"
				+ "opcserver_type,oem,tag_datatype from "+ TABLE_NAME
				+ " where opc_tag_name=?";

		Object[] params ={opcTagName};
		Opctag opctagDetails = 
				(Opctag)jdbcTemplate.queryForObject(sqlQuery,params, new OpctagsColumnMapper());
		return opctagDetails;
	}

	

}
