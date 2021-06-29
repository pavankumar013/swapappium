package com.test.swag.Pages;


import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.test.swag.Utils.CommonLibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen  extends BasePomPage {
	private AndroidDriver<MobileElement> driver;

	 @AndroidFindBy(accessibility = "test-Username")
	 public MobileElement userNameTextField;
	 
	 @AndroidFindBy(accessibility = "test-Password")
	 public MobileElement passwordTextfield;
	 
	 @AndroidFindBy(accessibility = "test-standard_user")
	 public MobileElement standardUserLabel;
	 
	 @AndroidFindBy(accessibility = "test-locked_out_user")
	 public MobileElement lockedOutUserLabel;
	 
	 @AndroidFindBy(accessibility = "test-problem_user")
	 public MobileElement problemUserLabel;
	 
	 @AndroidFindBy(accessibility = "test-LOGIN")
	 public MobileElement loginCTA;
	 
	 @AndroidFindBy(xpath="//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[2]")
	 public MobileElement avatar;
	 
	 @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-standard_user\"]/android.widget.TextView")
	 public List<MobileElement> standardUserText;
	 
		public LoginScreen(AndroidDriver<MobileElement> driver) {
			this.driver=driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		} 
		
		public String getTextFromTextField()
		{
			return userNameTextField.getAttribute("text").trim();
		}
		
		public void tapStandardUser()
		{
			CommonLibrary.Click(driver, standardUserLabel);
		}
		
		public void tapLogin()
		{
			CommonLibrary.Click(driver, loginCTA);
		}
		
		public Boolean scrolldown()
		{
			CommonLibrary.scrollDown(driver);
			return standardUserText.size()>0;
		}
		
		public void scrollup()

		{
			CommonLibrary.scrollup(driver, avatar);
		}
		
	
		
		
		
}
