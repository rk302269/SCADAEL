package com.gepower.renewables.scadaedgelite.opcuaclient.dao;

import java.util.List;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.Asset;

public interface AssetsJdbcDao {

	public List<Asset> getAssetsData();
	
	public List<Asset> getAssetsData(String hostIP);
	
	public Asset getAssetDetails(int assetId);
	
	public Asset getAssetDetails(String assetName);

}
