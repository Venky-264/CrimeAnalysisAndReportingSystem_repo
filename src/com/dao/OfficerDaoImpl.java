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
import com.model.Officer;
import com.utility.DBConnection;

public class OfficerDaoImpl implements OfficerDao {

	@Override
	public List<Officer> fetchAllOfficers() throws ClassNotFoundException, SQLException {

		Connection conn = DBConnection.getDBConn();

		String query = "select * from officers";

		Statement stmt = conn.createStatement();

		ResultSet result = stmt.executeQuery(query);

		List<Officer> officers = new ArrayList<>();

		while (result.next()) {
			int id = result.getInt("officer_id");
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			String badgeNumber= result.getString("badge_number");
			int rank = result.getInt("rank");
			String contactNumber=result.getString("contact_number");
			int agencyId=result.getInt("agencies_agency_id");

			Officer o = new Officer();
			o.setOfficerId(id);
			o.setFirstName(firstName);
			o.setLastName(lastName);
			o.setBadgeNumber(badgeNumber);
			o.setRank(rank);
			o.setPhoneNumber(contactNumber);
			o.setAgencyId(agencyId);
			
			officers.add(o);
		}

		DBConnection.dbClose();

		return officers;
	}

}
