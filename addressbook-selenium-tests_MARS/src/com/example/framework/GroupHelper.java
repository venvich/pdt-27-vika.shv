package com.example.framework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group, int i) {
		type(By.name("group_name"), group.getGroup_name());
		type(By.name("group_header"), group.getGroup_header());
		type(By.name("group_footer"), group.getGroup_footer());
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}
	
	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
		return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath(".//*[@id='content']/form[2]/input[" + (index+1) + "]"));
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length()-")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}
}
