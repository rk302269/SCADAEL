package com.gepower.renewables.scadaedgelite.opcuaclient.service;

import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;

public interface ReadLiveDataService {

	public void readLiveData() throws ServiceException, StatusException; 
}

