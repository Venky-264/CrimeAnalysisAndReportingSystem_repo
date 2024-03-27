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
import com.model.Victim;
import com.service.VictimService;

public class VictimTest {
	VictimService victimService;
	
	@Before
	public void inlitiazeEmployeeServiceObj() {
		victimService = new VictimService();
	}
	
	@Test
	public void getVictimByIdTest() {
		/* Use Case 1: Valid ID */
	    Victim v1 = new Victim(13,"pavan","kalyan",LocalDate.parse("2024-03-21"),"male","7854962146",1);
	    Victim v2 = new Victim(14,"Tony","Montana",LocalDate.parse("1985-06-22"),"Male","7845698123",2);
	    Victim v3 = new Victim(15,"Frank","Underwood",LocalDate.parse("1988-08-05"),"Male","8457962145",3);
	    Victim v4 = new Victim(16,"Sarah","Connor",LocalDate.parse("1972-05-15"),"Female","7896541230",12);
		
		List<Victim> list = new ArrayList<>();
		list.add(v1);list.add(v2);list.add(v3);list.add(v4);
		int incidentId =2; 
		Victim exceptedOutput = new Victim(14,"Tony","Montana",LocalDate.parse("1985-06-22"),"Male","7845698123",2);
		
		try {
			Assert.assertEquals(exceptedOutput,victimService.getVictimByIncidentId(list,incidentId));
		} catch (InvalidIncidentDataException e) {}
		
		/* Use Case 2: Invalid ID*/
		incidentId =50; 
		
		try {
			Assert.assertEquals(exceptedOutput, victimService.getVictimByIncidentId(list,incidentId));
		} catch (InvalidIncidentDataException e) {
			Assert.assertEquals("Invalid ID Given".toLowerCase(), e.getMessage().toLowerCase());
		}	
	}
	
	@Test
	public void getVictimByNameTest() {
		/* Use Case 1: Valid ID */
	    Victim v1 = new Victim(13,"pavan","kalyan",LocalDate.parse("2024-03-21"),"male","7854962146",1);
	    Victim v2 = new Victim(14,"Tony","Montana",LocalDate.parse("1985-06-22"),"Male","7845698123",2);
	    Victim v3 = new Victim(15,"Frank","Underwood",LocalDate.parse("1988-08-05"),"Male","8457962145",3);
	    Victim v4 = new Victim(16,"Sarah","Connor",LocalDate.parse("1972-05-15"),"Female","7896541230",12);
		
		List<Victim> list = new ArrayList<>();
		list.add(v1);list.add(v2);list.add(v3);list.add(v4);
		String name="Tony";
		Victim exceptedOutput = new Victim(14,"Tony","Montana",LocalDate.parse("1985-06-22"),"Male","7845698123",2);
		
		try {
			Assert.assertEquals(exceptedOutput,victimService.getVictimByName1(list,name));
		} catch (InvalidVictimDataException e) {}
		
		/* Use Case 2: Invalid ID*/
		name="robot";
		
		try {
			Assert.assertEquals(exceptedOutput, victimService.getVictimByName1(list,name));
		} catch (InvalidVictimDataException e) {
			Assert.assertEquals("Invalid Name Given".toLowerCase(), e.getMessage().toLowerCase());
		}	
	}
	
	@After
	public void destroyEmployeeServiceObj() {
		victimService = null;
	}
}