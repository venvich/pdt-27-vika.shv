package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().selectContactByIndex(2);
		app.getContactHelper().initContactModification(2);
		ContactData contact = new ContactData();
		contact.home = "911";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().gotoHomePage();
	}
}
