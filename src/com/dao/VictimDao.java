package com.dao;

import java.sql.SQLException;

import java.util.List;

import com.model.Victim;

public interface VictimDao {
	public void addRecord( String firstName, String lastName, String dob, String gender, String contactInfo,
			int incidentId) throws ClassNotFoundException, SQLException;
	public List<Victim> getVictim(int id1) throws ClassNotFoundException, SQLException ;
	public List<Victim> getVictimByName(String name) throws ClassNotFoundException, SQLException;

}
