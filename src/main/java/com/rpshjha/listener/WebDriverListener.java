package com.rpshjha.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import lombok.extern.java.Log;

@Log
public class WebDriverListener implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		log.info("before alert accept " + driver.toString());
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		log.info("after alert accept " + driver.toString());
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		log.info("after alert dismiss " + driver.toString());
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		log.info("before alert dismiss " + driver.toString());
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("navigating .. to " + url);
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		log.info("navigated sucessfully");
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		log.info("navigating back..");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		log.info("navigated back sucessfully");

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		log.info("navigating forward");

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		log.info("sucessfully navigated forward");

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		log.info("before navigate refresh");
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		log.info("after navigate refresh");
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log.info("finding element by " + by);

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log.info("sucessfully found element");

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		log.info("clicking on " + element);

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		log.info("sucessfully clicked");

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log.info("changing value " + keysToSend);

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log.info("successfully changed value");

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		log.info("executing Script " + script);

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		log.info("sucessfully executed script");

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		log.info("switching to window " + windowName);

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		log.info("successfully switched to window");
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		log.info("On Exception" + throwable);

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		log.info("capturing screenshot " + target);

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		log.info("sucessfully captured screenshot " + target + " " + screenshot);

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		log.info("fetching text " + element);

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		log.info("sucessfully fetched text " + text);

	}

}
