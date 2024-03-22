package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ReportDao;
import com.dao.ReportDaoImpl;
import com.model.Report;

public class ReportService {

	public void addReportToIncident(Report r) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ReportDao dao = new ReportDaoImpl();
		dao.addReportToIncident(r);
	}

	public List<Report> fetchReportForId(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ReportDao dao = new ReportDaoImpl();
		return dao.fetchReportForId(id);
	}

}
