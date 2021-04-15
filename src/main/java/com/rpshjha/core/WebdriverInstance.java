package com.rpshjha.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.rpshjha.listener.WebDriverListener;

import lombok.extern.java.Log;

@Log
public class WebdriverInstance {

	private static ThreadLocal<EventFiringWebDriver> webDriverThread = new ThreadLocal<>();

	private WebdriverInstance() {
	}

	/**
	 * Gets the browser driver.
	 * 
	 * @param browserName the browser
	 * @return the browser driver
	 */
	private static WebDriver getBrowserDriver(String browserName) {

		WebDriver driver = null;

		if(browserName==null)
			browserName = BrowserType.CHROME;
		
		switch (browserName) {

		case BrowserType.FIREFOX:
			driver = FirefoxDriverInstance.createDriverUsingFirefox();
			break;
		case BrowserType.CHROME:
			driver = ChromeDriverInstance.createDriverUsingChrome();
			break;
		case BrowserType.EDGE:
			driver = EdgeDriverInstance.createDriverUsingEdge();
			break;

		default:
			break;
		}

		return driver;
	}

	/**
	 * Initialize driver.
	 * 
	 * @param browser
	 */
	public static void initializeDriver(final String browser) {

		final WebDriver webDriver = getBrowserDriver(browser);
		registerDriver(webDriver);
	}

	/**
	 * Register driver.
	 * 
	 * @param webDriver the web driver
	 */
	private static void registerDriver(final WebDriver webDriver) {

		log.info("Registering Driver ");
		final WebDriverListener eventListener = new WebDriverListener();
		final EventFiringWebDriver efd = new EventFiringWebDriver(webDriver);
		efd.register(eventListener);
		webDriverThread.set(efd);
	}

	/**
	 * Gets the driver.
	 * @return 
	 * 
	 * @return the driver
	 */
	public static EventFiringWebDriver getDriver() {
		return webDriverThread.get();
	}
	
	public static WebDriver getWebDriver() {
		return getDriver().getWrappedDriver();
	}

	/**
	 * kills the driver
	 */
	public static void killDriver() {
		if (getDriver() != null) {
			log.info("Closing the browser");
			getDriver().quit();
		}
		webDriverThread.remove();
	}

}
