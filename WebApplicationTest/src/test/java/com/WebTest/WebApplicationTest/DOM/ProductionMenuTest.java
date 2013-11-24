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

/**
 * Test the pop-up menu of the Production button
 * @author David
 *
 */
public class ProductionMenuTest {

	WebDriver driver = new FirefoxDriver();
	List<WebElement> buttons;
	WebElement productionIcon;	

	@Before
	public void setUp() { 
		driver.get("http://www.phytonbiotech.com/");
		buttons = driver.findElement(By.id("Menudd1c142")).findElements(By.className("menu-level2-no"));
		productionIcon = driver.findElement(By.id("itemIDf0d5cc44eb")).findElement(By.partialLinkText("Production"));
	}
	
	@Test
	public void testUpstremButton() {
		String expectedURL = "http://www.phytonbiotech.com/upstream.html";
		WebElement button = buttons.get(getButtonIndex(expectedURL)).findElement(By.tagName("a"));
		
		Actions builder = new Actions(driver);
		Action click = builder.moveToElement(productionIcon).moveToElement(button).clickAndHold(button).release(button).build();
		click.perform();
					
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testDownstreamButton() {
		String expectedURL = "http://www.phytonbiotech.com/downstream.html";
		WebElement button = buttons.get(getButtonIndex(expectedURL)).findElement(By.tagName("a"));
		
		Actions builder = new Actions(driver);
		Action click = builder.moveToElement(productionIcon).moveToElement(button).clickAndHold(button).release(button).build();
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
