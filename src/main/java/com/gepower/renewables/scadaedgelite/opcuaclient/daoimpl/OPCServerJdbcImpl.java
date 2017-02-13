package com.gepower.renewables.scadaedgelite.opcuaclient.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.opcuaclient.dao.OPCServerJdbcDao;
import com.gepower.renewables.scadaedgelite.opcuaclient.daomapper.OPCServerCoulmnMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.OPCServer;

@Repository
public class OPCServerJdbcImpl implements OPCServerJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;	

	private static final String TABLE_NAME = "scadael.opcserver_master"; 

	@Autowired
	public OPCServerJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}

	@Override
	public List<OPCServer> getSiteOPCServerData()
	{
		String sqlQuery =
				"select opc_id, opc_host_ip,opc_server_name,opc_port,opc_type,opc_oem,created_by,"
						+ "created_date,modified_by,modified_date"
						+ " from "+TABLE_NAME;
		
		List<OPCServer> opcServerData = jdbcTemplate.query(sqlQuery, new OPCServerCoulmnMapper());
		
		return  opcServerData;

	}
}
