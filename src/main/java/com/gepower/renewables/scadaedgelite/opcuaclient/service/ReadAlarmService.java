package com.gepower.renewables.scadaedgelite.opcuaclient.service;

import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;

public interface ReadAlarmService {

	void readAlarmData() throws ServiceException, StatusException;
}
