package com.service;

import java.sql.SQLException;
import java.util.List;

import com.Exceptions.IncidentNotFoundException;
import com.Exceptions.InvalidOfficerDataException;
import com.Exceptions.OfficerNotFoundException;
import com.dao.OfficerDao;
import com.dao.OfficerDaoImpl;
import com.model.Incident;
import com.model.Officer;

public class OfficerService {

	public List<Officer> fetchAllOfficers()
			throws ClassNotFoundException, SQLException {

		OfficerDao dao = new OfficerDaoImpl();
		return dao.fetchAllOfficers();
	}

	public void insertOfficer(Officer officer)
			throws ClassNotFoundException, SQLException, InvalidOfficerDataException {
		OfficerDao dao = new OfficerDaoImpl();

		dao.insertOfficer(officer);

	}

	public void validateOfficer(List<Officer> officers, int officerId)
			throws OfficerNotFoundException {

		boolean validate = false;

		for (Officer o : officers) {
			if (o.getOfficerId() == officerId)
				validate = true;
		}
		if (!validate)
			throw new OfficerNotFoundException("Invalid officerId");

	}

	public void validateIncident(List<Incident> allIncidents, int incidentId)
			throws IncidentNotFoundException {
		boolean validate = false;

		for (Incident i : allIncidents) {
			if (i.getIncidentId()==incidentId)
				validate = true;
		}
		if (!validate)
			throw new IncidentNotFoundException("invalid incidentId");
	}

	public void assignOfficerToIncident(int officerId, int incidentId)
			throws ClassNotFoundException, SQLException {
		OfficerDao dao = new OfficerDaoImpl();
		dao.assignOfficerToIncident(officerId,incidentId);
		
	}

	public void deleteOfficer(int officerIdToDelete)
			throws ClassNotFoundException, SQLException {
		
		OfficerDao dao = new OfficerDaoImpl();
		dao.deleteOfficer(officerIdToDelete);
	}

	public List<Incident> listIncidents(int officerIdToListIncidents)
			throws ClassNotFoundException, SQLException {
		
		OfficerDao dao = new OfficerDaoImpl();
		return dao.listIncidents(officerIdToListIncidents);
		
	}

}
