package com.service;

import java.sql.SQLException;

import java.util.List;

import com.dao.SuspectDaoImpl;
import com.exceptions.InvalidIncidentDataException;
import com.exceptions.InvalidSuspectDataException;
import com.exceptions.InvalidVictimDataException;
import com.model.Suspect;


public class SuspectService {
	SuspectDaoImpl dao=new SuspectDaoImpl();

	public void addRecord(Suspect suspect) throws ClassNotFoundException, SQLException, InvalidIncidentDataException {
		dao.addRecord(suspect);
		
	}

	public void deleteSuspect(int id2) throws ClassNotFoundException, SQLException, InvalidSuspectDataException {
		dao.deleteSuspect(id2);
		
	}

	public List<Suspect> getSuspect(int id1) throws ClassNotFoundException, SQLException {
		
		return dao.getSuspect(id1);
	}

	public List<Suspect> getSuspectByName(String name) throws ClassNotFoundException, SQLException {
		return dao.getSuspectByName(name);
	}

	public Suspect getSuspectByIncidentId(List<Suspect> list, int incidentId) throws InvalidIncidentDataException {
		for(Suspect e : list) {
			if(e.getIncidentId() == incidentId)
				//System.out.println(e);
				return e; 
		}	
		throw new InvalidIncidentDataException("Invalid ID Given");
	}

	public Suspect getSuspectByName1(List<Suspect> list, String name) throws InvalidVictimDataException {
		for(Suspect e : list) {
			if(e.getFirstName() == name)
				//System.out.println(e);
				return e; 
		}	
		throw new InvalidVictimDataException("Invalid Name Given");
	}

	

}
