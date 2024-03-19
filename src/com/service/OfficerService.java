package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OfficerDao;
import com.dao.OfficerDaoImpl;
import com.model.Officer;

public class OfficerService {

	public List<Officer> fetchAllOfficers() throws ClassNotFoundException, SQLException {
		
		OfficerDao dao=new OfficerDaoImpl();
		return dao.fetchAllOfficers();
	}

}
