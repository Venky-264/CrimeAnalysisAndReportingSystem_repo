package com.dao;

import java.sql.SQLException;

import java.util.List;

import com.exceptions.InvalidIncidentDataException;
import com.model.Victim;

public interface VictimDao {
	public void addRecord( Victim victim) throws ClassNotFoundException, SQLException,InvalidIncidentDataException;
	public List<Victim> getVictim(int id1) throws ClassNotFoundException, SQLException ;
	public List<Victim> getVictimByName(String name) throws ClassNotFoundException, SQLException;

}
