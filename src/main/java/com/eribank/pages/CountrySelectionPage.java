package com.eribank.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CountrySelectionPage {
	
	private WebDriver driver;
	
	@AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.experitest.ExperiBank:id/countryList\")")
	private WebElement countryList;

	public CountrySelectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void selectCountry(String country){
		String countryName;
		
		List<WebElement> list = countryList.findElements(By.id("android:id/text1"));
		
		for(int i=0;i<list.size()-1;i++){
			countryName = list.get(i).getText();
			if(country.equalsIgnoreCase(countryName)){
				list.get(i).click();
				break;
			}
		}
	}
	

}
