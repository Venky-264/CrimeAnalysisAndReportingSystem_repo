package com.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.enums.IncidentType;

import com.enums.Status;
import com.model.Incident;
import com.model.Report;
import com.utility.DBConnection;

public class IncidentDaoImpl implements IncidentDao{

	@Override
	public List<Incident> getAllIncidents() throws ClassNotFoundException, SQLException {
		
		Connection conn=DBConnection.getDBConn();
		
		String query="select * from incident";
		
		Statement stmt=conn.createStatement();
		
		ResultSet result = stmt.executeQuery(query);
		
		List<Incident> incidents=new ArrayList<>();
		
		while(result.next()) {
			int id=result.getInt("id");
			String incidentType=result.getString("incident_type");
			Date incidentDate=result.getDate("incident_date");
			String location=result.getString("location");
			String description = result.getString("description");
			String status=result.getString("status");
			int officerId=result.getInt("officers_id");
			
			Incident i=new Incident();
			i.setIncidentId(id);
			i.setIncidentType(IncidentType.valueOf(incidentType.toUpperCase()));
			i.setIncidentDate(incidentDate);
			i.setLocation(location);
			i.setDescription(description);
			i.setStatus(Status.valueOf(status.toUpperCase()));
			i.setOfficerId(officerId);
			
			incidents.add(i);
		}
		
		
		DBConnection.dbClose();
		return incidents;
	}

	@Override
	public void createIncident(Incident i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getDBConn();
		java.sql.Date date = new java.sql.Date(i.getIncidentDate().getTime());
		String sql="insert into incident (incident_type,incident_date,location,description,status,officers_id)values (?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, i.getIncidentType().toString());
		pstmt.setDate(2,date);
		pstmt.setString(3, i.getLocation());
		pstmt.setString(4, i.getDescription());
		pstmt.setString(5, i.getStatus().toString());
		pstmt.setInt(6,i.getOfficerId());
		pstmt.executeUpdate();
		DBConnection.dbClose();
		return;
	}

	@Override
	public List<Incident> getIncidentsInDateRange(Date from ,Date to) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getDBConn();
		java.sql.Date fromDate = new java.sql.Date(from.getTime());
		java.sql.Date toDate = new java.sql.Date(to.getTime());
		String sql = "Select * from incident where incident_date between ? and ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setDate(1,fromDate);
		pstmt.setDate(2,toDate);
		ResultSet result = pstmt.executeQuery();
		List <Incident>incidents = new ArrayList<>();
		while(result.next())
		{
			int id=result.getInt("id");
			String incidentType=result.getString("incident_type");
			Date incidentDate=result.getDate("incident_date");
			String location=result.getString("location");
			String description = result.getString("description");
			String status=result.getString("status");
			int officerId=result.getInt("officers_id");
			
			Incident i=new Incident();
			i.setIncidentId(id);
			i.setIncidentType(IncidentType.valueOf(incidentType.toUpperCase()));
			i.setIncidentDate(incidentDate);
			i.setLocation(location);
			i.setDescription(description);
			i.setStatus(Status.valueOf(status.toUpperCase()));
			i.setOfficerId(officerId);
			incidents.add(i);
		}
		DBConnection.dbClose();
		return incidents;
	}

	@Override
	public List<Incident> searchIncidents(IncidentType criteria) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getDBConn();
		String sql = "Select * from incident where incident_type = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, criteria.toString());
		ResultSet result = pstmt.executeQuery();
		List <Incident>incidents = new ArrayList<>();
		while(result.next())
		{
			int id=result.getInt("id");
			String incidentType=result.getString("incident_type");
			Date incidentDate=result.getDate("incident_date");
			String location=result.getString("location");
			String description = result.getString("description");
			String status=result.getString("status");
			int officerId=result.getInt("officers_id");
			
			Incident i=new Incident();
			i.setIncidentId(id);
			i.setIncidentType(IncidentType.valueOf(incidentType.toUpperCase()));
			i.setIncidentDate(incidentDate);
			i.setLocation(location);
			i.setDescription(description);
			i.setStatus(Status.valueOf(status.toUpperCase()));
			i.setOfficerId(officerId);
			incidents.add(i);
		}
		DBConnection.dbClose();
		return incidents;
	}
	
	@Override
	public boolean idExsist(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
			Connection conn = DBConnection.getDBConn();
			String sql = "select exists(select * from incident where id = ?) as valueExsist";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet result = pstmt.executeQuery();
			Boolean ans = false;
			if(result.next())ans = result.getBoolean("valueExsist");
			DBConnection.dbClose();
			return ans;
	}
	

	@Override
	public Report generateIncidentReport() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Report r = new Report();
		return r;
	}
}
