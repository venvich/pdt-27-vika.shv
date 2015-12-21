package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.group_name = "New name";
		app.getGroupHelper().fillGroupForm(group, 1);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
	}
}
