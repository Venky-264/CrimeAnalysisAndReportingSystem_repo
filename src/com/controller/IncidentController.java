package com.controller;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.*;


import com.service.IncidentService;
import com.enums.*;
import com.model.*;

public class IncidentController {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		IncidentService incidentService = new IncidentService();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("press 1.for displaying all incidents ");
			System.out.println("press 2.to insert a new incident");
			System.out.println("press 3.for updating the status of a specific incident");
			System.out.println("press 4. for displaying incidents withing specific dates");
			System.out.println("press 5. to search an incident of a specific type");
			System.out.println("press 6. generate report for an incident");
			System.out.println("press 0. to exit...");
			int choice = sc.nextInt();
			sc.nextLine();
			if (choice == 0) {
				System.out.println("EXITING....");
				break;
			}
			switch (choice) {
			case 1:
				
				try {
					List<Incident> incidents=incidentService.getAllIncidents();
					System.out.println("ID  IncidentType   IncidentDate   Loaction   Status    officerId");
					for(Incident i:incidents) {
						System.out.println(i.getIncidentId()+"  "+i.getIncidentType()+"   "+
					i.getIncidentDate()+"    "+i.getLocation()+"     "+i.getStatus()+
					"     "+i.getOfficerId());
					}
				} catch (ClassNotFoundException | SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				
				Incident i = new Incident();
				System.out.println("Choose the Incident Type");
				System.out.println("press 1. For HOMICIDE");
				System.out.println("press 2. For ROBBERY");
				System.out.println("press 3. For THEFT");
				int x = sc.nextInt();
				if(x == 1) i.setIncidentType(IncidentType.HOMICIDE);
				if(x == 2) i.setIncidentType(IncidentType.ROBBERY);
				if(x == 3) i.setIncidentType(IncidentType.THEFT);
				sc.nextLine();
				System.out.println("Incident Date");
				String date = sc.nextLine();
		        try {
		            Date parsedDate = dateFormat.parse(date);
		            i.setIncidentDate(parsedDate);
		        } catch (ParseException e) {
		            System.out.println("Error: Date string is not in the correct format.");
		            e.printStackTrace();
		        }
				System.out.println("Enter the Incident Location: ");
				i.setLocation(sc.nextLine());
				System.out.print("Enter  a description of the incident description: ");
				i.setDescription(sc.nextLine());
				System.out.println("Choose the Status of the Incident/Case");
				System.out.println("press 1. For Open");
				System.out.println("press 2. For Closed");
				System.out.println("press 3. For Investigating");
				int y = sc.nextInt();
				if(y == 1) i.setStatus(Status.OPEN);
				if(y == 2) i.setStatus(Status.CLOSED);
				if(y == 3) i.setStatus(Status.INVESTIGATING);
				System.out.println("Enter the Officer In-Charger of the Incident");
				i.setOfficerId(sc.nextInt());
				incidentService.createIncident(i);
				break;
			case 3:
				System.out.println("Enter Start Date: ");
				String fromdate = sc.nextLine();
				System.out.println("Enter End Date: ");
				String todate = sc.nextLine(); 
		        try {
		            Date fromDate = dateFormat.parse(fromdate);
		            Date toDate = dateFormat.parse(todate);
		            List <Incident> list = incidentService.getIncidentsInDateRange(fromDate,toDate);
		            for(Incident incident: list)System.out.println(incident.toString());
		        } catch (ParseException e) {
		            System.out.println("Error: Date string is not in the correct format.");
		            e.printStackTrace();
		        }
				break;
			case 4:
				try {
				System.out.println("Enter the Incident Criteria to search by: ");
				List<Incident> list = incidentService.searchIncidents(IncidentType.valueOf(sc.nextLine().toUpperCase()));
				for(Incident incidents : list)System.out.println(incidents.toString());
				}catch (Exception e)
				{
					e.printStackTrace();
				}
				break;
			case 5:
				
				break;
			case 6:
				break;
			default:
				System.out.println("invalid option");
			}

		}
		sc.close();

	}

}
