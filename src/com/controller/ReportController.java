package com.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.enums.Status;
import com.model.Incident;
import com.model.Report;
import com.service.IncidentService;
import com.service.ReportService;

public class ReportController {

	public static void main(String args[])
	{
		
		//Initialize objects required for all the function created in the controller
		
		ReportService reportService = new ReportService();
		IncidentService incidentService = new IncidentService();
		Scanner sc = new Scanner (System.in);
		
		while(true)
		{
			//Operation selection 
			System.out.println("Select an operation to perform");
			System.out.println("Press 1. Add report to an Indicent");
			System.out.println("Press 2. Display detailed report for Incident")	;
			System.out.println("Press 0. To Terminate...");
			int choice = sc.nextInt();
			sc.nextLine();
			
			//Exit program
			if (choice == 0) {
				System.out.println("EXITING....");
				break;
			}
			
			
			switch (choice) {
			
			case 1:
				
				// Add Report to Incident function 
				
				try
				{
					// create object -> for class report to pass as argument for the function 
					Report r = new Report();
					
					// get date
					System.out.println("Enter report date (YYYY-MM-DD): ");
					String date = sc.nextLine();
					r.setReportDate(Date.valueOf(date));
					
					//get report details
					System.out.println("Enter the report details  : ");
					String details = sc.nextLine();
					r.setReportDetails(details);
					
					//select Status
					System.out.println("Enter the status of the report : ");
					System.out.println("Choose the Status of the Incident/Case");
					System.out.println("press 1. For Open");
					System.out.println("press 2. For Closed");
					System.out.println("press 3. For Investigating");
					System.out.println("press 4. For Pending");
					int y = sc.nextInt();
					if(y == 1) r.setStatus(Status.OPEN);
					if(y == 2) r.setStatus(Status.CLOSED);
					if(y == 3) r.setStatus(Status.INVESTIGATION);
					if(y == 4) r.setStatus(Status.PENDING);
					
					//get Incident ID
					System.out.println("Enter the Incident Id for this report :");
					int incidentId = sc.nextInt();
					if(!incidentService.idExsist(incidentId))break;
					r.setIncidentId(incidentId);
					//Function call to the add report to incident function ->  ReportSercice.java
					reportService.addReportToIncident(r);
				
					
				}catch (Exception e) {e.printStackTrace();}
				break;
			case 2:
				try
				{
					System.out.println("Enter Incident Id of the Report: ");
					int id = sc.nextInt();
					if(!incidentService.idExsist(id))break;
					List <Report> list = reportService.fetchReportForId(id);
					System.out.println("ID  Report_Date   Report_Details   Status    Incident_Id");
					for(Report r:list) 
					{
						System.out.println(r.getReportId()+"  "+r.getReportDate()+"   "+r.getReportDetails()+"    "+
					r.getStatus()+"     "+r.getIncidentId());
					}
					
				}catch (Exception e) {e.printStackTrace();}
				break;
			default:
				System.out.println("invalid option");
			
			}
				
		}
		
		
	}
	
	
}
