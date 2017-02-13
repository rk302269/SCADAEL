package com.gepower.renewables.scadaedgelite.opcuaclient.model;

import java.io.Serializable;

/*  Bean Class for OPCServer Details  */
public class OPCServer implements Serializable{

	private static final long serialVersionUID = 1L;

	/*  The opc_id.  */
	private int opcId;
	
	/*  The opc_host_ip.  */
	private String opcHostIP;
	
	/*  The value opc_server_name.  */
	private String opcServerName;
	
	/*  The opc_port.  */
	private String opcPort;
	
	/*  The opc_type.  */
	private String opcType;
	
	/*  The opc_oem.  */
	private String opcOEM;
	
	/*  The created_by.  */
	private String createdBy;
	
	/*  The created_date.  */
	private String createdDate;

	/*  The modified_by.  */
	private String modifiedBy;
	
	/*  The modified_date.  */
	private String modifiedDate;

	/**
	 * @return the opcId
	 */
	public int getOpcId() {
		return opcId;
	}

	/**
	 * @param opcId the opcId to set
	 */
	public void setOpcId(int opcId) {
		this.opcId = opcId;
	}

	/**
	 * @return the opcHostIP
	 */
	public String getOpcHostIP() {
		return opcHostIP;
	}

	/**
	 * @param opcHostIP the opcHostIP to set
	 */
	public void setOpcHostIP(String opcHostIP) {
		this.opcHostIP = opcHostIP;
	}

	/**
	 * @return the opcServerName
	 */
	public String getOpcServerName() {
		return opcServerName;
	}

	/**
	 * @param opcServerName the opcServerName to set
	 */
	public void setOpcServerName(String opcServerName) {
		this.opcServerName = opcServerName;
	}

	/**
	 * @return the opcPort
	 */
	public String getOpcPort() {
		return opcPort;
	}

	/**
	 * @param opcPort the opcPort to set
	 */
	public void setOpcPort(String opcPort) {
		this.opcPort = opcPort;
	}

	/**
	 * @return the opcType
	 */
	public String getOpcType() {
		return opcType;
	}

	/**
	 * @param opcType the opcType to set
	 */
	public void setOpcType(String opcType) {
		this.opcType = opcType;
	}

	/**
	 * @return the opcOEM
	 */
	public String getOpcOEM() {
		return opcOEM;
	}

	/**
	 * @param opcOEM the opcOEM to set
	 */
	public void setOpcOEM(String opcOEM) {
		this.opcOEM = opcOEM;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedDate
	 */
	public String getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	
	
}
