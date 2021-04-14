package com.rpshjha.core;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.rpshjha.utilities.ConfigReader;
import com.testvagrant.commons.entities.DeviceDetails;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidCapability {

	/**
	 * 
	 * @param deviceName
	 * @param deviceUDID
	 * @param systemPort
	 * @return {@link DesiredCapabilities}
	 */
	public static DesiredCapabilities setCapability(DeviceDetails deviceDetails, String systemPort) {

		DesiredCapabilities cap = new DesiredCapabilities();
		int newCommandTimeout = Integer.parseInt(ConfigReader.getProperty("newCommandTimeout"));
		String app = "";
		String appPackage = "";

		if (systemPort == null)
			System.err.println("system port NOT received, ignoring system port capability");
		else if (!systemPort.isEmpty())
			cap.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, Integer.valueOf(systemPort));

		/*
		 * specify path for apk and specify appPackage based on env
		 */

		app = new File(ConfigReader.getProperty("apk")).getAbsolutePath();
		appPackage = ConfigReader.getProperty("appPackage");

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
		cap.setCapability(MobileCapabilityType.UDID, deviceDetails.getUdid());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceDetails.getDeviceName());
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceDetails.getOsVersion());
		cap.setCapability(MobileCapabilityType.APP, app);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ConfigReader.getProperty("appActivity"));
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, newCommandTimeout);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		cap.setCapability(MobileCapabilityType.NO_RESET, false);

		return cap;
	}

}
