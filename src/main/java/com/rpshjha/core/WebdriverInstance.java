package com.rpshjha.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import lombok.extern.java.Log;

@Log
public class WebdriverInstance {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private WebdriverInstance() {
	}

	/**
	 * 
	 * @param browserName
	 * @return {@link WebDriver}
	 */
	public static WebDriver createDriver(String browserName) {

		if (browserName == null) {
			browserName = BrowserType.CHROME;
		}

		switch (browserName) {

		case BrowserType.FIREFOX:
			driver.set(FirefoxDriverInstance.createDriverUsingFirefox());
			break;
		case BrowserType.CHROME:
			driver.set(ChromeDriverInstance.createDriverUsingChrome());
			break;
		case BrowserType.EDGE:
			driver.set(EdgeDriverInstance.createDriverUsingEdge());
			break;

		default:
			driver.set(ChromeDriverInstance.createDriverUsingChrome());
			break;
		}

		return driver.get();
	}

	public static WebDriver getDriver() {
		log.info("getting driver" + driver.get());
		return driver.get();
	}

	public static void killDriver() {
		if (driver.get() != null) {
			log.info("Closing the browser");
			driver.get().quit();
		}
		driver.remove();
	}

}
