package com.example.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<GroupData> cacheGroups;
	
public SortedListOf<GroupData> getGroups() {
	if (cacheGroups == null) {
		rebuildCache();
	}
	return cacheGroups;
}

	private void rebuildCache() {
		cacheGroups = new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length()-")".length());
			cacheGroups.add(new GroupData().withName(name));
		}
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
		rebuildCache();
		return this;
	}

	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		rebuildCache();
		return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		rebuildCache();
		return this;
	}
	
	//------------------------------------------------------------

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
	//public GroupHelper fillGroupForm(GroupData group, int i) {	
		type(By.name("group_name"), group.getGroup_name());
		type(By.name("group_header"), group.getGroup_header());
		type(By.name("group_footer"), group.getGroup_footer());
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cacheGroups = null;
		return this;
	}
	
	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	

	public void submitGroupDeletion() {
		click(By.name("delete"));
		cacheGroups = null;
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
		cacheGroups = null;
		return this;
	}

	
}
