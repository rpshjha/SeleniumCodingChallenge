package com.rpshjha.test;

import static com.rpshjha.core.WebdriverInstance.getDriver;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rpshjha.pageObjects.SwipeContainer;
import com.rpshjha.utilities.ConfigReader;

public class Test_day2 extends BaseTest {

	String url = ConfigReader.getProperty("url");

	@BeforeMethod
	public void navigateToURL() {

		getDriver().get(url);
		getDriver().manage().window().maximize();
		
		wait.waitForPageToLoad();
	}

	@AfterMethod
	public void closeBrowser() {
		
	}
	
	@Test(dataProvider = "dataprovider_for_swipe_container_section")
	public void clickOnSwipeButtonAndFetchCarouselText(String sectionName) {

		SwipeContainer swipe = new SwipeContainer(getDriver());

		List<String> string = swipe.getAllCarouselText(sectionName);

		System.out.println(sectionName + "\ntotal elements present " + string.size());
		string.stream().filter(i -> !i.isEmpty())
				.forEach(System.out::println);

		Assert.assertTrue(!string.isEmpty(), "verifying list should not be empty");
	}

	@DataProvider(name = "dataprovider_for_swipe_container_section")
	public Object[] getTestData() {

		return new Object[] { 
				"Recommended For You", 
				"Save big on mobiles & tablets", 
				"Top picks in electronics",
				"Buy 1 get 1 free on watches & eyewear" 
				};
	}

}
