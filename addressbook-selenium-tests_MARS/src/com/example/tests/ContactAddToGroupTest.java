package com.example.tests;

import org.testng.annotations.Test;

public class ContactAddToGroupTest extends TestBase {
	
	@Test
	public void addContactToGroup(){
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().selectContactByIndex(2);
	app.getContactHelper().addToNewGroup();
	app.getNavigationHelper().goHome();
	}

}
