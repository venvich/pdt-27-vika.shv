package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ContactCreationTest extends TestBase {

	@Test
	  public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		//actions
		app.getContactHelper().gotoAddNew();
		ContactData contact = new ContactData();
		contact.firstname = "Personname";
		contact.lastname = "Person-Lastname";
		contact.address = "Testroad 1, 12345 Testwill";
		contact.home = "+41317770140";
		contact.mobile = "+41787770140";
		contact.work = "";
		contact.email = "test@gmail.com";
		contact.email2 = "";
		contact.bday = "22";
		contact.bmonth = "September";
		contact.byear = "1986";
		//contact.new_group = "group 1";
		contact.address2 = "Test 1";
		contact.phone2 = "Test 1";
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().gotoHomePage();
	    
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    //assertEquals(newList.size(), oldList.size()+1);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	    
	  }
}
