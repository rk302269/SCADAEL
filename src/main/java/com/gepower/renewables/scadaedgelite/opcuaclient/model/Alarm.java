package com.gepower.renewables.scadaedgelite.opcuaclient.model;

import java.io.Serializable;

/*  Bean Class for Alarms  */
public class Alarm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String assetName;
	protected String alarmName;
	protected String description;
	protected String state;
	protected String time;
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
	    Gets the alarmName
	 * @return the alarmName
	 */
	public String getAlarmName() {
		return alarmName;
	}
	/**
	   Sets  the alarmName
	 * @param alarmName the alarmName to set
	 */
	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}
	/**
	    Gets the description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	   Sets  the description
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	    Gets the state
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	   Sets  the state
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	    Gets the time
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	   Sets  the time
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
	
}
