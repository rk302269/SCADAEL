package com.gepower.renewables.scadaedgelite.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gepower.renewables.scadaedgelite.dao.impl.TagAdminDaoImpl;
import com.gepower.renewables.scadaedgelite.opcuaclient.model.Opctag;

@Repository
public class TagsRepository {
	
@Autowired
TagAdminDaoImpl tagAdminDaoImpl;

@Autowired
public TagsRepository(TagAdminDaoImpl tagAdminDaoImpl){
	this.tagAdminDaoImpl = tagAdminDaoImpl;
}
	
public List<Opctag> gettagList(){
	List <Opctag> opcList = new ArrayList<Opctag>();
	opcList = tagAdminDaoImpl.getTagsDetails();
	return opcList;
	}

public boolean sendTagName(String opcTagName) throws SQLException{
	boolean flag = false;
	flag = tagAdminDaoImpl.updateTagAdmin(opcTagName);
	return flag;
}


public boolean subscribeTags() throws SQLException{
	boolean flag = false;
	flag = tagAdminDaoImpl.subscribeTags();
	return flag;
}

}
