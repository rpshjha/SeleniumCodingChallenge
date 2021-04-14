package com.rpshjha.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import lombok.extern.java.Log;

@Log
public class CoreFunctions extends WaitHelper {

	public CoreFunctions(WebDriver driver) {
		super(driver);
	}

	public void scrollUntillElementIsInView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		waitForSeconds(1);
	}

	public void scrollUntillElementIsVisible(By element, int timeout) {

		while (timeout > 0) {
			try {
				boolean status = driver.findElement(element).isDisplayed();
				if (!status)
					return;
			} catch (WebDriverException e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,2000)");
				waitForSeconds(1);
			}
			timeout--;
		}

	}

	public void clickThruJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public List<String> getAllText(List<WebElement> elements) {
		List<String> text = new ArrayList<>();
		for (WebElement temp : elements) {
			text.add(temp.getText().trim());
		}
		return text;
	}

	/**
	 * 
	 * @param scenarioName
	 * @return outputFileLocation
	 */
	public synchronized String takeFailedScreenshot(String scenarioName) {

		scenarioName = scenarioName.replaceAll("[^a-zA-Z0-9_-]", "");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		String outputFileLocation = System.getProperty("user.dir") + "\\screenshots\\FailedScreenshots\\" + scenarioName
				+ "_" + dateFormat.format(new Date()) + ".png";
		try {
			log.info("Taking Failed Screenshot ");
			File srcFile = ((TakesScreenshot) AppiumInstance.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(outputFileLocation));
			log.info("Failed Screenshot saved | output file : " + outputFileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputFileLocation;
	}

}
