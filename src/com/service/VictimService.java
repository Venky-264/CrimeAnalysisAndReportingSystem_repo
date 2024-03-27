package com.service;


import java.sql.SQLException;

import java.util.List;

import com.dao.VictimDaoImpl;
import com.exceptions.InvalidIncidentDataException;
import com.exceptions.InvalidVictimDataException;
import com.model.Victim;

public class VictimService {
	VictimDaoImpl dao=new VictimDaoImpl();

	public void addRecord(Victim victim) throws ClassNotFoundException, SQLException, InvalidIncidentDataException {
		
		dao.addRecord(victim);
	}

	public List<Victim> getVictim(int id1) throws ClassNotFoundException, SQLException {
		return dao.getVictim(id1);
	}

	public List<Victim> getVictimByName(String name) throws ClassNotFoundException, SQLException {
		
		return dao.getVictimByName(name);
	}

	public void deleteVictim(int id) throws ClassNotFoundException, SQLException, InvalidVictimDataException {
		dao.deleteVictim(id);
		
	}

	public Victim getVictimByIncidentId(List<Victim> list, int incidentId) throws InvalidIncidentDataException {
		for(Victim e : list) {
			if(e.getIncidentId() == incidentId)
				//System.out.println(e);
				return e; 
		}	
		throw new InvalidIncidentDataException("Invalid ID Given");
	}

	public Victim getVictimByName1(List<Victim> list, String name) throws InvalidVictimDataException {
		for(Victim e : list) {
			if(e.getFirstName() == name)
				//System.out.println(e);
				return e; 
		}	
		throw new InvalidVictimDataException("Invalid Name Given");
	}

	
	
}
