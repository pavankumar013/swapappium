package com.test.swag.driver;


	import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.swag.Utils.Reporterutils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;



	public class BaseSetup
	{

		public static AndroidDriver<MobileElement> aDriver = null;
		public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		public static com.aventstack.extentreports.ExtentTest test;

		public static String platformVersion = "10";
		public static String platformName = "Android";
		public static String deviceName = "device";

		public static String AppName = getAppDetails().getName();
		public static String app = getAppDetails().getAbsolutePath();
		public static String appPackage = "com.swaglabsmobileapp";
		public static String appActivity = "com.swaglabsmobileapp.SplashActivity";
	     
	     public static File getAppDetails()
	     {
	    	 File f= new File(System.getProperty("user.dir")+"/src/test/resources/app");
	    	 File[] list=f.listFiles();
	    		return list[0];
	     }
	    @BeforeTest
	     public void setup() throws MalformedURLException{
	    	initDriver();
	    }

	     public   AndroidDriver<MobileElement> getDriver() {
	         return aDriver;
	       
	     }

	     public void initDriver() throws MalformedURLException{
	  
	   		System.out.println("Inside the driver class");
	 		
	 		DesiredCapabilities capabilities = new DesiredCapabilities(); 
		 		System.out.println("in Android");
		 		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		 		capabilities.setCapability("deviceName", deviceName);
		 		capabilities.setCapability("platformName", "Android");
		 		capabilities.setCapability("appPackage", appPackage);
		 		capabilities.setCapability("appActivity", appActivity);
		 		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		 		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 360);
		 		capabilities.setCapability("showChromedriverLog", true);
		 		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		 		
		 		aDriver=new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities);
		 		Reporterutils.startReport();
		 	
	     }
	     
	   
	    
		@AfterClass
	     public void tearDown() throws Throwable{
   	 	try {
   	 		aDriver.quit();
   	 	}catch(Exception e) {
 	 		e.printStackTrace();
   	 	}
	     }
	}


