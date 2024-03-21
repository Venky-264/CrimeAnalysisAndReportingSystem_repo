package com.service;


import java.sql.SQLException;
import java.util.List;
import java.util.Date;

import com.dao.IncidentDao;
import com.dao.IncidentDaoImpl;
import com.enums.IncidentType;
import com.model.Incident;

public class IncidentService {

	public List<Incident> getAllIncidents() throws ClassNotFoundException, SQLException {
		
		IncidentDao dao=new IncidentDaoImpl();
		
		return dao.getAllIncidents();
	}
	public void createIncident(Incident i) throws ClassNotFoundException, SQLException {
		IncidentDao dao = new IncidentDaoImpl();
		dao.createIncident(i);
		return;
	}
	public List<Incident> getIncidentsInDateRange(Date from, Date to) throws ClassNotFoundException, SQLException
	{
		IncidentDao dao = new IncidentDaoImpl();
		return dao.getIncidentsInDateRange(from, to);
	}
	public List<Incident> searchIncidents(IncidentType criteria)throws ClassNotFoundException, SQLException
	{
		IncidentDao dao = new IncidentDaoImpl();
		return dao.searchIncidents(criteria);
	}

}
