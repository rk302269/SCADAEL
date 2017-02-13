package com.gepower.renewables.scadaedgelite.opcuaclient.model;

import java.io.Serializable;

/*  Bean Class for Assets  */
public class Asset implements Serializable{

	private static final long serialVersionUID = 1L;

	/*  The asset_id.  */
	private int assetId;	
	
	/*  The asset_name.  */
	private String assetName;	
	
	/*  The opcserver_type.  */
	private String opcserverType;	
	
	/*  The asset_type.  */
	private String assetType;
	
	/*  The asset_ip.  */
	private String assetIp;
	
	/*  The oem.  */
	private String oem;

	/**
	    Gets the  assetId
	 * @return the assetId
	 */
	public int getAssetId() {
		return assetId;
	}

	/**
	   Sets  the assetId
	 * @param assetId the assetId to set
	 */
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	/**
	    Gets the  assetName
	 * @return the assetName
	 */
	public String getAssetName() {
		return assetName;
	}

	/**
	   Sets  the assetName
	 * @param assetName the assetName to set
	 */
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	/**
	    Gets the  opcserverType
	 * @return the opcserverType
	 */
	public String getOpcserverType() {
		return opcserverType;
	}

	/**
	   Sets  the opcserverType
	 * @param opcserverType the opcserverType to set
	 */
	public void setOpcserverType(String opcserverType) {
		this.opcserverType = opcserverType;
	}

	/**
	    Gets the  assetType
	 * @return the assetType
	 */
	public String getAssetType() {
		return assetType;
	}

	/**
	   Sets  the assetType
	 * @param assetType the assetType to set
	 */
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	
	

	/**
	    Gets the  assetIp
	 * @return the assetIp
	 */
	public String getAssetIp() {
		return assetIp;
	}

	/**
	   Sets  the assetIp
	 * @param assetIp the assetIp to set
	 */
	public void setAssetIp(String assetIp) {
		this.assetIp = assetIp;
	}

	/**
	    Gets the  oem
	 * @return the oem
	 */
	public String getOem() {
		return oem;
	}

	/**
	   Sets  the oem
	 * @param oem the oem to set
	 */
	public void setOem(String oem) {
		this.oem = oem;
	}

	

	
	
	
}
