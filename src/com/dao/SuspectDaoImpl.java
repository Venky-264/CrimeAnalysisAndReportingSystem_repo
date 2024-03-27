package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import com.exceptions.InvalidIncidentDataException;
import com.exceptions.InvalidSuspectDataException;
import com.model.Suspect;
import com.utility.DBConnection;

public class SuspectDaoImpl implements SuspectDao{

	public void addRecord(Suspect suspect) throws ClassNotFoundException, SQLException, InvalidIncidentDataException {
		Connection conn = DBConnection.getDBConn();
		String sql="insert into suspect(first_name,last_name,dob,gender,contact_info,incident_id) values (?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		String query="select id from incident where id=?";
		PreparedStatement pstmt1 = conn.prepareStatement(query);
		pstmt1.setInt(1,suspect.getIncidentId());
		ResultSet idSet= pstmt1.executeQuery();	
		
        boolean incidentIdVal=idSet.next();
 	
		if(!incidentIdVal)
			throw new InvalidIncidentDataException("invalid incident id");
		String firstName=suspect.getFirstName();
		String lastName=suspect.getLastName();
		String  dob=suspect.getDob().toString();
		String gender=suspect.getGender();
		String contactInfo=suspect.getContactNumber();
		int incidentId=suspect.getIncidentId();
		
		pstmt.setString(1,firstName);
		pstmt.setString(2,lastName);
		pstmt.setString(3,dob);
		pstmt.setString(4,gender);
		pstmt.setString(5,contactInfo);
		pstmt.setInt(6,incidentId);
		pstmt.executeUpdate();
		DBConnection.dbClose();
		
	}

	

	public void deleteSuspect(int id2) throws ClassNotFoundException, SQLException, InvalidSuspectDataException {
        Connection conn = DBConnection.getDBConn();
		
		String sql="delete from suspect where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		String query="select id from suspect where id=?";
		PreparedStatement pstmt1 = conn.prepareStatement(query);
		pstmt1.setInt(1, id2);
		ResultSet idSet= pstmt1.executeQuery();	
		
        boolean idVal=idSet.next();
 	
		if(!idVal)
			throw new InvalidSuspectDataException("invalid suspect id");
		pstmt.setInt(1, id2);
		pstmt.executeUpdate();
		System.out.println("deleted rows successfully");
		DBConnection.dbClose();
		
	}



	public List<Suspect> getSuspect(int id1) throws ClassNotFoundException, SQLException {
		List<Suspect> s=new ArrayList<>();
		Connection conn = DBConnection.getDBConn();
		String sql="select * from suspect where incident_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id1);
		ResultSet rst= pstmt.executeQuery();
		
		while(rst.next()) { 
			int id = rst.getInt("id");
			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			Date dobSql=rst.getDate("dob");
			LocalDate dob = dobSql.toLocalDate();
			String gender=rst.getString("gender");
			String contactInfo=rst.getString("contact_info");
			int incidentId = rst.getInt("incident_id");
			Suspect suspect = new Suspect(id,firstName,lastName,dob,gender,contactInfo,incidentId);
			s.add(suspect); 
	}
    
	DBConnection.dbClose();
	return s;
	}



	public List<Suspect> getSuspectByName(String name) throws ClassNotFoundException, SQLException {
		List<Suspect> s=new ArrayList<>();
		Connection conn = DBConnection.getDBConn();
		String sql="select * from suspect where first_name=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,name);
		ResultSet rst= pstmt.executeQuery();
		
		while(rst.next()) { 
			int id = rst.getInt("id");
			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			Date dobSql=rst.getDate("dob");
			LocalDate dob = dobSql.toLocalDate();
			String gender=rst.getString("gender");
			String contactInfo=rst.getString("contact_info");
			int incidentId = rst.getInt("incident_id");
			Suspect suspect = new Suspect(id,firstName,lastName,dob,gender,contactInfo,incidentId);
			s.add(suspect); 
	}
		DBConnection.dbClose();
		return s;
	}
	}


