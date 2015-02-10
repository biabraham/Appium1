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

import com.appiumlearning.util.AppiumUtils;
import com.eribank.pages.HomePage;
import com.eribank.pages.LoginPage;
import com.eribank.pages.SendPaymentPage;

public class TestSendMoney {
	
	private AndroidDriver driver;
	
	@BeforeClass
	public void setUp(){
		File app = new File("C:\\Bibin\\Workspace\\ApkFiles\\eriBank\\com.experitest.ExperiBank-1.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browser", "Android");
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("platformVersion", "4.4.2");
		//capabilities.setCapability("platformVersion", "5.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		try {
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void loginToEriBank(){
		
		System.out.println("Initiating the transfer");
		
		LoginPage loginPage = new LoginPage(driver);
		
		HomePage homePage = loginPage.login("company", "company");
		
		SendPaymentPage sendPaymentPage = homePage.clickOnMakePaymentButton();
		
		sendPaymentPage.sendMoneySuccess("4086638892", "Bibin", "0.01", "Norway");
		
		System.out.println("completed the transfer");
		
		
	}
	
	@AfterClass
	public void tearDown(){
		if(driver!=null){
			driver.quit();
		}
	}

}
