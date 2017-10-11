package com.RFTDemo.scripts;

import org.junit.Assert;
import org.junit.Test;

import com.RFTDemo.util.DriverTestCase;

public class TC002_CreateNewIncident extends DriverTestCase {

	@Test
	public void CreateNewIncident() throws Exception{

		// Get the user credentials from properties file
		String username= propertyreader.readPropertyFile("TestUser");
		String password= propertyreader.readPropertyFile("Password");

		// Verify login page is displayed
		loginpage.verifyLoginPage();

		// login into application
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignIn();

		// verify login is successful
		header.isUserDropDownDisplayed();

		// navigate to Video section
		header.clickOnVideoTab();

		// click on Import button at videos section
		videopage.clickOnImportButton();

		// import a video
		videopage.importVideoFile(username);

		// verify import is successful
		videopage.videoImportedSuccessfuly();

		// click on Create New Incident button
		videopage.clickOnCreateNewIncidentBtn();

		// enter the incident title at incident form
		String title= "TestIncident";
		incidentpage.enterIncidentTitle(title);

		// click on Create incident button
		incidentpage.clickOnCreateIncidentBtn();

		// navigate to incident section
		header.clickOnIncidentTab();

		// verify Created incident is displayed
		boolean result = incidentpage.isIncidentExist(title);
		Assert.assertTrue("Created incident should exist", result);

		// delete all incident
		incidentpage.deleteIncident();

		// navigate to videos section
		header.clickOnVideoTab();

		// delete all videos
		videopage.deleteVideo();

		// logout from the application
		header.logout();

	}

}
