package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Report;

public interface ReportDao {

	void addReportToIncident(Report r) throws ClassNotFoundException, SQLException;
	List<Report> fetchReportForId(int id) throws ClassNotFoundException, SQLException;
	

}
