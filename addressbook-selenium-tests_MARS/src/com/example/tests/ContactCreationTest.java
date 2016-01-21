package com.example.tests;


import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

import static com.example.framework.ContactHelper.CREATION;

import static org.testng.Assert.*;

public class ContactCreationTest extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	  public void testNonEmptyContactCreation(ContactData contact) throws Exception {
		app.navigateTo().mainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		//actions
		app.getContactHelper().gotoAddNew();
	    app.getContactHelper().fillContactForm(contact, CREATION);
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().gotoHomePage();
	    
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	    
	  }
}
