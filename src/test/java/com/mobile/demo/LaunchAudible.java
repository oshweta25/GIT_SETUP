package com.mobile.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchAudible {

	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AppConstants.AUDIBLE_PACKAGE);
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AppConstants.AUDIBLE_ACTIVITY);
		dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");

		driver = new AndroidDriver<MobileElement>(url, dc);
		System.out.println("Audible opened");

	}
	
	@Test
	public void screenRotation() {
		if(  driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)  ) {
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
		
		MobileElement welcome = null;
		welcome.click();
	}



}
