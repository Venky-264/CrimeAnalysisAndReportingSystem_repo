package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Officer;

public interface OfficerDao {

	List<Officer> fetchAllOfficers() throws ClassNotFoundException, SQLException;

}
