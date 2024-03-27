package com.tests;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.exceptions.InvalidIncidentDataException;
import com.exceptions.InvalidVictimDataException;
import com.model.Suspect;
import com.service.SuspectService;


public class SuspectTest {
	SuspectService suspectService;
	
	@Before
	public void inlitiazeEmployeeServiceObj() {
		suspectService = new SuspectService();
	}
	
	@Test
	public void getVictimByIdTest() {
		/* Use Case 1: Valid ID */
	    Suspect s1 = new Suspect(1,"Sherlock","Holmes",LocalDate.parse("1954-01-06"),"Male","8745213698",3);
	    Suspect s2 = new Suspect(2,"John","Watson",LocalDate.parse("1992-09-07"),"Male","7213458975",4);
	    Suspect s3 = new Suspect(3,"Irene","Adler",LocalDate.parse("1998-05-15"),"Female","9955478612",2);
	    Suspect s4 = new Suspect(4,"James","Moriarty",LocalDate.parse("1994-11-19"),"Male","8745968874",12);
		
		List<Suspect> list = new ArrayList<>();
		list.add(s1);list.add(s2);list.add(s3);list.add(s4);
		int incidentId =3; 
		 Suspect exceptedOutput = new  Suspect(1,"Sherlock","Holmes",LocalDate.parse("1954-01-06"),"Male","8745213698",3);
		
		try {
			Assert.assertEquals(exceptedOutput,suspectService.getSuspectByIncidentId(list,incidentId));
		} catch (InvalidIncidentDataException e) {}
		
		/* Use Case 2: Invalid ID*/
		incidentId =50; 
		
		try {
			Assert.assertEquals(exceptedOutput, suspectService.getSuspectByIncidentId(list,incidentId));
		} catch (InvalidIncidentDataException e) {
			Assert.assertEquals("Invalid ID Given".toLowerCase(), e.getMessage().toLowerCase());
		}	
	}
	
	@Test
	public void getVictimByNameTest() {
		/* Use Case 1: Valid ID */
		Suspect s1 = new Suspect(1,"Sherlock","Holmes",LocalDate.parse("1954-01-06"),"Male","8745213698",3);
	    Suspect s2 = new Suspect(2,"John","Watson",LocalDate.parse("1992-09-07"),"Male","7213458975",4);
	    Suspect s3 = new Suspect(3,"Irene","Adler",LocalDate.parse("1998-05-15"),"Female","9955478612",2);
	    Suspect s4 = new Suspect(4,"James","Moriarty",LocalDate.parse("1994-11-19"),"Male","8745968874",12);
		
	    List<Suspect> list = new ArrayList<>();
	    list.add(s1);list.add(s2);list.add(s3);list.add(s4);
		String name="Sherlock";
		 Suspect exceptedOutput = new  Suspect(1,"Sherlock","Holmes",LocalDate.parse("1954-01-06"),"Male","8745213698",3);
		
		try {
			Assert.assertEquals(exceptedOutput,suspectService.getSuspectByName1(list,name));
		} catch (InvalidVictimDataException e) {}
		
		/* Use Case 2: Invalid ID*/
		name="robot";
		
		try {
			Assert.assertEquals(exceptedOutput, suspectService.getSuspectByName1(list,name));
		} catch (InvalidVictimDataException e) {
			Assert.assertEquals("Invalid Name Given".toLowerCase(), e.getMessage().toLowerCase());
		}	
	}
	
	@After
	public void destroyEmployeeServiceObj() {
		suspectService = null;
	}

}
