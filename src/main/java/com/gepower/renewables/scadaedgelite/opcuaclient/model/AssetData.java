package com.gepower.renewables.scadaedgelite.opcuaclient.model;

public class AssetData {
	private String tagId;
	private String tagValue;
	private Integer assetId;
	private String time;
	private String assetName;
	private String opcTagName;
	private String windSpeed;
	private String towerAcceleration;
	private String status;
	private String actualPower;
	private String generatoreSpeed;
	private String generatore1Temp;
	private String generatore2Temp;
	private String gearboxBearingTemp;
	private String gearBoxTemp;
	private String bearingATemp;
	private String bearingBTemp;
	private String ambientTemp;
	private String nacellePosition;
	private String shaftBearingTemp;
	private String nacelleRevolution;
	private String rotorBrakeOpen;
	private String rotorSpeed;
	private String yawMotRightRotation;
	private String yawMotLeftRotation;
	private String totalProduction;
	private String prodLastMonth;
	
	//For Pitch
	private String blade1Pitch;
	private String blade2Pitch;
	private String blade3Pitch;
	private String blade1BatBoxTemp;
	private String blade2BatBoxTemp;
	private String blade3BatBoxTemp;
	private String batteryChargingTime;
	private String Blade1SetPoint;
	private String Blade2SetPoint;
	private String Blade3SetPoint;
	private String batteryMaxTemp;
	private String timeNextBatteryTest;
	private String emgBrkSyTestNeeded;
	private String rotorBrakeClosed;
	
	
	
	
	public String getRotorSpeed() {
		return rotorSpeed;
	}
	public void setRotorSpeed(String rotorSpeed) {
		this.rotorSpeed = rotorSpeed;
	}
	public String getTotalProduction() {
		return totalProduction;
	}
	public void setTotalProduction(String totalProduction) {
		this.totalProduction = totalProduction;
	}
	public String getProdLastMonth() {
		return prodLastMonth;
	}
	public void setProdLastMonth(String prodLastMonth) {
		this.prodLastMonth = prodLastMonth;
	}

	public String getGeneratore1Temp() {
		return generatore1Temp;
	}
	public void setGeneratore1Temp(String generatore1Temp) {
		this.generatore1Temp = generatore1Temp;
	}
	public String getGeneratore2Temp() {
		return generatore2Temp;
	}
	public void setGeneratore2Temp(String generatore2Temp) {
		this.generatore2Temp = generatore2Temp;
	}
	public String getGearboxBearingTemp() {
		return gearboxBearingTemp;
	}
	public void setGearboxBearingTemp(String gearboxBearingTemp) {
		this.gearboxBearingTemp = gearboxBearingTemp;
	}
	public String getGearBoxTemp() {
		return gearBoxTemp;
	}
	public void setGearBoxTemp(String gearBoxTemp) {
		this.gearBoxTemp = gearBoxTemp;
	}
	public String getBearingATemp() {
		return bearingATemp;
	}
	public void setBearingATemp(String bearingATemp) {
		this.bearingATemp = bearingATemp;
	}
	public String getBearingBTemp() {
		return bearingBTemp;
	}
	public void setBearingBTemp(String bearingBTemp) {
		this.bearingBTemp = bearingBTemp;
	}
	public String getAmbientTemp() {
		return ambientTemp;
	}
	public void setAmbientTemp(String ambientTemp) {
		this.ambientTemp = ambientTemp;
	}
	public String getNacellePosition() {
		return nacellePosition;
	}
	public void setNacellePosition(String nacellePosition) {
		this.nacellePosition = nacellePosition;
	}
	public String getShaftBearingTemp() {
		return shaftBearingTemp;
	}
	public void setShaftBearingTemp(String shaftBearingTemp) {
		this.shaftBearingTemp = shaftBearingTemp;
	}
	public String getOpcTagName() {
		return opcTagName;
	}
	public void setOpcTagName(String opcTagName) {
		this.opcTagName = opcTagName;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getTagValue() {
		return tagValue;
	}
	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	public Integer getAssetId() {
		return assetId;
	}
	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getTowerAcceleration() {
		return towerAcceleration;
	}
	public void setTowerAcceleration(String towerAcceleration) {
		this.towerAcceleration = towerAcceleration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getActualPower() {
		return actualPower;
	}
	public void setActualPower(String actualPower) {
		this.actualPower = actualPower;
	}
	public String getGeneratoreSpeed() {
		return generatoreSpeed;
	}
	public void setGeneratoreSpeed(String generatoreSpeed) {
		this.generatoreSpeed = generatoreSpeed;
	}
	public String getNacelleRevolution() {
		return nacelleRevolution;
	}
	public void setNacelleRevolution(String nacelleRevolution) {
		this.nacelleRevolution = nacelleRevolution;
	}
	public String getRotorBrakeOpen() {
		return rotorBrakeOpen;
	}
	public void setRotorBrakeOpen(String rotorBrakeOpen) {
		this.rotorBrakeOpen = rotorBrakeOpen;
	}
	public String getYawMotRightRotation() {
		return yawMotRightRotation;
	}
	public void setYawMotRightRotation(String yawMotRightRotation) {
		this.yawMotRightRotation = yawMotRightRotation;
	}
	public String getYawMotLeftRotation() {
		return yawMotLeftRotation;
	}
	public void setYawMotLeftRotation(String yawMotLeftRotation) {
		this.yawMotLeftRotation = yawMotLeftRotation;
	}
	
	public String getBlade1Pitch() {
		return blade1Pitch;
	}
	public void setBlade1Pitch(String blade1Pitch) {
		this.blade1Pitch = blade1Pitch;
	}
	public String getBlade2Pitch() {
		return blade2Pitch;
	}
	public void setBlade2Pitch(String blade2Pitch) {
		this.blade2Pitch = blade2Pitch;
	}
	public String getBlade3Pitch() {
		return blade3Pitch;
	}
	public void setBlade3Pitch(String blade3Pitch) {
		this.blade3Pitch = blade3Pitch;
	}
	public String getBlade1BatBoxTemp() {
		return blade1BatBoxTemp;
	}
	public void setBlade1BatBoxTemp(String blade1BatBoxTemp) {
		this.blade1BatBoxTemp = blade1BatBoxTemp;
	}
	public String getBlade2BatBoxTemp() {
		return blade2BatBoxTemp;
	}
	public void setBlade2BatBoxTemp(String blade2BatBoxTemp) {
		this.blade2BatBoxTemp = blade2BatBoxTemp;
	}
	public String getBlade3BatBoxTemp() {
		return blade3BatBoxTemp;
	}
	public void setBlade3BatBoxTemp(String blade3BatBoxTemp) {
		this.blade3BatBoxTemp = blade3BatBoxTemp;
	}
	public String getBatteryChargingTime() {
		return batteryChargingTime;
	}
	public void setBatteryChargingTime(String batteryChargingTime) {
		this.batteryChargingTime = batteryChargingTime;
	}
	public String getBlade1SetPoint() {
		return Blade1SetPoint;
	}
	public void setBlade1SetPoint(String blade1SetPoint) {
		Blade1SetPoint = blade1SetPoint;
	}
	public String getBlade2SetPoint() {
		return Blade2SetPoint;
	}
	public void setBlade2SetPoint(String blade2SetPoint) {
		Blade2SetPoint = blade2SetPoint;
	}
	public String getBlade3SetPoint() {
		return Blade3SetPoint;
	}
	public void setBlade3SetPoint(String blade3SetPoint) {
		Blade3SetPoint = blade3SetPoint;
	}
	public String getBatteryMaxTemp() {
		return batteryMaxTemp;
	}
	public void setBatteryMaxTemp(String batteryMaxTemp) {
		this.batteryMaxTemp = batteryMaxTemp;
	}
	public String getTimeNextBatteryTest() {
		return timeNextBatteryTest;
	}
	public void setTimeNextBatteryTest(String timeNextBatteryTest) {
		this.timeNextBatteryTest = timeNextBatteryTest;
	}
	public String getEmgBrkSyTestNeeded() {
		return emgBrkSyTestNeeded;
	}
	public void setEmgBrkSyTestNeeded(String emgBrkSyTestNeeded) {
		this.emgBrkSyTestNeeded = emgBrkSyTestNeeded;
	}
	public String getRotorBrakeClosed() {
		return rotorBrakeClosed;
	}
	public void setRotorBrakeClosed(String rotorBrakeClosed) {
		this.rotorBrakeClosed = rotorBrakeClosed;
	}
}
