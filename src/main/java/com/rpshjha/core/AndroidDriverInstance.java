package com.rpshjha.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.rpshjha.utilities.AppiumServer;
import com.rpshjha.utilities.ConfigReader;
import com.testvagrant.commons.entities.DeviceDetails;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import lombok.extern.java.Log;

@Log
public class AndroidDriverInstance {
	/**
	 * creates android driver
	 * 
	 * @param deviceDetails
	 * @param systemPort
	 * @param appiumPort
	 * @param cap
	 * @return {@link AndroidDriver}
	 */
	public static synchronized AndroidDriver<WebElement> createDriverUsingAndroid(DeviceDetails deviceDetails, String systemPort,
			String appiumPort) {

		DesiredCapabilities cap = AndroidCapability.setCapability(deviceDetails, systemPort);
		AndroidDriver<WebElement> driver = null;
		try {

			URL appiumServiceUrl;

			if (appiumPort == null || appiumPort.isEmpty()) {
				log.severe("appium port NOT received, using default port provided in config property");
				appiumServiceUrl = AppiumServer.startServer(Integer.valueOf(ConfigReader.getProperty("appiumPort")))
						.getUrl();
			} else {
				appiumServiceUrl = AppiumServer.startServer(Integer.valueOf(appiumPort)).getUrl();
			}

			log.info("initializing android driver");
			driver = new AndroidDriver<WebElement>(appiumServiceUrl, cap);
			log.info("android driver initialized");

		} catch (AppiumServerHasNotBeenStartedLocallyException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		} catch (SessionNotCreatedException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		} catch (WebDriverException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
