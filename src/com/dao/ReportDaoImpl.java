package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.enums.IncidentType;
import com.enums.Status;
import com.model.Incident;
import com.model.Report;
import com.utility.DBConnection;

public class ReportDaoImpl implements ReportDao{

	@Override
	public void addReportToIncident(Report r) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getDBConn();
		java.sql.Date date = new java.sql.Date(r.getReportDate().getTime());
		String sql="insert into reports (report_date,report_details,status,incident_id)values (?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setDate(1, date);
		pstmt.setString(2, r.getReportDetails());
		pstmt.setString(3, r.getStatus().toString());
		pstmt.setInt(4,r.getIncidentId());
		pstmt.executeUpdate();
		DBConnection.dbClose();
		return;
		
		
		
	}

	@Override
	public List<Report> fetchReportForId(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getDBConn();
		
		String query="select * from reports where incident_id = (?)";
		
		PreparedStatement pstmt=conn.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet result = pstmt.executeQuery();
		List<Report> reports =new ArrayList<>();
		
		while(result.next()) {
			int localId=result.getInt("id");
			Date reportDate=result.getDate("report_date");
			String reportDetails=result.getString("report_details");
			String status=result.getString("status");

			Report r = new Report();
			r.setReportId(localId);
			r.setReportDate(reportDate);
			r.setReportDetails(reportDetails);
			r.setStatus(Status.valueOf(status.toUpperCase()));
			r.setIncidentId(id);
			reports.add(r);
		}
		DBConnection.dbClose();
		return reports;
	}

}
