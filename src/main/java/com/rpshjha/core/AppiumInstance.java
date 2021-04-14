package com.rpshjha.core;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import com.rpshjha.utilities.AppiumServer;
import com.rpshjha.utilities.ConfigReader;
import com.testvagrant.commons.entities.DeviceDetails;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobilePlatform;
import lombok.extern.java.Log;

@Log
public class AppiumInstance {

	private static AppiumInstance instance;

	private static final ThreadLocal<AppiumDriver<WebElement>> driver = new ThreadLocal<>();

	private AppiumInstance() {
	}

	public static AppiumInstance getInstance() {
		if (instance == null) {
			synchronized (AppiumInstance.class) {
				if (instance == null)
					instance = new AppiumInstance();
			}
		}
		return instance;
	}

	
	public static AppiumDriver<WebElement> createDriver(String platformName, DeviceDetails deviceDetails, String appiumPort, String systemPort) {

		if (platformName == null) {
			platformName = MobilePlatform.ANDROID;
		}

		switch (platformName) {

		case MobilePlatform.ANDROID:
			driver.set(AndroidDriverInstance.createDriverUsingAndroid(deviceDetails, systemPort, appiumPort));
			break;

		default:
			driver.set(AndroidDriverInstance.createDriverUsingAndroid(deviceDetails, systemPort, appiumPort));
			break;
		}

		return driver.get();
	}
	/**
	 * 
	 * @return {@link AppiumDriver}
	 */
	public static AppiumDriver<WebElement> getDriver() {
		return driver.get();
	}

	/**
	 * quit appium session
	 */
	public synchronized void killDriver() {

		if (driver.get() != null) {
			log.info("quitting appium session");

			try {
				List<LogEntry> logEntries = driver.get().manage().logs().get("driver").getAll();
				File file = new File(ConfigReader.getProperty("appium_log_file_location"));
				FileUtils.write(file, "", StandardCharsets.UTF_8);
				FileUtils.writeLines(file, logEntries);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WebDriverException e) {

			}

			driver.get().quit();
			driver.remove();
			AppiumServer.stopServer();
		}
	}

}
