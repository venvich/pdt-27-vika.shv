package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ContactCreationTest extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	  public void testNonEmptyContactCreation(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		//actions
		app.getContactHelper().gotoAddNew();
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().gotoHomePage();
	    
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    //assertEquals(newList.size(), oldList.size()+1);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	    
	  }
}
