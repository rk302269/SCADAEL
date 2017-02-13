package com.gepower.renewables.scadaedgelite.opcuaclient.dao;

import java.util.List;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.OPCServer;

public interface OPCServerJdbcDao {

	List<OPCServer> getSiteOPCServerData();
}
