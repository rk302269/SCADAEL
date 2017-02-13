package com.gepower.renewables.scadaedgelite.opcuaclient.model;

import java.io.Serializable;

 /*  Bean Class for LiveData  */
public class KPIData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*  The asset_id.  */
	private int assetId;
	
	/*  The asset_name.  */
	private String assetName;
	
	/*  The opctag_id.  */
	private int tagId;
	
	/*  The opctag_name.  */
	private String opctagName;
	
	/*  The opctag_value.  */
	private String opctagValue;
	
	/*  The livedata_received_time.  */
	private String livedataReceivedTime;

	/**
	    Gets the  asset_id
	 * @return the assetId
	 */
	public int getAssetId() {
		return assetId;
	}

	/**
	   Sets  the asset_id
	 * @param assetId the assetId to set
	 */
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	/**
	    Gets the  asset_name
	 * @return the assetName
	 */
	public String getAssetName() {
		return assetName;
	}

	/**
	   Sets  the asset_name
	 * @param assetName the assetName to set
	 */
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	/**
	    Gets the  opctag_id
	 * @return the tagId
	 */
	public int getTagId() {
		return tagId;
	}

	/**
	   Sets  the opctag_id
	 * @param tagId the tagId to set
	 */
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	/**
	    Gets the  opctag_name
	 * @return the opctagName
	 */
	public String getOpctagName() {
		return opctagName;
	}

	/**
	   Sets  the opctag_name
	 * @param opctagName the opctagName to set
	 */
	public void setOpctagName(String opctagName) {
		this.opctagName = opctagName;
	}

	/**
	    Gets the  opctag_value
	 * @return the opctagValue
	 */
	public String getOpctagValue() {
		return opctagValue;
	}

	/**
	   Sets  the opctag_value
	 * @param opctagValue the opctagValue to set
	 */
	public void setOpctagValue(String opctagValue) {
		this.opctagValue = opctagValue;
	}

	/**
	    Gets the  livedata_received_time
	 * @return the livedataReceivedTime
	 */
	public String getLivedataReceivedTime() {
		return livedataReceivedTime;
	}

	/**
	   Sets  the  livedata_received_time
	 * @param livedataReceivedTime the livedataReceivedTime to set
	 */
	public void setLivedataReceivedTime(String livedataReceivedTime) {
		this.livedataReceivedTime = livedataReceivedTime;
	}
	
	
	
	
	
	
	
}
