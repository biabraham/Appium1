package com.eribank.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.appiumlearning.util.AppiumUtils;

public class SendPaymentPage {
	
	private AndroidDriver driver;
	
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Phone\")")
	private WebElement phoneTextField;
	
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Name\")")
	private WebElement nameTextField;
	
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Amount\")")
	private WebElement amountTextField;
	
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Select\")")
	private WebElement selectButton;
	
	@AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.experitest.ExperiBank:id/countryTextField\")")
	private WebElement countryTextField;
	
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Send Payment\")")
	private WebElement sendPaymentButton;
	
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Cancel\")")
	private WebElement cancelButton;
	
	@AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"android:id/content\")")
	private WebElement sendMoneyConfirmFrame;
	
	
	public SendPaymentPage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void enterPhoneNumber(String phoneNumber){
		phoneTextField.sendKeys(phoneNumber);
	}
	
	public void enterName(String name){
		nameTextField.sendKeys(name);
	}
	
	public void enterAmount(String amount){
		amountTextField.sendKeys(amount);
	}
	
	public CountrySelectionPage clickSelectButton(){
		selectButton.click();
		return new CountrySelectionPage(driver);
	}
	
	public String getCountryValue(){
		return countryTextField.getText();
	}
	
	public void clickSendPaymentButton(){
		sendPaymentButton.click();
		
	}
	
	public void clickCancelButton(){
		cancelButton.click();
	}
	
	public HomePage confirmSendMoney(){
		sendMoneyConfirmFrame.findElement(By.id("android:id/button1")).click();
		return new HomePage(driver);
	}
	
	
	public HomePage sendMoneySuccess(String phoneNumber, String name, String amount, String country){
		enterPhoneNumber(phoneNumber);
		enterName(name);
		enterAmount(amount);
		CountrySelectionPage countrySelectionPage = clickSelectButton();
		AppiumUtils.decoratePage(driver, countrySelectionPage);
		countrySelectionPage.selectCountry(country);
		clickSendPaymentButton();
		return confirmSendMoney();
	}

}
