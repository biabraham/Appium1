package com.appiumlearning.pageobjectmodeltests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eribank.pages.HomePage;
import com.eribank.pages.LoginPage;

public class LoginEriBank {
	
	private AndroidDriver driver;
	
	@BeforeClass
	public void setUp(){
		File app = new File("C:\\Bibin\\Workspace\\ApkFiles\\com.experitest.ExperiBank-1.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "sim1");
		capabilities.setCapability("platformVersion", "5.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		try {
			//driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void loginToEriBank(){
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15,TimeUnit.SECONDS), loginPage);
		
		//LoginPage loginPage = PageFactory.initElements((driver), LoginPage.class);
		loginPage.login("company", "company");
		
	}
	
	@AfterClass
	public void tearDown(){
		if(driver!=null){
			driver.quit();
		}
	}

}
