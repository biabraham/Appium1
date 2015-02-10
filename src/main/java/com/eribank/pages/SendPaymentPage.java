package com.eribank.pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appiumlearning.util.AppiumUtils;

public class SendPaymentPage {
	
	private WebDriver driver;
	
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
	
	@FindBy(id = "com.experitest.ExperiBank:id/amount")
	private WebElement amountSeekBar;
	
	
	public SendPaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
	
	public void setAmount() throws InterruptedException{
		//TouchAction touchAction = new TouchAction((MobileDriver) driver);
		Point upperLeft = amountSeekBar.getLocation();
		Dimension dimensions = amountSeekBar.getSize();
		Point newSliderLocation = new Point((upperLeft.getX()+dimensions.getWidth()/5),upperLeft.getY()+(dimensions.getHeight()/2));
		AndroidDriver dr = (AndroidDriver) driver;
		dr.swipe(newSliderLocation.getX(),newSliderLocation.getY(), newSliderLocation.getX()-110, newSliderLocation.getY(), 2000);
		//touchAction.moveTo(amountSeekBar).perform();
		Thread.sleep(5000);
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
		//enterAmount(amount);
		try {
			setAmount();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CountrySelectionPage countrySelectionPage = clickSelectButton();
		AppiumUtils.decoratePage(driver, countrySelectionPage);
		countrySelectionPage.selectCountry(country);
		clickSendPaymentButton();
		return confirmSendMoney();
	}

}
