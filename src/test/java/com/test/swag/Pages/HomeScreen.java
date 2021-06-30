package com.test.swag.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.test.swag.Utils.CommonLibrary;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends BasePomPage {
	private AndroidDriver<MobileElement> driver;
	List<String> productInfoHomeScreen=new ArrayList<String>();
	 @AndroidFindBy(accessibility = "test-Toggle")
	 public MobileElement toggleButton;
	 
	 @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
	 public List<MobileElement> productNameList;
	 
	 @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
	 public List<MobileElement> priceList;
	 
	 @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
	 public List<MobileElement> addtocartCTA;
	 
	 @AndroidFindBy(accessibility = "test-REMOVE")
	 public MobileElement removeCTA;
	 @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup")
	 public MobileElement cartIcon;
	 @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]/android.widget.TextView")
	 public MobileElement removeCTAText;
	 
		public HomeScreen(AndroidDriver<MobileElement> driver) {
			this.driver=driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		} 
		
		public List<String> getProductList()
		{
			productInfoHomeScreen.add(productNameList.get(0).getText());
			productInfoHomeScreen.add(priceList.get(0).getText());
			return productInfoHomeScreen;
		}
		
		public void tapAddToCart()
		{
			CommonLibrary.Click(driver, addtocartCTA.get(0));
		}
		
		 public void tapCartIcon()
		 {
			 CommonLibrary.Click(driver, cartIcon);
		 }
		public String removeCTAText()
		{
			return CommonLibrary.getTextFromElement(removeCTAText);
		}
		
		public void waitForHomeScreenToLoad()
		{
			CommonLibrary.isElementPresent(driver, cartIcon);
;		}
		
}
