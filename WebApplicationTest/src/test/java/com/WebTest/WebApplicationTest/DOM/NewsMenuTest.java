package com.WebTest.WebApplicationTest.DOM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class NewsMenuTest {

	WebDriver driver = new FirefoxDriver();
	List<WebElement> buttons;
	WebElement newsIcon;	

	@Before
	public void setUp() { 
		driver.get("http://www.phytonbiotech.com/");
		buttons = driver.findElement(By.id("Menudd1c144")).findElements(By.className("menu-level2-no"));
		newsIcon = driver.findElement(By.id("itemIDfa1820a403")).findElement(By.partialLinkText("News"));
	}
	
	@Test
	public void testCurrentNewsButton() {
		String expectedURL = "http://www.phytonbiotech.com/news.html";
		WebElement button = buttons.get(getButtonIndex(expectedURL)).findElement(By.tagName("a"));
		
		Actions builder = new Actions(driver);
		Action click = builder.moveToElement(newsIcon).moveToElement(button).clickAndHold(button).release(button).build();
		click.perform();
					
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testScheduleButton() {
		String expectedURL = "http://www.phytonbiotech.com/news_schedule.html";
		WebElement button = buttons.get(getButtonIndex(expectedURL)).findElement(By.tagName("a"));
		
		Actions builder = new Actions(driver);
		Action click = builder.moveToElement(newsIcon).moveToElement(button).clickAndHold(button).release(button).build();
		click.perform();
					
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	private int getButtonIndex(String href) {
		for(int i = 0; i < buttons.size(); i++) {
			if(buttons.get(i).findElement(By.tagName("a")).getAttribute("href").equals(href))
				return i;
		}
		fail("Invalid href");
		return -1;
	}
}
