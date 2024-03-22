package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Evidence;
import com.service.EvidenceService;

public class EvidenceController {
	public static void main(String[] args) {
        EvidenceService evidenceService = new EvidenceService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("*********EVIDENCE OPERATIONS**********");
            System.out.println("Press 1. Add evidence to incident");
            System.out.println("Press 2. Display all evidence for incident");
            System.out.println("Press 0 for exit");
            System.out.println("**************************************");
            int input = scanner.nextInt();
            if (input == 0) {
                System.out.println("Exiting.. thank you!!!");
                break;
            }
            switch (input) {
                case 1:
                    System.out.println("***ADD EVIDENCE TO INCIDENT***");
                    // Input evidence details
                    System.out.println("Enter description:");
                    String description = scanner.next();
                    System.out.println("Enter location found:");
                    String locationFound = scanner.next();
                    System.out.println("Enter incident ID:");
                    int incidentId = scanner.nextInt() ;
                    try {
                        incidentId = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid incident ID. Please enter a valid integer.");
                        break;
                    }
                    
                    // Create Evidence object
                    Evidence evidence = new Evidence(description, locationFound, incidentId);
                    
				try {
					try {
						evidenceService.addEvidenceToIncident(evidence);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

                  System.out.println("Evidence added successfully!");
                       
                    
                    
                    break;
        
                    
                case 2:
                	
                    System.out.println("***DISPLAY ALL EVIDENCE FOR INCIDENT***");
                    // Input incident ID
                    System.out.println("Enter incident ID:");
                    int incidentIdToDisplay = scanner.nextInt();
                    try {
                        incidentId = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid incident ID. Please enter a valid integer.");
                        break;
                    }
                    try {
                        // Get all evidence for incident
                        List<Evidence> evidenceList = null;
						try {
							evidenceList = evidenceService.getAllEvidenceForIncident(incidentIdToDisplay);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} 
						
                        // Display evidence
                        for (Evidence ev : evidenceList) {
                            System.out.println(ev);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error retrieving evidence: " + e.getMessage());
                    }
                    break;
                    
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
        scanner.close();
    }

}
