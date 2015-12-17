package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

	@Test
	  public void testNonEmptyContactCreation() throws Exception {
		app.openMainPage();
		app.gotoAddNew();
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
		contact.new_group = "group 1";
		contact.address2 = "Test 1";
		contact.phone2 = "Test 1";
	    app.fillContactForm(this, contact);
	    app.submitContactCreation();
	    app.gotoHomePage();
	  }
}
