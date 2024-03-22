package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.EvidenceDao;
import com.dao.EvidenceDaoImpl;
import com.model.Evidence;

public class EvidenceService {
	EvidenceDao evidenceDao = new EvidenceDaoImpl();

    public void addEvidenceToIncident( Evidence evidence) throws SQLException, ClassNotFoundException {
    	evidenceDao.addEvidenceToIncident(evidence);
    }

    public List<Evidence> getAllEvidenceForIncident(int incidentId) throws SQLException, ClassNotFoundException {
        return evidenceDao.getAllEvidenceForIncident(incidentId);
    }

}
