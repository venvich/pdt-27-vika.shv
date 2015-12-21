package com.example.tests;

import org.testng.annotations.Test;

public class ContactShowDetailsTest extends TestBase {
	
	@Test
	public void showDetailsOfContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().selectContactByIndex(2);
		app.getContactHelper().showContactDetails(2);
		app.getNavigationHelper().goHome();
	}

}
