package com.test.swag.Tests;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.swag.Pages.LoginScreen;
import com.test.swag.Utils.Reporterutils;
import com.test.swag.driver.BaseSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwagTests extends BaseSetup {

	private AndroidDriver<MobileElement> driver; 
	
	LoginScreen loginScreen;
	SoftAssert loginAsserts;
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void swagTestsSetup() {
		driver = getDriver();
		loginScreen=new LoginScreen(driver);
		loginAsserts=new SoftAssert();
	}
	
	@Test(description="Verify user logs into the app as standard user")
	public void loginTest()
	{
		try
		{
		Reporterutils.create("Verify user logs into the app as standard user");
			//scroll down to tap on standard user
		Boolean result=loginScreen.scrolldown();
		loginAsserts.assertTrue(result);
		Reporterutils.info("User scrolls down to select standard user");
		//tap on standard user
		loginScreen.tapStandardUser();
		loginScreen.scrollup();
		
		//Get the text populated in the login textfield
		Reporterutils.info(loginScreen.getTextFromTextField()+" user name populated");
		loginScreen.tapLogin();
		
	}catch(Throwable e)
		{
			Reporterutils.fail("login failed", "login", e.getMessage());
		}
}
}
