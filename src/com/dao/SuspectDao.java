package com.dao;

import java.sql.SQLException;

import java.util.List;

import com.exceptions.InvalidIncidentDataException;
import com.exceptions.InvalidSuspectDataException;
import com.model.Suspect;

public interface SuspectDao {
	public void addRecord(Suspect suspect) throws ClassNotFoundException, SQLException, InvalidIncidentDataException;
	public void deleteSuspect(int id2) throws ClassNotFoundException, SQLException, InvalidSuspectDataException;
	public List<Suspect> getSuspect(int id1) throws ClassNotFoundException, SQLException;
	public List<Suspect> getSuspectByName(String name) throws ClassNotFoundException, SQLException ;

}
