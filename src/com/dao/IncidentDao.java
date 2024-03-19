package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Incident;

public interface  IncidentDao {

	List<Incident> getAllIncidents() throws ClassNotFoundException, SQLException;

}
