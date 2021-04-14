package com.rpshjha.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import lombok.extern.java.Log;

@Log
public class SwipeContainer extends BasePage {
	
	
	
	public SwipeContainer(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private String getSwipeNextBtnLocator(String sectionName){
		return "//h3[contains(text(),'"+sectionName+"')]/following::div[contains(@class,'swiper-button-next')][1]";
	}


	public boolean isSwipeNextButtonDisplayed(String sectionName) {
		
		getHelper().scrollUntillElementIsVisible(By.xpath(getSwipeNextBtnLocator(sectionName)), 10);
		
		WebElement element = getDriver().findElement(By.xpath(getSwipeNextBtnLocator(sectionName)));
		try {
			if(element.isDisplayed())
				return true;
		} catch (WebDriverException e) {
			return false;
		}
		return false;
	}
	
	
	public SwipeContainer clickSwipeButton(String sectionName){
		
		try {
			WebElement element = getHelper().waitTillElementIsDisplayed(By.xpath(getSwipeNextBtnLocator(sectionName)));
			getHelper().clickThruJS(element);
		}catch (TimeoutException e) {
			log.info("element not displayed");
		}
		
		return this;
	}
	
	public List<String> getAllCarouselText(String sectionName) {
		
		String locator = "//h3[contains(text(),'"+sectionName+"')]/following::div[contains(@class,'swiper-container')][1]//div[@data-qa='product-name']";
		List<String> textList = new ArrayList<>();
			
		
		while(isSwipeNextButtonDisplayed(sectionName)) {
	
			List<WebElement> elements = getDriver().findElements(By.xpath(locator));	
			textList.addAll(getHelper().getAllText(elements));
			
			if(isSwipeNextButtonDisplayed(sectionName))
				clickSwipeButton(sectionName);
			else
				break;
		}
			
		
		return textList;
	}
	
	
}
