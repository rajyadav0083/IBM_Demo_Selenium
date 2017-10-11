package com.RFTDemo.scripts;


import org.junit.Test;

import com.RFTDemo.util.DriverTestCase;

public class TC001_ImportVideo extends DriverTestCase {

	@Test
	public void verifyVideoImport() throws Exception{
		
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
		
		// navigate to Video section
		header.clickOnVideoTab();
		
		// delete all videos
		videopage.deleteVideo();
		
		// logout from the application
		header.logout();
		
	}
}
