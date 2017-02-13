package com.gepower.renewables.scadaedgelite.opcuaclient.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Command implements Serializable{

	private static final long serialVersionUID = 1L;

	/*  The asset_name.  */
	private String assetName;
	
	/*  The cmd_tag_id.  */
	private int commandTag;
	
	/*  The cmd_value.  */
	private String commandValue;
	
	/*  The cmd_send_time.  */
	private Timestamp sentTime;
	
	/*  The status_flag.  */
	private String statusFlag;
	
	private int tagId;
	
	private String tagName;

	private String displayName;
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
	    Gets the  cmd_tag_id
	 * @return the commandTag
	 */
	public int getCommandTag() {
		return commandTag;
	}

	/**
	   Sets  the cmd_tag_id
	 * @param commandTag the commandTag to set
	 */
	public void setCommandTag(int commandTag) {
		this.commandTag = commandTag;
	}

	/**
	    Gets the  cmd_value
	 * @return the commandValue
	 */
	public String getCommandValue() {
		return commandValue;
	}

	/**
	   Sets  the cmd_value
	 * @param commandValue the commandValue to set
	 */
	public void setCommandValue(String commandValue) {
		this.commandValue = commandValue;
	}

	/**
	    Gets the  cmd_send_time
	 * @return the sentTime
	 */
	public Timestamp getSentTime() {
		return sentTime;
	}

	/**
	   Sets  the  cmd_send_time
	 * @param sentTime the sentTime to set
	 */
	public void setSentTime(Timestamp sentTime) {
		this.sentTime = sentTime;
	}

	/**
	    Gets the  status_flag
	 * @return the statusFlag
	 */
	public String getStatusFlag() {
		return statusFlag;
	}

	/**
	   Sets  the  status_flag
	 * @param statusFlag the statusFlag to set
	 */
	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	/**
	    Gets the tagId
	 * @return the tagId
	 */
	public int getTagId() {
		return tagId;
	}

	/**
	   Sets  the tagId
	 * @param tagId the tagId to set
	 */
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	/**
	    Gets the tagName
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	   Sets  the tagName
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/**
	    Gets the displayName
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	   Sets  the displayName
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
	
	
	
}
