package com.gepower.renewables.scadaedgelite.opcuaclient.model;

import java.io.Serializable;


/*  Bean Class for OPC Tags  */
public class Opctag implements Serializable{

	private static final long serialVersionUID = 1L;

	/*  The tag_id.  */
	private int  tagId;
	
	/*  The opc_tag_name.  */
	private String opctagName;
	
	/*  The display_name.  */
	private String displayName; 
	
	/*  The description.  */
	private String description; 
	
	/*  The units.  */
	private String units; 
	
	/*  The type.  */
	private String type;
	
	/*  The alias.  */
	private String alias; 
	
	/*  The subs_interval.  */
	private int subsInterval; 
	
	/*  The need_value.  */
	private boolean needValue; 
	
	/*  The asset_type.  */
	private String assetType;
	
	/*  The has_permission.  */
	private boolean haspermission;
	
	/*  The opcserver_type.  */
	private String opcserverType;
	
	/*  The oem.  */
	private String oem;
	
	/*  The tag_datatype.  */
	private String opctagDatatype;

	/**
	    Gets the  tag_id
	 * @return the tagId
	 */
	public int getTagId() {
		return tagId;
	}

	/**
	   Sets  the tag_id
	 * @param tagId the tagId to set
	 */
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	/**
	    Gets the opc_tag_name 
	 * @return the opctagName
	 */
	public String getOpctagName() {
		return opctagName;
	}

	/**
	   Sets  the opc_tag_name
	 * @param opctagName the opctagName to set
	 */
	public void setOpctagName(String opctagName) {
		this.opctagName = opctagName;
	}

	/**
	    Gets the  display_name
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	   Sets  the display_name
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	    Gets the  description
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
	    Gets the  units
	 * @return the units
	 */
	public String getUnits() {
		return units;
	}

	/**
	   Sets  the units
	 * @param units the units to set
	 */
	public void setUnits(String units) {
		this.units = units;
	}

	/**
	    Gets the  type
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	   Sets  the type
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	    Gets the  alias
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	   Sets  the alias
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	    Gets the  subs_interval
	 * @return the subsInterval
	 */
	public int getSubsInterval() {
		return subsInterval;
	}

	/**
	   Sets  the subs_interval
	 * @param subsInterval the subsInterval to set
	 */
	public void setSubsInterval(int subsInterval) {
		this.subsInterval = subsInterval;
	}

	/**
	    Gets the need_value 
	 * @return the needValue
	 */
	public boolean isNeedValue() {
		return needValue;
	}

	/**
	   Sets  the need_value
	 * @param needValue the needValue to set
	 */
	public void setNeedValue(boolean needValue) {
		this.needValue = needValue;
	}

	/**
	    Gets the  asset_type
	 * @return the assetType
	 */
	public String getAssetType() {
		return assetType;
	}

	/**
	   Sets  the asset_type
	 * @param assetType the assetType to set
	 */
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	/**
	    Gets the  has_permission
	 * @return the haspermission
	 */
	public boolean isHaspermission() {
		return haspermission;
	}

	/**
	   Sets  the has_permission
	 * @param haspermission the haspermission to set
	 */
	public void setHaspermission(boolean haspermission) {
		this.haspermission = haspermission;
	}

	/**
	    Gets the  opcserver_type
	 * @return the opcserverType
	 */
	public String getOpcserverType() {
		return opcserverType;
	}

	/**
	   Sets  the  opcserver_type
	 * @param opcserverType the opcserverType to set
	 */
	public void setOpcserverType(String opcserverType) {
		this.opcserverType = opcserverType;
	}

	/**
	    Gets the  oem
	 * @return the oem
	 */
	public String getOem() {
		return oem;
	}

	/**
	   Sets  the  oem
	 * @param oem the oem to set
	 */
	public void setOem(String oem) {
		this.oem = oem;
	}

	/**
	    Gets the  tag_datatype
	 * @return the opctagDatatype
	 */
	public String getOpctagDatatype() {
		return opctagDatatype;
	}

	/**
	   Sets  the  tag_datatype
	 * @param opctagDatatype the opctagDatatype to set
	 */
	public void setOpctagDatatype(String opctagDatatype) {
		this.opctagDatatype = opctagDatatype;
	}
	
	
	
	
}
