package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import static com.example.framework.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		app.navigateTo().mainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		//actions
		app.getContactHelper().initContactModification(1);
		//app.getContactHelper().initContactModification(index);
		contact.home = "911";
		contact.lastname = "Lastname";
		contact.firstname = "Firstname";
		contact.email = "new@gmail.com";
		app.getContactHelper().fillContactForm(contact, MODIFICATION);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().gotoHomePage();
		
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(1);
	    //oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
}
