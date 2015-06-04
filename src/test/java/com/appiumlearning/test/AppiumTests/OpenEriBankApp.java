package com.appiumlearning.test.AppiumTests;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class OpenEriBankApp {
	
	AndroidDriver driver;
	
	@Test
	public void openEriBankApp() throws MalformedURLException, InterruptedException{
		
		File app = new File("C:\\Bibin\\Workspace\\ApkFiles\\com.experitest.ExperiBank-1.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		/*capabilities.setCapability("deviceName", "etouch tablet");
		capabilities.setCapability("platformVersion", "4.2.2");*/
		
		capabilities.setCapability("deviceName", "Nexus_5");
		capabilities.setCapability("platformVersion", "5.0.1");
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		//capabilities.setCapability("appPackage", "com.experitest.ExperiBank");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver = (AndroidDriver)new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		//List<WebElement> textFields = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")");
		List<WebElement> textFields = driver.findElementsByAndroidUIAutomator("UiSelector().text(\"Username\")");
		System.out.println("Text fields count "+textFields.size());
		textFields.get(0).sendKeys("company");
		
		List<WebElement> fields = driver.findElementsByAndroidUIAutomator("UiSelector().index(0)");
		System.out.println(("fields - "+fields.size()));
		
		fields.get(9).sendKeys("company");
		
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Login\")").click();
		
		Thread.sleep(10000);
		
	}
	
	@AfterClass
	public void quit(){
		if (driver!=null)
			driver.quit();
	}

}
