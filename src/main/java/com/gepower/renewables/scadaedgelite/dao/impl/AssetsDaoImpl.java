package com.gepower.renewables.scadaedgelite.dao.impl;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.dao.AssetColumnsMapper;
import com.gepower.renewables.scadaedgelite.dao.KpiDataMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.AssetData;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class AssetsDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	@Autowired
	public AssetsDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;	        
	}
	public List<AssetData> getAssetsList() {
		/*String sqlQuesry = " select asset_name, "
		        +" MAX(case when opctag_name =  'Turbine Status' then opctag_value else null end) as Turbine_Status, "
		        +" MAX(case when opctag_name =  'Power' then opctag_value else null end) as Actual_Power, "
		        +" MAX(case when opctag_name =  'Wind Speed' then opctag_value else null end) as Wind_Speed, "
		        +" MAX(case when opctag_name =  'Tower Acceleration' then opctag_value else null end) as Tower_Acceleration, "
		        +" MAX(case when opctag_name =  'Generator Speed' then opctag_value else null end) as Generator_Speed, "
		        +" MAX(case when opctag_name =  'Blade 1 Actual Pitch' then opctag_value else null end) as Blade_1_Pitch, "
		        +" MAX(case when opctag_name =  'Blade 2 Actual Pitch' then opctag_value else null end) as Blade_2_Pitch, "
		        +" MAX(case when opctag_name =  'Blade 3 Actual Pitch' then opctag_value else null end) as Blade_3_Pitch, "
		        +" MAX(case when opctag_name =  'Generator 1 Temp.' then opctag_value else null end) as Generator_1_Temp, "
		        +" MAX(case when opctag_name =  'Generator 2 Temp.' then opctag_value else null end) as Generator_2_Temp, "
		        +" MAX(case when opctag_name =  'Gearbox Bearing Temp.' then opctag_value else null end) as Gearbox_Bearing_Temp, "
		        +" MAX(case when opctag_name =  'Gearbox Temp.' then opctag_value else null end) as Gearbox_Temp, "
		        +" MAX(case when opctag_name =  'Bearing A Temp.' then opctag_value else null end) as Bearing_A_Temp, "
		        +" MAX(case when opctag_name =  'Bearing B Temp.' then opctag_value else null end) as Bearing_B_Temp, "
		        +" MAX(case when opctag_name =  'Ambient Temp.' then opctag_value else null end) as Ambient_Temp, "
		        +" MAX(case when opctag_name =  'Nacelle Position' then opctag_value else null end) as Nacelle_Position, "
		        +" MAX(case when opctag_name =  'Shaft Bearing Temp.' then opctag_value else null end) as Shaft_Bearing_Temp "    
		                      +" from  scadael.asset_livedata group by asset_name order by asset_name ";*/
		
		String sqlQuesry = "select * from scadael.asset_kpi";
		
		
		
		
		System.out.println("sqlQuesry:::"+sqlQuesry);
		List<AssetData> assets = jdbcTemplate.query(sqlQuesry, new AssetColumnsMapper());
		return assets;
	}
	public List<AssetData> getLiveKpiData() {
			String sqlQuesry = "select * from scadael.site_kpi_data";
			List<AssetData> liveData = jdbcTemplate.query(sqlQuesry, new KpiDataMapper());
			return liveData;
		}
	
}
