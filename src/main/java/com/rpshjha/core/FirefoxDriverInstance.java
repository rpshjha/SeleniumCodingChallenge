package com.rpshjha.core;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.java.Log;

@Log
public class FirefoxDriverInstance {

	public static FirefoxDriver createDriverUsingFirefox() {
		log.info("Opening the browser : Firefox");

		// set firefox profile
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("selenium");
		FirefoxOptions firefoxoptions = new FirefoxOptions();
		firefoxoptions.setProfile(myProfile);

		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver(firefoxoptions);
	}

}
