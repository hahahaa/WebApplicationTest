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
 * Test the pop-up menu of the About Us button
 * @author David
 *
 */
public class AboutUsMenuTest {

	WebDriver driver = new FirefoxDriver();
	List<WebElement> buttons;
	WebElement aboutUSIcon;

	@Before
	public void setUp() { 
		driver.get("http://www.phytonbiotech.com/");
		buttons = driver.findElement(By.id("Menudd1c141")).findElements(By.className("menu-level2-no"));
		aboutUSIcon = driver.findElement(By.id("itemID2402d35ca9")).findElement(By.partialLinkText("About Us"));
	}
	
	@Test
	public void testHistoryButton() {
		String expectedURL = "http://www.phytonbiotech.com/about_history.html";
		WebElement historyButton = buttons.get(getButtonIndex(expectedURL)).findElement(By.tagName("a"));
		
		Actions builder = new Actions(driver);
		Action click = builder.moveToElement(aboutUSIcon).moveToElement(historyButton).clickAndHold(historyButton).release(historyButton).build();
		click.perform();
					
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testKeyPersonnel_PhytonBiotechGmbHButton() {
		String expectedURL = "http://www.phytonbiotech.com/about_personnel.html";
		WebElement button = buttons.get(getButtonIndex(expectedURL)).findElement(By.tagName("a"));
		
		Actions builder = new Actions(driver);
		Action click = builder.moveToElement(aboutUSIcon).moveToElement(button).clickAndHold(button).release(button).build();
		click.perform();
					
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testKeyPersonnel_PhytonBiotechLLCButton() {
		String expectedURL = "http://www.phytonbiotech.com/about_personnelPBLLC.html";
		WebElement button = buttons.get(getButtonIndex(expectedURL)).findElement(By.tagName("a"));
		
		Actions builder = new Actions(driver);
		Action click = builder.moveToElement(aboutUSIcon).moveToElement(button).clickAndHold(button).release(button).build();
		click.perform();
					
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testLocationButton() {
		String expectedURL = "http://www.phytonbiotech.com/about_locations.html";
		WebElement button = buttons.get(getButtonIndex(expectedURL)).findElement(By.tagName("a"));
		
		Actions builder = new Actions(driver);
		Action click = builder.moveToElement(aboutUSIcon).moveToElement(button).clickAndHold(button).release(button).build();
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