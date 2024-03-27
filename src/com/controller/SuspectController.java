package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;

import com.exceptions.InvalidIncidentDataException;
import com.exceptions.InvalidSuspectDataException;
import com.model.Suspect;
import com.service.SuspectService;




public class SuspectController {

	public static void main(String[] args) throws InvalidSuspectDataException {
		Scanner sc=new Scanner(System.in);
		SuspectService suspectService=new SuspectService();
		while(true) {
			System.out.println("Press 1. To Add a Suspect");
			System.out.println("Press 2. To Delete a Suspect");
			System.out.println("Press 3. To Display Suspect by Incident Id");
			System.out.println("Press 4. To Search Suspect By Name");
			System.out.println("Press 0. To Exit");
			int in=sc.nextInt();
			if(in==0)
			{
				System.out.println("Exiting.... Thank You");
				break;
			}
			switch(in)
			{
			case 1:
				
				System.out.println("Enter firstName:");
				String firstName=sc.next();
				System.out.println("Enter lastName:");
				String lastName=sc.next();
				System.out.println("Enter dob:");
				String dobString = sc.next();
				LocalDate dob = LocalDate.parse(dobString);
				
				System.out.println("Enter gender:");
				String gender=sc.next();
				System.out.println("Enter phone no:");
				String contactInfo=sc.next();
				System.out.println("Enter incident id:");
				int incidentId=sc.nextInt();
				Suspect suspect=new Suspect(firstName,lastName,dob,gender,contactInfo,incidentId);
				try {
					suspectService.addRecord(suspect);
					System.out.println("inserted successfully");
				} catch (ClassNotFoundException | SQLException | InvalidIncidentDataException e) {
					System.out.println(e.getMessage());
					//e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Deleting Suspect Record");
				System.out.println("Enter Suspect id:");
				int id2=sc.nextInt();
				try {
					suspectService.deleteSuspect(id2);
				} catch (ClassNotFoundException | SQLException | InvalidSuspectDataException e1) {
					System.out.println(e1.getMessage());
					
				}

				break;
			case 3:
				System.out.println("Displaying Suspect details by using Incident Id");
				System.out.println("Enter incident id:");
				int id1=sc.nextInt();
				
				try {
					List<Suspect> v = suspectService.getSuspect(id1);
					if(v.isEmpty())
					{
						System.out.println("Invalid Id");
					}
					else {
						for(Suspect vic:v)
						{
							System.out.println(vic);
						}
					}
					
					
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					
				}
				
				break;
			case 4:
				System.out.println("Displaying Suspect details by using name");
				System.out.println("Enter suspect name:");
				String name=sc.next();
				try {
					List<Suspect> v = suspectService.getSuspectByName(name);
					if(v.isEmpty())
					{
						System.out.println("Invalid name");
					}
					else {
						for(Suspect vic:v)
						{
							System.out.println(vic);
						}
					}
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					
				}
				break;
			default:
				System.out.println("Invalid Input");
			}
		}
		sc.close();
	}

	

}
