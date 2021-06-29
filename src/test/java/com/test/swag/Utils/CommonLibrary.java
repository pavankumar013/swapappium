package com.test.swag.Utils;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.test.swag.driver.BaseSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CommonLibrary extends BaseSetup {
	
	public static FluentWait<AppiumDriver> wait = null;
	public static  AppiumDriver<MobileElement> driver;
	
	public CommonLibrary()
	
	{
		this.driver=super.getDriver();
	}
	public static String getTextFromElement(MobileElement ele) {
		return ele.getText().trim();
	}
	public static boolean isElementPresent(AppiumDriver<MobileElement> driver, MobileElement ele) {
		MobileElement element = null;
		try {
			@SuppressWarnings("unchecked")
			Wait waitForElement = new FluentWait(driver).withTimeout(Duration.ofMillis(180)).pollingEvery(Duration.ofMillis(20))
					.ignoring(NoSuchElementException.class);
			element = (MobileElement) waitForElement.until(ExpectedConditions.visibilityOf(ele));
			if (element != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	public static void Click(AppiumDriver<MobileElement> driver, MobileElement ele)
	{
		isElementPresent(driver, ele);
		ele.click();
	}
public static String Capture(String screenShotName) {
		
		String base64Format=((TakesScreenshot)aDriver).getScreenshotAs(OutputType.BASE64);
		return base64Format;

	}

public static void scrollDown(AndroidDriver<MobileElement> driver) {
	
	 TouchAction action = new TouchAction(driver);	
	 action.longPress(PointOption.point(600, 1000)).moveTo(PointOption.point(200, 300)).release().perform();
   
}
public static void scrollup(AndroidDriver<MobileElement> driver, MobileElement element) {

	TouchAction action = new TouchAction(driver);	
	 action.longPress(PointOption.point(200, 300)).moveTo(PointOption.point(600, 1000)).release().perform();
}

}
