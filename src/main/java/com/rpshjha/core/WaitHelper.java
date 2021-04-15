package com.rpshjha.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rpshjha.utilities.ConfigReader;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.java.Log;

@Log
public class WaitHelper {

	protected WebDriver driver;
	protected static final long TIMEOUT_IN_SECONDS = Long.parseLong(ConfigReader.getProperty("timeout"));
	private WebDriverWait wait;

	public WaitHelper(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(this.driver, TIMEOUT_IN_SECONDS);
	}

	public WebElement waitTillElementIsClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public List<WebElement> waitTillAllElementsArePresent(By locator) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public WebElement waitTillElementIsDisplayed(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitTillElementIsDisplayed(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitTillActivity(int timeout, String desiredActivity) {
		long startTime = System.currentTimeMillis();
		log.info("waiting for main activity to load");
		while (System.currentTimeMillis() - startTime < timeout)
			if (((AndroidDriver<WebElement>) driver).currentActivity().equals(desiredActivity))
				break;
	}

	public WaitHelper waitForPageToLoad() {
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
		waitForSeconds(5);
		return this;
	}
	
	public void waitForSeconds(int sec) {
		try {
			Thread.sleep(1000 * sec);
		} catch (Exception ignore) {
		}
	}

}
