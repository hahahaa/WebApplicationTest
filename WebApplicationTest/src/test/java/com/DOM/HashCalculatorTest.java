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
 * This tool hashes the input text to its hash value with given algorithm.
 * @author David
 *
 */
public class HashCalculatorTest {

	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/hash/";
	WebElement hashButton;
	WebElement textbox;
	Select algorithmList;
	

	@Before
	public void setUp() {
		driver.get("http://www.tools4noobs.com/online_tools/hash/");
		hashButton = driver.findElement(By.xpath("//input[@value='Hash this!']"));
		textbox = driver.findElement(By.id("text"));
		algorithmList = new Select(driver.findElement(By.id("algo")));
		textbox.sendKeys(Keys.CONTROL + "a");
		textbox.sendKeys(Keys.DELETE);
	}
	
	@Test
	public void testHash() {	
		String expected;

		try {
			expected = "Result: 8350e5a3e24c153df2275c9f80692773";
			hashButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
			expected = "Result: 0ae06562456c6e0e9736f4feda3a477b";
			textbox.sendKeys("helloworld");
			hashButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());	
		}
	}
	
	@Test
	public void testAlgorithmList() {
		String expected;

		try {
			expected = "Result: 8350e5a3e24c153df2275c9f80692773";
			algorithmList.selectByVisibleText("md2");
			hashButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.id("result")).getText());
			
			expected = "Result: be417bb4dd5cfb76c7126f4f8eeb1553a449039307b1a3cd451dbfdc0fbbe330";
			algorithmList.selectByVisibleText("haval256,5");
			hashButton.click();
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