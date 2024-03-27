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
import com.exceptions.InvalidVictimDataException;
import com.model.Victim;
import com.utility.DBConnection;

public class VictimDaoImpl implements VictimDao {

	public void addRecord(Victim victim) throws ClassNotFoundException, SQLException, InvalidIncidentDataException {
		Connection conn = DBConnection.getDBConn();
		String sql="insert into victim(first_name,last_name,dob,gender,contact_info,incident_id) values (?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		String query="select id from incident where id=?";
		PreparedStatement pstmt1 = conn.prepareStatement(query);
		pstmt1.setInt(1,victim.getIncidentId());
		ResultSet idSet= pstmt1.executeQuery();	
		
        boolean incidentIdVal=idSet.next();
 	
		if(!incidentIdVal)
			throw new InvalidIncidentDataException("invalid incident id");
		String firstName=victim.getFirstName();
		String lastName=victim.getLastName();
		String  dob=victim.getDob().toString();
		String gender=victim.getGender();
		String contactInfo=victim.getContactNumber();
		int incidentId=victim.getIncidentId();
		pstmt.setString(1,firstName);
		pstmt.setString(2,lastName);
		pstmt.setString(3,dob);
		pstmt.setString(4,gender);
		pstmt.setString(5,contactInfo);
		pstmt.setInt(6,incidentId);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	
	
	
	public List<Victim> getVictim(int id1) throws ClassNotFoundException, SQLException {
		List<Victim> v=new ArrayList<>();
		Connection conn = DBConnection.getDBConn();
		String sql="select * from victim where incident_id=?";
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
			Victim victim = new Victim(id,firstName,lastName,dob,gender,contactInfo,incidentId);
			v.add(victim); 
			
	}
    
	DBConnection.dbClose();
	return v;
	

}




	public List<Victim> getVictimByName(String name) throws SQLException, ClassNotFoundException {
		List<Victim> v=new ArrayList<>();
		Connection conn = DBConnection.getDBConn();
		String sql="select * from victim where first_name=?";
		 //select first_name from victim where first_name like "%lo%";
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
			Victim victim = new Victim(id,firstName,lastName,dob,gender,contactInfo,incidentId);
			v.add(victim); 
	}
		DBConnection.dbClose();
		return v;
	}




	public void deleteVictim(int id) throws SQLException, ClassNotFoundException, InvalidVictimDataException {

		Connection conn = DBConnection.getDBConn();
		
		String sql="delete from victim where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		String query="select id from victim where id=?";
		PreparedStatement pstmt1 = conn.prepareStatement(query);
		pstmt1.setInt(1, id);
		ResultSet idSet= pstmt1.executeQuery();	
		
        boolean idVal=idSet.next();
 	
		if(!idVal)
			throw new InvalidVictimDataException("invalid victim id");
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		System.out.println("deleted rows successfully");
		DBConnection.dbClose();
	}




	




	
}
