package com.gepower.renewables.scadaedgelite.opcuaclient.dao;

import java.util.List;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.KPIData;

public interface AssetKPIDataJdbcDao {	

	void insertLiveData(int assetId, String assetName, int tagId, String opctagName, String tagValue, String timeStamp);	

	void insertBatchLiveData(List<KPIData> livedata);		

	void updateLiveData(String tagValue, String timeStamp, int assetId, int tagId);

	void deleteLiveData(int assetId, int tagId);

	void deleteLiveData();

	List<KPIData> getAssetKPIParamValue(String kPIParam);

	KPIData getLiveData(int assetId, int tagId, String tableName);

	void updateSiteKPIData(String sitePower, String timeStamp, int assetId, int tagId);

	void updateBatchLiveData(List<KPIData> livedata);

	public int getRowCount(int assetId, int tagId);

}
