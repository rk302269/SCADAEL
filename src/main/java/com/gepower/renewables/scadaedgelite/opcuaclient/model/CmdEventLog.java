package com.gepower.renewables.scadaedgelite.opcuaclient.model;

import java.io.Serializable;


/*  Bean Class for Command and Event logs  */
public class CmdEventLog implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	/*  The Asset Name.  */
	private String assetName;
	
	/*  The log type(Command/Event/Alarm.. etc).  */
	private String logType;
	
	/*  The log Name.  */
	private String logName;
	
	/*  The state(N/A).  */
	//private String state;
	
	/*  The log time in UTC Seconds.  */
	private String logTime;
	
	/*  The log Description.  */
	private String logDescription;
	
	/**
	    Gets the assetName
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
	    Gets the logType
	 * @return the logType
	 */
	public String getLogType() {
		return logType;
	}

	/**
	   Sets  the logType
	 * @param logType the logType to set
	 */
	public void setLogType(String logType) {
		this.logType = logType;
	}

	/**
	    Gets the logName
	 * @return the logName
	 */
	public String getLogName() {
		return logName;
	}

	/**
	   Sets  the logName
	 * @param logName the logName to set
	 */
	public void setLogName(String logName) {
		this.logName = logName;
	}

	/**
	    Gets the state
	 * @return the state
	 */
	/*public String getState() {
		return state;
	}

	*//**
	   Sets  the state
	 * @param state the state to set
	 *//*
	public void setState(String state) {
		this.state = state;
	}*/

	/**
	    Gets the logTime
	 * @return the logTime
	 */
	public String getLogTime() {
		return logTime;
	}

	/**
	   Sets  the logTime
	 * @param logTime the logTime to set
	 */
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	/**
	    Gets the logDescription
	 * @return the logDescription
	 */
	public String getLogDescription() {
		return logDescription;
	}

	/**
	   Sets  the logDescription
	 * @param logDescription the logDescription to set
	 */
	public void setLogDescription(String logDescription) {
		this.logDescription = logDescription;
	}
	
	
	
	

}
