package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.service.IncidentService;
import com.enums.IncidentType;
import com.model.*;

public class IncidentController {

	public static void main(String[] args) {

		IncidentService incidentService = new IncidentService();

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
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("invalid option");
			}

		}

	}

}
