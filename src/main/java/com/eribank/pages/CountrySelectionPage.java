package com.eribank.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CountrySelectionPage {
	
	private AndroidDriver driver;
	
	@AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.experitest.ExperiBank:id/countryList\")")
	private WebElement countryList;

	public CountrySelectionPage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void selectCountry(String country){
		String countryName;
		
		List<WebElement> list = countryList.findElements(By.id("com.experitest.ExperiBank:id/rowTextView"));
		
		for(int i=0;i<list.size();i++){
			countryName = list.get(i).getText();
			if(country.equalsIgnoreCase(countryName)){
				list.get(i).click();
				break;
			}
		}
	}
	

}
