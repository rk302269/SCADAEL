package com.gepower.renewables.scadaedgelite.opcuaclient.daomapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.OPCServer;

public class OPCServerCoulmnMapper implements RowMapper<OPCServer> {

	@Override
	public OPCServer mapRow(ResultSet resultSet, int row) throws SQLException {
		
		OPCServer opcServerBean = new OPCServer();
		
		opcServerBean.setOpcId(resultSet.getInt("opc_id"));
		opcServerBean.setOpcHostIP(resultSet.getString("opc_host_ip"));
		opcServerBean.setOpcServerName(resultSet.getString("opc_server_name"));
		opcServerBean.setOpcPort(resultSet.getString("opc_port"));
		opcServerBean.setOpcType(resultSet.getString("opc_type"));
		opcServerBean.setOpcOEM(resultSet.getString("opc_oem"));
		opcServerBean.setCreatedBy(resultSet.getString("created_by"));
		opcServerBean.setCreatedDate(resultSet.getString("created_date"));
		opcServerBean.setModifiedBy(resultSet.getString("modified_by"));
		opcServerBean.setModifiedDate(resultSet.getString("modified_date"));
			
		return opcServerBean;

}
}