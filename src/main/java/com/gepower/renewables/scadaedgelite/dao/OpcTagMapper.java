package com.gepower.renewables.scadaedgelite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.Opctag;

public class OpcTagMapper implements RowMapper<Opctag>{

	@Override
	public Opctag mapRow(ResultSet rs, int row) throws SQLException {
		Opctag opcTag = new Opctag();
		opcTag.setTagId(rs.getInt("tag_id"));
		opcTag.setOpctagName(rs.getString("opc_tag_name"));
		opcTag.setDisplayName(rs.getString("display_name"));
		opcTag.setDescription(rs.getString("description"));
		opcTag.setAlias(rs.getString("alias"));
		opcTag.setOem(rs.getString("oem"));
		opcTag.setNeedValue(rs.getBoolean("need_value"));
		opcTag.setOpcserverType(rs.getString("opcserver_type"));
		opcTag.setOpctagDatatype(rs.getString("tag_datatype"));
		opcTag.setUnits(rs.getString("units"));
		//opcTag.setSubsInterval(rs.getInt("units"));
		opcTag.setType(rs.getString("type"));
		return opcTag;
	}

}
