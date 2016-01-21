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
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i<2; i++) {
			ContactData contact = new ContactData();
			
			contact.firstname = generateRandomString() + "_firstname";
			contact.lastname = generateRandomString() + "_lastname";
			contact.address = generateRandomString() + "_address";
			contact.home = "+41411111111";
			contact.mobile = "+41782222222";
			contact.work = "+41333333333";
			contact.email = generateRandomString() + "@gmail.com";
			contact.email2 = generateRandomString() + "@gmail.com";
			contact.bday = "22";
			contact.bmonth = "September";
			contact.byear = "1986";
			contact.address2 = generateRandomString() + "_address2";
			contact.phone2 = "+414444444444";
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(20) == 0){
			return "";
		} else {
			return "Person" + rnd.nextInt();
		}
	}
	
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
