package com.gepower.renewables.scadaedgelite.opcuaclient.model;

import java.io.Serializable;

/*  Bean Class for SiteSettings  */
public class SiteSettings implements Serializable{

	private static final long serialVersionUID = 1L;

	/*  The id.  */
	private int id;
	
	/*  The name.  */
	private String name;
	
	/*  The value.  */
	private String value;
	
	/*  The description.  */
	private String description;
	
	/*  The created_by.  */
	private String createdBy;
	
	/*  The created_date.  */
	private String createdDate;
	
	/*  The modified_by.  */
	private String modifiedBy;
	
	/*  The modified_date.  */
	private String modifiedDate;

	/**
	    Gets the id
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	   Sets  the id
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	    Gets the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	   Sets  the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	    Gets the value
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	   Sets  the value
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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
	    Gets the created_by
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	   Sets  the created_by
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	    Gets the created_date
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	   Sets  the created_date
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	    Gets the modified_by
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	   Sets  the modified_by
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	    Gets the modified_date
	 * @return the modifiedDate
	 */
	public String getModifiedDate() {
		return modifiedDate;
	}

	/**
	   Sets  the modified_date
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
}
