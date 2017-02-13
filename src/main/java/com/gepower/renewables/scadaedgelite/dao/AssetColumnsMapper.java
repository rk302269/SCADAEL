package com.gepower.renewables.scadaedgelite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.AssetData;

public class AssetColumnsMapper implements RowMapper<AssetData>{

	@Override
	public AssetData mapRow(ResultSet rs, int row) throws SQLException {
		AssetData assets = new AssetData();
		assets.setAssetName(rs.getString("asset_name"));
		assets.setStatus(rs.getString("turbine_status"));
		assets.setTowerAcceleration(rs.getString("tower_acceleration"));
		assets.setWindSpeed(rs.getString("wind_speed"));
		assets.setActualPower(rs.getString("actual_power"));
		assets.setGeneratoreSpeed(rs.getString("generator_speed"));
		assets.setBlade1Pitch(rs.getString("blade_1_pitch"));
		assets.setBlade2Pitch(rs.getString("blade_2_pitch"));
		assets.setBlade3Pitch(rs.getString("blade_3_pitch"));
		assets.setGeneratore1Temp(rs.getString("generator_1_temp"));
		assets.setGeneratore2Temp(rs.getString("generator_2_temp"));
		assets.setGearboxBearingTemp(rs.getString("gearbox_bearing_temp"));
		assets.setGearBoxTemp(rs.getString("gearbox_temp"));
		assets.setBearingATemp(rs.getString("bearing_a_temp"));
		assets.setBearingBTemp(rs.getString("bearing_b_temp"));
		assets.setAmbientTemp(rs.getString("ambient_temp"));
		assets.setNacellePosition(rs.getString("nacelle_position"));
		assets.setShaftBearingTemp(rs.getString("shaft_bearing_temp"));
		assets.setNacelleRevolution(rs.getString("nacelle_revolution"));
		assets.setRotorBrakeOpen(rs.getString("rotor_brake_open"));
		assets.setRotorBrakeClosed(rs.getString("rotor_brake_closed"));
		assets.setBlade1BatBoxTemp(rs.getString("blade_1_batterybox_temp"));
		assets.setBlade2BatBoxTemp(rs.getString("blade_2_batterybox_temp"));
		assets.setBlade3BatBoxTemp(rs.getString("blade_3_batterybox_temp"));
		assets.setEmgBrkSyTestNeeded(rs.getString("emgbrksystest_needed"));
		assets.setBlade1SetPoint(rs.getString("blade_1_setpitch"));
		assets.setBlade2SetPoint(rs.getString("blade_2_setpitch"));
		assets.setBlade3SetPoint(rs.getString("blade_3_setpitch"));
		assets.setTotalProduction(rs.getString("total_production"));
		assets.setRotorSpeed(rs.getString("rotor_speed"));
		assets.setYawMotLeftRotation(rs.getString("yawmotor_left_rotation"));
		assets.setYawMotRightRotation(rs.getString("yawmotor_right_rotation"));
		assets.setBatteryChargingTime(rs.getString("battery_charging_time"));
		assets.setTimeNextBatteryTest(rs.getString("time_to_battery_test"));
		assets.setProdLastMonth(rs.getString("production_lastmonth"));
		assets.setEmgBrkSyTestNeeded(rs.getString("emgbrksystest_needed"));
		
		
		
		//Pitch
		
		
		
		
		return assets;
	}
}
