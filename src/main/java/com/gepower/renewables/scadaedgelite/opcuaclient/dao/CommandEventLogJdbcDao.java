package com.gepower.renewables.scadaedgelite.opcuaclient.dao;

import java.util.List;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.CmdEventLog;


public interface CommandEventLogJdbcDao {

	void insertCommandEventlogs(String assetName, String logType, String logName, String logDescription, String logTime);	

	void insertBatchCommandEventLogs(List<CmdEventLog> commandEventLog);		

	void deleteCommandEventlogs(String assetName);

	void deleteCommandEventlogs();

}
