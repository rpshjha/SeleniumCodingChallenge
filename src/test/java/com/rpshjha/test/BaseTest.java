package com.rpshjha.test;

import static com.rpshjha.core.WebdriverInstance.getDriver;

import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.rpshjha.core.WaitHelper;
import com.rpshjha.core.WebdriverInstance;

@Listeners({com.rpshjha.listener.TestNGListener.class})
public class BaseTest {

	protected WaitHelper wait;

	@Parameters({ "browserName" })
	@org.testng.annotations.BeforeTest
	public void setup(@Optional String browserName) {

		WebdriverInstance.initializeDriver(browserName);

		wait = new WaitHelper(getDriver());

	}

	@org.testng.annotations.AfterTest
	public void tearDown() {

		WebdriverInstance.killDriver();

	}
}
