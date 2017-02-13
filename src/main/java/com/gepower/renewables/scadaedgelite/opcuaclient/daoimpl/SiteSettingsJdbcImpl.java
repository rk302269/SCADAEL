package com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.dao.SiteSettingsJdbcDao;
import com.gepower.renewables.scadaedgelite.opcuaclient.daomapper.SiteSettingsCoulmnMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.SiteSettings;

@Repository
public class SiteSettingsJdbcImpl implements SiteSettingsJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;	

	private static final String TABLE_NAME = "scadael.opcserver_master"; 

	@Autowired
	public SiteSettingsJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}

	@Override
	public SiteSettings getSiteSettings()
	{
		String sqlQuery =
				"select opc_id, opc_host_ip,opc_server_name,opc_port,opc_type,opc_oem,created_by,"
						+ "created_date,modified_by,modified_date"
						+ " from "+TABLE_NAME;
		
		SiteSettings siteSettingsBean = 
				(SiteSettings)jdbcTemplate.queryForObject(sqlQuery, new SiteSettingsCoulmnMapper());
		return siteSettingsBean;

	}
}
