package com.gepower.renewables.scadaedgelite.opcuaclient.dao;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;

public interface SiteKPIDataJdbcDao {	

	void insertLiveData(int assetId, String assetName, int tagId, String opctagName, String tagValue, String timeStamp);			

	void updateLiveData(String tagValue, String timeStamp, int assetId, int tagId);

	void deleteLiveData(int assetId, int tagId);
	
	void deleteLiveData();	
	
	KPIData getLiveData(int assetId, int tagId);

	

}
