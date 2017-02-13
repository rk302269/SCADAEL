package com.gepower.renewables.scadaedgelite.opcuaclient.dao;

import java.util.List;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.Alarm;

public interface AlarmDataJdbcDao {

	void insertAlarmData(String assetName,String alarmName, String alarmDescription, String tagValue, String timeStamp);

	void updateAlarmData(String tagValue, String timeStamp, int assetId, int tagId);

	void deleteAlarmData(String assetName, String alarmName);

	void deleteAlarmData();

	void insertBatchAlarmData(List<Alarm> alarm);

	int getRowCount(String assetName, String alarmName);


}
