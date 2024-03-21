package com.service;


import java.sql.SQLException;

import java.util.List;

import com.dao.VictimDaoImpl;
import com.model.Victim;

public class VictimService {
	VictimDaoImpl dao=new VictimDaoImpl();

	public void addRecord( String firstName, String lastName, String dob, String gender, String contactInfo,
			int incidentId) throws ClassNotFoundException, SQLException {
		
		dao.addRecord(firstName,lastName,dob,gender,contactInfo,incidentId);
	}

	public List<Victim> getVictim(int id1) throws ClassNotFoundException, SQLException {
		return dao.getVictim(id1);
	}

	public List<Victim> getVictimByName(String name) throws ClassNotFoundException, SQLException {
		
		return dao.getVictimByName(name);
	}

	public void deleteVictim(int id) throws ClassNotFoundException, SQLException {
		dao.deleteVictim(id);
		
	}

	
	
}
