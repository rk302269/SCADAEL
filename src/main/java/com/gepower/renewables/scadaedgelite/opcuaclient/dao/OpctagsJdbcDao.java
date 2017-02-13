package com.gepower.renewables.scadaedgelite.opcuaclient.dao;

import java.util.List;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.Opctag;

public interface OpctagsJdbcDao {

	List<Opctag> getAlarmOPCtags();

	List<Opctag> getPitchdataOPCtags();

	Opctag getOPCtagDetails(int opcTagId);

	List<Opctag> getGeneraldataOPCtags();
	
	List<Opctag> getGeneralandYawdataOPCtags();

	List<Opctag> getYawdataOPCtags();

	Opctag getOPCtagDetails(String opcTagName);

	

}
