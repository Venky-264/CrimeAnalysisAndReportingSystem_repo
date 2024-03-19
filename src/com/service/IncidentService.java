package com.service;


import java.sql.SQLException;
import java.util.List;

import com.dao.IncidentDao;
import com.dao.IncidentDaoImpl;
import com.model.Incident;

public class IncidentService {

	public List<Incident> getAllIncidents() throws ClassNotFoundException, SQLException {
		
		IncidentDao dao=new IncidentDaoImpl();
		
		return dao.getAllIncidents();
	}

}
