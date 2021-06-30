package com.test.swag.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.test.swag.Utils.CommonLibrary;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ThannkyouScreen extends BasePomPage {
	private AndroidDriver<MobileElement> driver;
	List<String> thankyouScreenList=new ArrayList<String>();
	 @AndroidFindBy(xpath =  "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
	 public MobileElement thankyouScreenHeaderText;  
	 
	 @AndroidFindBy(xpath =  "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[2]")
	 public MobileElement orderConfirmationText;  
	 
	 @AndroidFindBy(accessibility = "test-BACK HOME")
	 public MobileElement backHomeCTA;  
	 
	 public ThannkyouScreen(AndroidDriver<MobileElement> driver) {
			this.driver=driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		} 
	public void clickBackHome()
	{
		backHomeCTA.click();
	}
	
	
	public List<String> getThankyouScreenInformation()
	{
		thankyouScreenList.add(CommonLibrary.getTextFromElement(thankyouScreenHeaderText));
		thankyouScreenList.add(CommonLibrary.getTextFromElement(orderConfirmationText));
		return thankyouScreenList;
	}
	
	
}
