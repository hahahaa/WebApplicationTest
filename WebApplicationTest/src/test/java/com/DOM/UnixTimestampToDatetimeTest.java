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
import org.openqa.selenium.support.ui.Select;

/**
 * This tool converts Unix timestamp to human readable date and time format 
 * with customizable parameters such as the timezone. 
 * @author David
 *
 */
public class UnixTimestampToDatetimeTest {
	
	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/unix_timestamp_to_datetime/";
	WebElement convertButton;
	WebElement timestampTextbox;
	WebElement formatTextbox;
	Select timezoneList;
	
	@Before
	public void setUp() {
		driver.get(URL_tool);
		convertButton = driver.findElement(By.xpath("//input[@value='Convert']"));
		timestampTextbox = driver.findElement(By.id("timestamp"));
		formatTextbox = driver.findElement(By.id("format"));
		timezoneList = new Select(driver.findElement(By.id("timezone")));
		timestampTextbox.sendKeys(Keys.CONTROL + "a");
		timestampTextbox.sendKeys(Keys.DELETE);
		formatTextbox.sendKeys(Keys.CONTROL + "a");
		formatTextbox.sendKeys(Keys.DELETE);
	}
	
	@Test
	public void textEmptyTimestamp() {
		String errorMsg = "Please enter a timestamp first.";
		
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
	public void textEmptyFormat() {
		String expected = "Formatted datetime:";
		
		try {
			timestampTextbox.sendKeys("0000000000");
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void textInvalidInput() {
		String errorMsg = "Invalid UNIX timestamp given.";
		
		try {		
			timestampTextbox.sendKeys("asd");
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
	public void testTimestamp() {
		String expected;
		try {
			expected = "Formatted datetime: 01.01.1970 00:00:00";
			timestampTextbox.sendKeys("0000000000");
			formatTextbox.sendKeys("d.m.Y H:i:s");
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
			expected = "Formatted datetime: 24.11.2013 11:19:02";
			timestampTextbox.sendKeys("1385291942");
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testFormat() {
		String expected;
		String timestamp = "0000000000";
		try {
			timestampTextbox.sendKeys(timestamp);
			
			expected = "Formatted datetime: January 1, 1970, 12:00 am";
			formatTextbox.sendKeys("F j, Y, g:i a");
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
			expected = "Formatted datetime: Thu";
			formatTextbox.sendKeys(Keys.CONTROL + "a");
			formatTextbox.sendKeys(Keys.DELETE);
			formatTextbox.sendKeys("D");
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testTimezone() {
		String expected;
		String timestamp = "0000000000";
		String format = "d.m.Y H:i:s";
		try {
			timestampTextbox.sendKeys(timestamp);
			formatTextbox.sendKeys(format);
				
			expected = "Formatted datetime: 31.12.1969 16:00:00";
			timezoneList.selectByVisibleText("America/Vancouver");
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
			expected = "Formatted datetime: 01.01.1970 08:00:00";
			timezoneList.selectByVisibleText("Asia/Hong_Kong");
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
