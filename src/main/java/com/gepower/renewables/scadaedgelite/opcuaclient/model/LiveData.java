package com.gepower.renewables.scadaedgelite.opcuaclient.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class LiveData implements Serializable{

	private static final long serialVersionUID = 1L;
	private String tagId;
	private String tagValue;
	private String assetId;
	private Integer towerHeight;
	private Integer towerAcceleration;
	private String windZone;
	private Double windSpeed;
	private Double blade1Position;
	private Double blade2Position;
	private Double blade3Position;
	private Double hydraulicPrepressure;
	private Double generatorSpeedCcu;
	private Double actualPower;
	private Double nacellePosition;
	private Double tempAmbient;
	private Double tempBearingA;
	private Double tempBearingB;
	private Double tempGearboxBearing;
	private Double tempShaftBearing;
	private Double tempGearbox;
	private Double tempGenerator1;
	private Double tempGenerator2;
	private Timestamp createdDate;
	private Integer updatedBy;
	private Timestamp updatedDate;
	private Timestamp metricsLastUpdated;
	private String type;
	private String time;
	
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTagValue() {
		return tagValue;
	}
	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Integer getTowerHeight() {
		return towerHeight;
	}
	public void setTowerHeight(Integer towerHeight) {
		this.towerHeight = towerHeight;
	}
	public Integer getTowerAcceleration() {
		return towerAcceleration;
	}
	public void setTowerAcceleration(Integer towerAcceleration) {
		this.towerAcceleration = towerAcceleration;
	}
	public String getWindZone() {
		return windZone;
	}
	public void setWindZone(String windZone) {
		this.windZone = windZone;
	}
	public Double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Double getBlade1Position() {
		return blade1Position;
	}
	public void setBlade1Position(Double blade1Position) {
		this.blade1Position = blade1Position;
	}
	public Double getBlade2Position() {
		return blade2Position;
	}
	public void setBlade2Position(Double blade2Position) {
		this.blade2Position = blade2Position;
	}
	public Double getBlade3Position() {
		return blade3Position;
	}
	public void setBlade3Position(Double blade3Position) {
		this.blade3Position = blade3Position;
	}
	public Double getHydraulicPrepressure() {
		return hydraulicPrepressure;
	}
	public void setHydraulicPrepressure(Double hydraulicPrepressure) {
		this.hydraulicPrepressure = hydraulicPrepressure;
	}
	public Double getGeneratorSpeedCcu() {
		return generatorSpeedCcu;
	}
	public void setGeneratorSpeedCcu(Double generatorSpeedCcu) {
		this.generatorSpeedCcu = generatorSpeedCcu;
	}
	public Double getActualPower() {
		return actualPower;
	}
	public void setActualPower(Double actualPower) {
		this.actualPower = actualPower;
	}
	public Double getNacellePosition() {
		return nacellePosition;
	}
	public void setNacellePosition(Double nacellePosition) {
		this.nacellePosition = nacellePosition;
	}
	public Double getTempAmbient() {
		return tempAmbient;
	}
	public void setTempAmbient(Double tempAmbient) {
		this.tempAmbient = tempAmbient;
	}
	public Double getTempBearingA() {
		return tempBearingA;
	}
	public void setTempBearingA(Double tempBearingA) {
		this.tempBearingA = tempBearingA;
	}
	public Double getTempBearingB() {
		return tempBearingB;
	}
	public void setTempBearingB(Double tempBearingB) {
		this.tempBearingB = tempBearingB;
	}
	public Double getTempGearboxBearing() {
		return tempGearboxBearing;
	}
	public void setTempGearboxBearing(Double tempGearboxBearing) {
		this.tempGearboxBearing = tempGearboxBearing;
	}
	public Double getTempShaftBearing() {
		return tempShaftBearing;
	}
	public void setTempShaftBearing(Double tempShaftBearing) {
		this.tempShaftBearing = tempShaftBearing;
	}
	public Double getTempGearbox() {
		return tempGearbox;
	}
	public void setTempGearbox(Double tempGearbox) {
		this.tempGearbox = tempGearbox;
	}
	public Double getTempGenerator1() {
		return tempGenerator1;
	}
	public void setTempGenerator1(Double tempGenerator1) {
		this.tempGenerator1 = tempGenerator1;
	}
	public Double getTempGenerator2() {
		return tempGenerator2;
	}
	public void setTempGenerator2(Double tempGenerator2) {
		this.tempGenerator2 = tempGenerator2;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Timestamp getMetricsLastUpdated() {
		return metricsLastUpdated;
	}
	public void setMetricsLastUpdated(Timestamp metricsLastUpdated) {
		this.metricsLastUpdated = metricsLastUpdated;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
}
