package com.eribank.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver =   driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy()
	@iOSFindBy
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Username\")")
	private WebElement userNameTextField;
	
	@FindBy(id = "com.experitest.ExperiBank:id/passwordTextField")
	//@AndroidFindBy(uiAutomator = "UiSelector().index(0)")
	private WebElement passwordTextField;
	
	@FindBy
	@AndroidFindBy(uiAutomator ="UiSelector().text(\"Login\")")
	private WebElement loginButton;
	
	public void enterUserName(String userName){
		//driver.findElementByAndroidUIAutomator(userNameTextField).sendKeys(userName);
		userNameTextField.sendKeys(userName);
	}
	
	public void enterPassword(String passwd){
		passwordTextField.sendKeys(passwd);
		
	}
	
	public HomePage login(String userName, String passwd){
		enterUserName(userName);
		enterPassword(passwd);
		loginButton.click();
		return new HomePage(driver);
	}
	
	

}
