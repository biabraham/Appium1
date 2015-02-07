package com.eribank.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	private AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	@FindBy
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Make Payment\")")
	private WebElement makePaymentButton;
	
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Mortgage Request\")")
	private WebElement mortgageRequestButton;
	
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Expense Report\")")
	private WebElement expenseReportButton;
	
	@AndroidFindBy(uiAutomator = "UiSelector().text(\"Logout\")")
	private WebElement logoutButton;
	
	@AndroidFindBy(uiAutomator = "UiSelector().className(\"android.view.View\")")
	private WebElement balanceText;
	
	
	public SendPaymentPage clickOnMakePaymentButton(){
		makePaymentButton.click();
		return new SendPaymentPage(driver);
	}
	
	public String getBalanceInHomePage(){
		
		String balance = balanceText.getAttribute("content-desc");
		System.out.println("***************"+balance);
		balance = balance.substring(16);
		return balance;
	}

}
