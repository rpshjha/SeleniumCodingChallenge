package com.rpshjha.core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.java.Log;

@Log
public class ChromeDriverInstance {

	public static ChromeDriver createDriverUsingChrome() {
		log.info("Opening the browser : Chrome");

		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--disable-notifications");
		chromeoptions.addArguments("--start-maximized");

		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(chromeoptions);
	}

}
