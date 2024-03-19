package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.enums.IncidentType;

import com.enums.Status;
import com.model.Incident;
import com.utility.DBConnection;

public class IncidentDaoImpl implements IncidentDao{

	@Override
	public List<Incident> getAllIncidents() throws ClassNotFoundException, SQLException {
		
		Connection conn=DBConnection.getDBConn();
		
		String query="select * from incidents";
		
		Statement stmt=conn.createStatement();
		
		ResultSet result = stmt.executeQuery(query);
		
		List<Incident> incidents=new ArrayList<>();
		
		while(result.next()) {
			int id=result.getInt("incident_id");
			String incidentType=result.getString("incident_type");
			Date incidentDate=result.getDate("incident_date");
			String location=result.getString("location");
			String status=result.getString("status");
			int officerId=result.getInt("officers_officer_id");
			
			Incident i=new Incident();
			i.setIncidentId(id);
			i.setIncidentType(IncidentType.valueOf(incidentType.toUpperCase()));
			i.setIncidentDate(incidentDate);
			i.setLocation(location);
			i.setStatus(Status.valueOf(status.toUpperCase()));
			i.setOfficerId(officerId);
			
			incidents.add(i);
		}
		
		
		DBConnection.dbClose();
		return incidents;
	}

}
