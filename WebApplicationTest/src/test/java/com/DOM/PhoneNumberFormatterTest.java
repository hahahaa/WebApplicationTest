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

public class PhoneNumberFormatterTest {

	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/phone_number_format/";
	WebElement formatButton;
	WebElement textbox;
	
	@Before
	public void setUp() {
		driver.get(URL_tool);
		formatButton = driver.findElement(By.xpath("//input[@value='Format phone number']"));
		textbox = driver.findElement(By.id("text"));
		textbox.sendKeys(Keys.CONTROL + "a");
		textbox.sendKeys(Keys.DELETE);
	}
	
	@Test
	public void testEmpty() {
		String errorMsg = "Please enter a phone number first.";
		
		try {
			formatButton.click();
			Thread.sleep(1000);
			assertEquals(errorMsg, driver.findElement(By.id("result")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}		
	}
	
	@Test
	public void testZero() {
		String errorMsg = "Please enter a phone number first.";
		
		try {
			textbox.sendKeys("0");
			
			formatButton.click();
			Thread.sleep(1000);
			assertEquals(errorMsg, driver.findElement(By.id("result")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testPhoneNumber() {
		String expected = "Result: 1(800) 356-9377";
		try {
			textbox.sendKeys("18003569377");
			
			formatButton.click();
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
