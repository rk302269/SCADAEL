package com.gepower.renewables.scadaedgelite.dao.impl;

import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.gepower.renewables.scadaedgelite.dao.OpcTagMapper;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Opctag;


@Repository
public class TagAdminDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public TagAdminDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =jdbcTemplate;
	}
	public List<Opctag> getTagsDetails() {
			List<Opctag> opcTags;
				String sqlQuesry = "select * from scadael.opctags_master";
				opcTags = jdbcTemplate.query(sqlQuesry, new OpcTagMapper());	
			return opcTags;
		}
	
	
	public boolean updateTagAdmin(String opcTagName) throws SQLException{
		 String updateSql = "update scadael.opctags_master set timeseries_flag=true where opc_tag_name= '"+opcTagName+"'";
		 int rows = jdbcTemplate.update(updateSql);
		 System.out.println("rows::::::::::::"+rows);
		return true;
	}

	public boolean subscribeTags() {
		String subComment ="Please start subscription";
		int sub_status_flag = 0;
        Object[] params = new Object[] { subComment, sub_status_flag, new Date() };
        int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.TIMESTAMP };
        //String insertSql = "insert into scadael.command_data_tracker(asset_name,cmd_tag_id,cmd_value,cmd_send_time) values(?,?,?,?)";
        String insertSql = "insert into scadael.tags_subscription(sub_comment,sub_status_flag,sub_datetime) values(?,?,?)";
        int row = jdbcTemplate.update(insertSql, params, types);
        System.out.println(row + " row inserted.");
        return true;
    }
	
}








