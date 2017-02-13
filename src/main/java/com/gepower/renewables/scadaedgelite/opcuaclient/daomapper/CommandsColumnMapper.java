package com.gepower.renewables.scadaedgelite.opcuaclient.daomapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.Command;

public class CommandsColumnMapper implements RowMapper<Command> {

	@Override
	public Command mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Command commandBean = new Command();
		commandBean.setAssetName(resultSet.getString("asset_name"));
		commandBean.setCommandTag(resultSet.getInt("cmd_tag_id"));
		commandBean.setCommandValue(resultSet.getString("cmd_value"));
		commandBean.setSentTime(resultSet.getTimestamp("cmd_send_time"));
		commandBean.setStatusFlag(resultSet.getString("status_flag"));
		
		return commandBean;
	}

}
