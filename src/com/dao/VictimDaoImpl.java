package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Victim;
import com.utility.DBConnection;

public class VictimDaoImpl {

	public void addRecord( String firstName, String lastName, String dob, String gender, String contactInfo,
			int incidentId) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConn();
		String sql="insert into victim(first_name,last_name,dob,gender,contact_info,incident_id) values (?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setString(1,firstName );
		pstmt.setString(2,lastName );
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
			Date dob=rst.getDate("dob");
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
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,name);
		ResultSet rst= pstmt.executeQuery();
		
		while(rst.next()) { 
			int id = rst.getInt("id");
			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			Date dob=rst.getDate("dob");
			String gender=rst.getString("gender");
			String contactInfo=rst.getString("contact_info");
			int incidentId = rst.getInt("incident_id");
			Victim victim = new Victim(id,firstName,lastName,dob,gender,contactInfo,incidentId);
			v.add(victim); 
	}
		DBConnection.dbClose();
		return v;
	}




	public void deleteVictim(int id) throws SQLException, ClassNotFoundException {

		Connection conn = DBConnection.getDBConn();
		
		String sql="delete from victim where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		System.out.println("deleted rows successfully");
		DBConnection.dbClose();
	}
}
