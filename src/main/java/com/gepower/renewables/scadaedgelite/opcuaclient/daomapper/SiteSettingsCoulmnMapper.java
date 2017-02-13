package com.gepower.renewables.scadaedgelite.opcuaclient.daomapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gepower.renewables.scadaedgelite.opcuaclient.model.SiteSettings;

public class SiteSettingsCoulmnMapper implements RowMapper<SiteSettings> {

	@Override
	public SiteSettings mapRow(ResultSet resultSet, int row) throws SQLException {
		
		SiteSettings siteSettingsBean = new SiteSettings();
		siteSettingsBean.setId(resultSet.getInt("id"));
		siteSettingsBean.setName(resultSet.getString("name"));
		siteSettingsBean.setValue(resultSet.getString("value"));
		siteSettingsBean.setDescription(resultSet.getString("description"));
		siteSettingsBean.setCreatedBy(resultSet.getString("created_by"));
		siteSettingsBean.setCreatedDate(resultSet.getString("created_date"));
		siteSettingsBean.setModifiedBy(resultSet.getString("modified_by"));
		siteSettingsBean.setModifiedDate(resultSet.getString("modified_date"));
		
		
		return siteSettingsBean;

}
}