package com.gepower.renewables.scadaedgelite.opcuaclient.service;

import com.prosysopc.ua.client.UaClient;

public interface OPCClientConnectionService {

	public  UaClient getOPCUAClientConnection();
	
	
}