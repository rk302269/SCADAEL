package com.gepower.renewables.scadaedgelite.opcuaclient.dao;

import java.util.List;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.Command;


public interface CommandJdbcDao {

	List<Command> getCommands();

	void updateCommandData(int opcTagId);
}
