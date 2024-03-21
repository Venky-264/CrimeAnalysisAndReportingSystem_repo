package com.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;

import com.model.Incident;
import com.enums.*;

public interface  IncidentDao {

	List<Incident> getAllIncidents() throws ClassNotFoundException, SQLException;
	void createIncident(Incident i) throws ClassNotFoundException, SQLException;
	List<Incident> getIncidentsInDateRange(Date from,Date to)throws ClassNotFoundException,SQLException;
	List<Incident> searchIncidents(IncidentType criteria)throws ClassNotFoundException, SQLException;;
	Report generateIncidentReport() throws ClassNotFoundException, SQLException;
}

