package com.example.framework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void gotoAddNew() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
	    type(By.name("lastname"), contact.lastname);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.home);
	    type(By.name("mobile"), contact.mobile);
	    type(By.name("work"), contact.work);
	    type(By.name("email"), contact.email);
	    type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
	    type(By.name("byear"), contact.byear);
	    //selectByText(By.name("new_group"), "group 1");
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void gotoHomePage() {
		click(By.linkText("home page"));
	}
	
	public void selectContactByIndex(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + index + "]/td[1]"));
	}

	public void initContactModification(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + index + "]/td[7]/a/img"));
	}
	
	public void submitContactModification() {
		click(By.name("update"));
	}

	public void showContactDetails(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + index + "]/td[6]/a/img"));
	}

	public void deleteContact() {
		click(By.xpath(".//*[@id='content']/form[2]/input[2]"));
	}

	public void addToNewGroup() {
		selectByText(By.name("to_group"), "Rob");
		click(By.name("add"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr[@name='entry']"));
		for (WebElement row : rows) {
		    ContactData contact = new ContactData();
		    List<WebElement> cells = row.findElements(By.tagName("td"));
		    String firstname = cells.get(1).getText();
		    String lastname = cells.get(2).getText();
		    String email = cells.get(3).getText();
		    String home = cells.get(4).getText();
		    contact.firstname = lastname;
		    contact.lastname = firstname;
		    contact.email = email;
		    contact.home = home;
		    contacts.add(contact);
		}
		return contacts;
	}

}
