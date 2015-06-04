package com.appiumlearning.androidtests;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IntuitAUHomePage {
	
AndroidDriver driver;
	
	@Test
	public void openEriBankApp() throws MalformedURLException, InterruptedException{
		
		//File app = new File("C:\\Bibin\\Workspace\\ApkFiles\\com.experitest.ExperiBank-1.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		/*capabilities.setCapability("deviceName", "etouch tablet");
		capabilities.setCapability("platformVersion", "4.2.2");*/
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("deviceName", "Nexus 4");
		capabilities.setCapability("platformVersion", "5.1.1");
		
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("app", app.getAbsolutePath());
		//capabilities.setCapability("appPackage", "com.experitest.ExperiBank");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver = (AndroidDriver)new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://intuit.com.au");
		Thread.sleep(20000);
	}

}
