package com.mobile.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchSalesForceApp {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriver<MobileElement> driver;
		
		URL url  = new URL("http://0.0.0.0:4723/wd/hub");
		
		DesiredCapabilities dcS = new DesiredCapabilities();
	
		dcS.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AppConstants.SALESFORCE_PACKAGE);
		dcS.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AppConstants.SALESFORCE_ACTIVITY);
		dcS.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		dcS.setCapability("autoGrantPermissions", true);		
		dcS.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		dcS.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");

		driver = new AndroidDriver<MobileElement>(url, dcS);
		System.out.println("SalesForce Launched");
		
		Thread.sleep(3000);

		
		  MobileElement iAgree =
		  driver.findElementById("com.salesforce.chatter:id/mi_accept");
		  iAgree.click();
		 
		
		Thread.sleep(8000);
		
		/*
		 * List<MobileElement> elementsList = driver.findElementsByXPath("//*"); for
		 * (MobileElement element : elementsList) { System.out.println("Element:" +
		 * element.getText() + "," + element.getId() + "," + element.getTagName()); }
		 */
		
		
		MobileElement username = driver.findElementById("username");		
		//MobileElement username = driver.findElement(By.xpath("//input[@id='username']"));
		//MobileElement username = driver.findElementByXPath("/html/body/div[1]/div[1]/div/div[2]/div[3]/form/div[1]/div/input[1]");
		System.out.println("UserName text:" + username.getText());
		Thread.sleep(1000);
		username.sendKeys("oshweta@mycompany.com");
		System.out.println("Username entered");
		
		Thread.sleep(2000);
		MobileElement pwd = driver.findElementById("password");
		Thread.sleep(1000);
		pwd.sendKeys("headache1234");
		System.out.println("Password entered");
		
		Thread.sleep(1500);
		MobileElement loginButton = driver.findElementById("Login");
		Thread.sleep(1000);
		loginButton.click();
		
	}
}
