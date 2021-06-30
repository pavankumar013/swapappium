package com.test.swag.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.test.swag.Utils.CommonLibrary;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutScreen extends BasePomPage {
	private AndroidDriver<MobileElement> driver;
	private List<String> paymentDetails=new ArrayList<String>();
	
	 @AndroidFindBy(accessibility = "test-First Name")
	 public MobileElement firstNameTextField; 
	 
	 @AndroidFindBy(accessibility = "test-Last Name")
	 public MobileElement lastNameTextField; 
	 
	 @AndroidFindBy(accessibility = "test-Zip/Postal Code")
	 public MobileElement zipcodeField;
	 
	 @AndroidFindBy(accessibility = "test-CONTINUE")
	 public MobileElement continueCTA;
	 
	 @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[2]")
	 public MobileElement paymentInformation;
	 
	 @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[4]")
	 public MobileElement shippingInformation;
	 
	 @AndroidFindBy(xpath =  "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[5]")
	 public MobileElement itemTotal;
	 
	 @AndroidFindBy(xpath =  "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[6]")
	 public MobileElement taxLabel;
	 
	 @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[7]")
	 public MobileElement totalLabel;
	 
	 @AndroidFindBy(accessibility = "test-FINISH")
	 public MobileElement finishCTA;
	 
	 public CheckoutScreen(AndroidDriver<MobileElement> driver) {
			this.driver=driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		} 
	 public void fillUserDetails(String firstName, String lastName, String zipCode)
	 {
		CommonLibrary.type(firstNameTextField,firstName);
		CommonLibrary.type(lastNameTextField, lastName);
		CommonLibrary.type(zipcodeField, zipCode);
		CommonLibrary.tapDeviceBack(driver);
	 }
	 
	 public void tapContinue()
	 {
		 CommonLibrary.Click(driver, continueCTA);
	 }
	 
	 public List<String> getPaymentDetails()
	 {
		 paymentDetails.add(paymentInformation.getText());
		 paymentDetails.add(shippingInformation.getText());
		 CommonLibrary.scrollDown(driver);
		 paymentDetails.add(itemTotal.getText());
		 paymentDetails.add(taxLabel.getText());
		 paymentDetails.add(totalLabel.getText());
		 return paymentDetails;
		
	 }
	 
	 public void clickFinishCTA()
	 {
		 CommonLibrary.Click(driver, finishCTA);
	 }
}
