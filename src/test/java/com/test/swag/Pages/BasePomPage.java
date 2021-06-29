package com.test.swag.Pages;



import com.test.swag.driver.BaseSetup;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePomPage extends BaseSetup  {
	public static  AndroidDriver<MobileElement> driver;
public  BasePomPage() {

	this.driver=super.getDriver();
}
	 
}
