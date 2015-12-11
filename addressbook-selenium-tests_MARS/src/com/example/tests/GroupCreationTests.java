package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	  int group_count = 2;
	  
	  for (int i = 1; i<=group_count; i++) {
		openMainPage();
		gotoGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData();
		group.group_name = "group"+" "+i;
		group.group_header = "header"+" "+i;
		group.group_footer = "footer"+" "+i;
		fillGroupForm(group, i);
		submitGroupCreation();
		returnToGroupsPage();
	  }
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	  String group_name = "";
	  String group_header = "";
	  String group_footer = "";
	  int group_count = 2;
	  
	  for (int i = 1; i<=group_count; i++) {
		openMainPage();
		gotoGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData(group_name, group_header, group_footer);
		fillGroupForm(group, i);
		submitGroupCreation();
		returnToGroupsPage();
	  }
  }
}
