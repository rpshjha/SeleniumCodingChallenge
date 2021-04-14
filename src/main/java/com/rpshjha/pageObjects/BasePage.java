package com.rpshjha.pageObjects;

import org.openqa.selenium.WebDriver;

import com.rpshjha.core.CoreFunctions;
import com.rpshjha.core.WaitHelper;

import lombok.Getter;

@Getter
public class BasePage {

	private WebDriver driver;
	private CoreFunctions helper;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.helper = new CoreFunctions(driver);
	}

}
