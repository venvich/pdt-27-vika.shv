package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.framework.ApplicationManager;


public class TestBase {
	
	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	   }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i=0; i<5; i++) {
			GroupData group = new GroupData();
			group.group_name = generateRandomString();
			group.group_header = generateRandomString();
			group.group_footer = generateRandomString();
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i<2; i++) {
			ContactData contact = new ContactData();
			
			contact.firstname = generateRandomStringContacts() + "_firstname";
			contact.lastname = generateRandomStringContacts() + "_lastname";
			contact.address = generateRandomStringContacts() + "_address";
			contact.home = "+41411111111";
			contact.mobile = "+41782222222";
			contact.work = "+41333333333";
			contact.email = generateRandomStringContacts() + "@gmail.com";
			contact.email2 = generateRandomStringContacts() + "@gmail.com";
			contact.bday = "22";
			contact.bmonth = "September";
			contact.byear = "1986";
			contact.address2 = generateRandomStringContacts() + "_address2";
			contact.phone2 = "+414444444444";
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	public String generateRandomStringContacts() {
		Random rnd = new Random();
		if (rnd.nextInt(20) == 0){
			return "";
		} else {
			return "Person" + rnd.nextInt();
		}
	}
	
}
