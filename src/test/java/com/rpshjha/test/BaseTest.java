package com.rpshjha.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.rpshjha.core.WaitHelper;
import com.rpshjha.core.WebdriverInstance;
import static com.rpshjha.core.WebdriverInstance.getDriver;

public class BaseTest {

	WaitHelper wait;

	@Parameters({ "browserName" })
	@org.testng.annotations.BeforeTest
	public void setup(@Optional String browserName) {

		WebdriverInstance.createDriver(browserName);

		wait = new WaitHelper(getDriver());

	}

	@AfterTest
	public void tearDown() {

		WebdriverInstance.killDriver();

	}
}
