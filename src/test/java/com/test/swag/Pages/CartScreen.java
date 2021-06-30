package com.test.swag.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartScreen extends BasePomPage {
	private AndroidDriver<MobileElement> driver;

	 @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
	 public MobileElement productName;
	 
	 @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
	 public MobileElement productDescription;
	 
	 @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView")
	 public MobileElement productPrice;
	 
	 @AndroidFindBy(accessibility = "test-REMOVE")
	 public MobileElement removeCTA;
	 
	 @AndroidFindBy(accessibility = "test-CHECKOUT")
	 public MobileElement checkoutCTA;
	 
	 public CartScreen(AndroidDriver<MobileElement> driver) {
			this.driver=driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		} 
	 
	 List<String> productPriceName=new ArrayList<String>();
	 public List<String> getProductNamePriceCart()
	 {
		 productPriceName.add(productName.getText());
		 productPriceName.add(productPrice.getText());
		 return productPriceName;
	 }
	 
	 public void tapCheckoutCTA()
	 {
		 checkoutCTA.click();
	 }
	 
	
}
