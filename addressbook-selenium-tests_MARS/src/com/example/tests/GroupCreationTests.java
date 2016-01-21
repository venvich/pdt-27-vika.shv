package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	  int group_count = 1;
	  
	  for (int i = 1; i<=group_count; i++) {
		app.navigateTo().mainPage();
		app.navigateTo().groupsPage();
		
		//save old state 
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		
		//actions
		app.getGroupHelper()
			.initGroupCreation()
			.fillGroupForm(group, i)
			.submitGroupCreation()
			.returnToGroupsPage();
		
		//save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		
		//compare states
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	  }

  }
  
}
