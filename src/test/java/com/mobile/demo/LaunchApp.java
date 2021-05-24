package com.mobile.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchApp {

	public static void main(String[] args) throws MalformedURLException {

		AppiumDriver<MobileElement> driver ;
		
		URL url  = new URL("http://0.0.0.0:4723/wd/hub");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.target.ui");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.target.login.GateActivity");
		dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Galaxy");
	
		driver = new AndroidDriver<MobileElement>(url, dc);
		System.out.println("App Launched");
		
	}

}
