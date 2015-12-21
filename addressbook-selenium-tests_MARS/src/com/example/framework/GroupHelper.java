package com.example.framework;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void fillGroupForm(GroupData group, int i) {
		type(By.name("group_name"), group.group_name);
		type(By.name("group_header"), group.group_header);
		type(By.name("group_footer"), group.group_footer);
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}
	
	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));		
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath(".//*[@id='content']/form[2]/input[" + index + "]"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
	}
}
