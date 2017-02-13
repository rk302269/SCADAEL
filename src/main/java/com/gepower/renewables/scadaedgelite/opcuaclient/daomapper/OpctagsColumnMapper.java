package com.gepower.renewables.scadaedgelite.opcuaclient.daomapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.Opctag;

public class OpctagsColumnMapper implements RowMapper<Opctag> {
	
	public Opctag  mapRow(ResultSet resultSet, int row) throws SQLException {
		
		Opctag opctagsBean = new Opctag();
		opctagsBean.setTagId(resultSet.getInt("tag_id") );
		opctagsBean.setOpctagName(resultSet.getString("opc_tag_name"));
		opctagsBean.setDisplayName(resultSet.getString("display_name"));
		opctagsBean.setDescription(resultSet.getString("description"));
		opctagsBean.setUnits(resultSet.getString("units"));
		opctagsBean.setType(resultSet.getString("type"));
		opctagsBean.setAlias(resultSet.getString("alias"));
		opctagsBean.setSubsInterval(resultSet.getInt("subs_interval"));
		opctagsBean.setOpctagDatatype(resultSet.getString("tag_datatype"));
		
		return opctagsBean;
	}
	 

}
