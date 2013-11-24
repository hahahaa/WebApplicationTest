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
 * This tool will return the number of lines detected in a text. 
 * 
 * @author David
 *
 */
public class CountNumberOfLinesTest {

	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/count_lines/";
	WebElement countButton;
	WebElement textbox;
	
	@Before
	public void setUp() {
		driver.get(URL_tool);
		countButton = driver.findElement(By.xpath("//input[@value='Count lines']"));
		textbox = driver.findElement(By.id("text"));
		textbox.sendKeys(Keys.CONTROL + "a");
		textbox.sendKeys(Keys.DELETE);
	}
	
	@Test
	public void testEmpty() {
		try {
			countButton.click();
			Thread.sleep(1000);
			assertEquals("1", driver.findElement(By.id("resultspan")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}		
	}
	
	@Test
	public void testNumberOfLines() {
		try {
			textbox.sendKeys("1\n2");
			
			countButton.click();
			Thread.sleep(1000);
			assertEquals("2", driver.findElement(By.id("resultspan")).getText());
			
			for(int i = 0; i < 8; i++)
				textbox.sendKeys("\n");
			
			countButton.click();
			Thread.sleep(1000);
			assertEquals("10", driver.findElement(By.id("resultspan")).getText());
			
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
