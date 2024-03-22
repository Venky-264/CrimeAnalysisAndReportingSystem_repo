package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Evidence;
import com.utility.DBConnection;

public class EvidenceDaoImpl implements EvidenceDao {
	public void addEvidenceToIncident( Evidence evidence) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConn();
        String sql = "INSERT INTO evidence (description, location_found, incident_id) VALUES (?, ?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
        
            pstmt.setString(1, evidence.getDescription());
            pstmt.setString(2, evidence.getLocation());
            pstmt.setInt(3, evidence.getIncidentId());
            pstmt.executeUpdate();
    		DBConnection.dbClose();
    }

    @Override
    public List<Evidence> getAllEvidenceForIncident(int incidentId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Evidence> evidenceList = new ArrayList<>();
        try {
            try {
            conn = DBConnection.getDBConn(); // Use getConnection() from DBConnection
            } catch (ClassNotFoundException e) {
            	e.printStackTrace(); // For demonstration purposes, print the stack trace
                throw new SQLException("Database driver not found");
            }
            String sql = "SELECT * FROM evidence WHERE incident_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, incidentId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int evidenceId = rs.getInt("evidence_id");
                String description = rs.getString("description");
                String locationFound = rs.getString("location_found");
                Evidence evidence = new Evidence(evidenceId, description, locationFound, incidentId);
                evidenceList.add(evidence);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return evidenceList;
    }


}
