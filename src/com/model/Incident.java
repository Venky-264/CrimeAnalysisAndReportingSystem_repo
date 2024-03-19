package com.model;

import java.util.Date;

import com.enums.IncidentType;
import com.enums.Status;

public class Incident {

	private int incidentId;
	private IncidentType incidentType;
	private Date incidentDate;
	private String location;
	private String description;
	private Status status;
	private int officerId;
	
	public Incident() { }

	public Incident(IncidentType incidentType, Date incidentDate, String location, String description, Status status,int officerId) {
		
		this.incidentType = incidentType;
		this.incidentDate = incidentDate;
		this.location = location;
		this.description = description;
		this.status = status;
		this.officerId=officerId;
	}


	public Incident(int incidentId, IncidentType incidentType, Date incidentDate, String location, String description,
			Status status,int officerId) {
		
		this.incidentId = incidentId;
		this.incidentType = incidentType;
		this.incidentDate = incidentDate;
		this.location = location;
		this.description = description;
		this.status = status;
		this.officerId=officerId;
	}

	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

	public IncidentType getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(IncidentType incidentType) {
		this.incidentType = incidentType;
	}

	public Date getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getOfficerId() {
		return officerId;
	}

	public void setOfficerId(int officerId) {
		this.officerId = officerId;
	}

	@Override
	public String toString() {
		return "Incident [incidentId=" + incidentId + ", incidentType=" + incidentType + ", incidentDate="
				+ incidentDate + ", location=" + location + ", Description=" + description + ", status=" + status
				+ ", officerId=" + officerId + "]";
	}

	
	
	
}
