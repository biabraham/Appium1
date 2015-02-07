package com.appiumlearning.util;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AppiumUtils {
	
	public static void decoratePage(WebDriver driver, Object page){
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15,TimeUnit.SECONDS), page);
	}

}
