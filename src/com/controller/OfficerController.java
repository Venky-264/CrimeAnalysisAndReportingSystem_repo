package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.enums.IncidentType;
import com.model.Incident;
import com.model.Officer;
import com.service.OfficerService;

public class OfficerController {

	public static void main(String[] args) {
	
		OfficerService officerService=new OfficerService();
		
		Scanner sc=new Scanner(System.in);
		
		while (true) {
			System.out.println("press 1.for displaying all Officers ");
			System.out.println("press 2.to insert a new Officer with a rank");
			System.out.println("press 3.to assign officer to an incident");
			System.out.println("press 4. for deleting an officer");
			System.out.println("press 0. to exit...");
			int choice = sc.nextInt();

			if (choice == 0) {
				System.out.println("EXITING....");
				break;
			}
			switch (choice) {
			case 1:
				try {
					List<Officer> officers=officerService.fetchAllOfficers();
					System.out.println("Id  fName   lname   badgeNUmber    rank    phonrNumber    agencyId");
					for(Officer o:officers) {
						System.out.println(o.getOfficerId()+"    "+o.getFirstName()+"     "+
					o.getLastName()+"    "+o.getBadgeNumber()+"    "+o.getRank()+"      "+
								o.getPhoneNumber()+"     "+o.getAgencyId());
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
			default:
				System.out.println("invalid option");
			}

		}
	
	}

}
