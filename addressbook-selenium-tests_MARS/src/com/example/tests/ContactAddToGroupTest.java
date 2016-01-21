package com.example.tests;

import org.testng.annotations.Test;

public class ContactAddToGroupTest extends TestBase {
	
	@Test
	public void addContactToGroup(){
	app.navigateTo().mainPage();
	app.getContactHelper().selectContactByIndex(2);
	app.getContactHelper().addToNewGroup();
	app.navigateTo().goHome();
	}

}
