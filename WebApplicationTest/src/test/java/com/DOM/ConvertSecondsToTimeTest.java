package com.DOM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This tool converts a number of seconds in human 
 * readable time using hours/minutes/seconds. 
 * @author David
 *
 */
public class ConvertSecondsToTimeTest {
	
	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/seconds_to_hh_mm_ss/";
	WebElement convertButton;
	WebElement secondsTextbox;
	
	@Before
	public void setUp() {
		driver.get(URL_tool);
		convertButton = driver.findElement(By.xpath("//input[@value='Convert']"));
		secondsTextbox = driver.findElement(By.id("seconds"));
		secondsTextbox.sendKeys(Keys.CONTROL + "a");
		secondsTextbox.sendKeys(Keys.DELETE);
	}

	@Test
	public void testEmpty() {
		String errorMsg = "Invalid number of seconds given";
		
		try {		
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(errorMsg, driver.findElement(By.id("result")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testInvalidInput() {
		String errorMsg = "Invalid number of seconds given";
		
		try {
			secondsTextbox.sendKeys("a");
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(errorMsg, driver.findElement(By.id("result")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testConversion() {
		String seconds;
		String expected;
		
		try {
			seconds = "0";
			expected = "Result: 00:00:00.";
			secondsTextbox.sendKeys(seconds);
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
			seconds = "123456";
			expected = "Result: 1 days 10:17:36.";
			secondsTextbox.sendKeys(seconds);
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}	
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
