package com.mobile.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchTargetApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AppiumDriver<MobileElement> driver ;
		
		URL url  = new URL("http://0.0.0.0:4723/wd/hub");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		/*
		 * dc.setCapability("autoGrantPermissions", true);
		 * dc.setCapability("unlockType", "pin"); 
		 * dc.setCapability("unlockPin", "1245");
		 */
		
		
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AppConstants.TARGET_PACKAGE);
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AppConstants.TARGET_ACTIVITY);
		dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
	
		driver = new AndroidDriver<MobileElement>(url, dc);
		System.out.println("App Launched");
		
		//driver.navigate().back();
				
		driver.findElementById("com.target.ui:id/gate_login_button").click();
		System.out.println("Login clicked");
	
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Show password").click();
		System.out.println("Show Pwd clicked");
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Hide password").click();
		System.out.println("Hide Pwd clicked");
		
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	}

}
