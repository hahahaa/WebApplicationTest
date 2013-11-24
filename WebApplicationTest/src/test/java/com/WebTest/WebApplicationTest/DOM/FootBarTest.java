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

/**
 * Test the buttons on the foot bar on http://www.phytonbiotech.com/
 * @author David
 *
 */
public class FootBarTest {

	WebDriver driver = new FirefoxDriver();
	List<WebElement> buttons;

	@Before
	public void setUp() {
		driver.get("http://www.phytonbiotech.com/");
		buttons = driver.findElements(By.className("footernav"));
	}
	
	@Test
	public void testHomeButton() {	
		String expectedURL = "http://www.phytonbiotech.com/index-2.html";
		WebElement homeButton = buttons.get(getButtonIndex(expectedURL));
		homeButton.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testAboutUsButtonButton() {
		String expectedURL = "http://www.phytonbiotech.com/about.html";
		WebElement aboutUsButton = buttons.get(getButtonIndex(expectedURL));
		aboutUsButton.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testBrochuresButtonButton() {
		String expectedURL = "http://www.phytonbiotech.com/brochures.html";
		WebElement brochuresButton = buttons.get(getButtonIndex(expectedURL));
		brochuresButton.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testNewsButton() {
		String expectedURL = "http://www.phytonbiotech.com/news.html";
		WebElement brochuresButton = buttons.get(getButtonIndex(expectedURL));
		brochuresButton.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}

	@Test
	public void testCareersButton() {
		String expectedURL = "http://www.phytonbiotech.com/careers.html";
		WebElement brochuresButton = buttons.get(getButtonIndex(expectedURL));
		brochuresButton.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test 
	public void testIndustryLinksButton() {
		String expectedURL = "http://www.phytonbiotech.com/indassoc.html";
		WebElement brochuresButton = buttons.get(getButtonIndex(expectedURL));
		brochuresButton.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test 
	public void testContactButton() {
		String expectedURL = "http://www.phytonbiotech.com/contact.html";
		WebElement brochuresButton = buttons.get(getButtonIndex(expectedURL));
		brochuresButton.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testTermOfUseButton() {
		String expectedURL = "http://www.phytonbiotech.com/terms.html";
		WebElement termOfUseButton = buttons.get(getButtonIndex(expectedURL));
		termOfUseButton.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testPrivacyPolicyButton() {
		String expectedURL = "http://www.phytonbiotech.com/privacy.html";
		WebElement privacyPolicyButton = buttons.get(getButtonIndex(expectedURL));
		privacyPolicyButton.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	private int getButtonIndex(String href) {
		for(int i = 0; i < buttons.size(); i++) {
			if(buttons.get(i).getAttribute("href").equals(href))
				return i;
		}
		fail("Invalid href");
		return -1;
	}
}