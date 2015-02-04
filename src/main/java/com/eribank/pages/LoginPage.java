package com.eribank.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private AndroidDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver =  (AndroidDriver) driver;
	}
	
	//@FindBy
	@iOSFindBy
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Username\")")
	private WebElement userNameTextField;
	
	//@FindBy
	@AndroidFindBy(uiAutomator = "UiSelector().index(0)")
	private List<WebElement> passwordTextField;
	
	//@FindBy
	@AndroidFindBy(uiAutomator ="UiSelector().text(\"Login\")")
	private WebElement loginButton;
	
	public void enterUserName(String userName){
		//driver.findElementByAndroidUIAutomator(userNameTextField).sendKeys(userName);
		userNameTextField.sendKeys(userName);
	}
	
	public void enterPassword(String passwd){
		passwordTextField.get(9).sendKeys(passwd);
		
	}
	
	public HomePage login(String userName, String passwd){
		enterUserName(userName);
		enterPassword(passwd);
		loginButton.click();
		return new HomePage(driver);
	}
	
	

}
