package com.dao;

import java.sql.SQLException;
import java.util.List;
import com.model.Evidence;


public interface EvidenceDao {
	List<Evidence> getAllEvidenceForIncident(int incidentId) throws SQLException,ClassNotFoundException;
    public void addEvidenceToIncident( Evidence evidence) throws SQLException,ClassNotFoundException;
    

}
