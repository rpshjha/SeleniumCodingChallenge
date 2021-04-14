package com.rpshjha.core;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageObjManager extends CoreFunctions {


	public PageObjManager(AppiumDriver<WebElement> driver) {
		super(driver);
		this.appiumdriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(TIMEOUT_IN_SECONDS)), this);
	}

	protected AppiumDriver<WebElement> appiumdriver;

	// Pages

	
}
