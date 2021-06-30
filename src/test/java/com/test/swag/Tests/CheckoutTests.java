package com.test.swag.Tests;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.swag.Pages.CartScreen;
import com.test.swag.Pages.CheckoutScreen;
import com.test.swag.Pages.HomeScreen;
import com.test.swag.Pages.ThannkyouScreen;
import com.test.swag.Utils.Reporterutils;
import com.test.swag.driver.BaseSetup;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CheckoutTests extends BaseSetup  {
	private AndroidDriver<MobileElement> driver;
	SoftAssert checkoutAsserts;
	HomeScreen homeScreen;
	CartScreen cartScreen;
	CheckoutScreen checkoutScreen;
	ThannkyouScreen thankyouScreen;
	@BeforeClass
	public void checkoutSetup() {
		driver = getDriver();
		homeScreen=new HomeScreen(driver);
		checkoutAsserts=new SoftAssert();
		cartScreen=new CartScreen(driver);
		checkoutScreen=new CheckoutScreen(driver);
		thankyouScreen=new ThannkyouScreen(driver);
	}
	
	@Test(description="Verify user checkout successfully ")
	public void checkoutProduct()
	{
		try
		{
			
		Reporterutils.create("Verify user checkout successfully");
		//tap on the first product in Homescreen
		List<String> productDetailsHomeScreen=homeScreen.getProductList();
		
		homeScreen.tapAddToCart();
		
		//Verify addtocart CTA is displayed with Remove label
		checkoutAsserts.assertTrue(homeScreen.removeCTAText().equals("REMOVE"));
		//Tap on cart icon to navigate to cart
		homeScreen.tapCartIcon();
		
		//Verify productname and price in cart and home screen.
		checkoutAsserts.assertEquals(productDetailsHomeScreen.get(0), cartScreen.getProductNamePriceCart().get(0));
		checkoutAsserts.assertEquals(productDetailsHomeScreen.get(1), cartScreen.getProductNamePriceCart().get(1));
		Reporterutils.info(productDetailsHomeScreen+" product details in home screen");
		
		//TAP on checkout
		cartScreen.tapCheckoutCTA();
		
		//Fill the details
		checkoutScreen.fillUserDetails("first", "last", "95111");
		checkoutScreen.tapContinue();
		
		//get the payment information
		Reporterutils.info(checkoutScreen.getPaymentDetails());
		
		//Tap on Finish
		checkoutScreen.clickFinishCTA();
		
		//Verify thankyou screen label
		checkoutAsserts.assertTrue(thankyouScreen.getThankyouScreenInformation().get(0).contains("THANK YOU FOR YOU ORDER"));
		Reporterutils.info(thankyouScreen.getThankyouScreenInformation()+" Thankyou screen information");
		checkoutAsserts.assertAll();
		Reporterutils.pass("User successfully checkout");
	}catch(Throwable e)
		{
			Reporterutils.fail("checkout", "check", e.getMessage());
		}
	}
}
