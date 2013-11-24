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
 * "Roman to decimal converter" converts between decimal and Roman numbers. 
 * The maximum value allowed for conversion is 50.000. 
 * 
 * @author David
 *
 */
public class RomanToDecimalToolTest {

	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/roman_decimal/";
	WebElement convertButton;
	WebElement numberTextbox;
	Select methodList;
	
	@Before
	public void setUp() {
		driver.get(URL_tool);
		convertButton = driver.findElement(By.xpath("//input[@value='Convert number']"));
		numberTextbox = driver.findElement(By.id("number"));
		methodList = new Select(driver.findElement(By.id("m")));
	}
	
	@Test
	public void testDecToRoman() {
		String expectedResult = "MMMMCCCXII";
				
		try {
			numberTextbox.sendKeys(Keys.CONTROL + "a");
			numberTextbox.sendKeys(Keys.DELETE);
			numberTextbox.sendKeys("4312");
			methodList.selectByValue("0");
			
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(expectedResult, driver.findElement(By.className("well")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testRomanToDec() {
		String expectedResult = "4312";
				
		try {
			numberTextbox.sendKeys(Keys.CONTROL + "a");
			numberTextbox.sendKeys(Keys.DELETE);
			numberTextbox.sendKeys("MMMMCCCXII");
			methodList.selectByValue("1");
			
			convertButton.click();
			Thread.sleep(1000);
			assertEquals(expectedResult, driver.findElement(By.className("well")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testEmptyInput() {
		String errorMsg = "Please enter a value first.";

		try {
			numberTextbox.sendKeys(Keys.CONTROL + "a");
			numberTextbox.sendKeys(Keys.DELETE);
		
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
		String errorMsg = "Invalid number provided.";

		try {
			numberTextbox.sendKeys("a");

			convertButton.click();
			Thread.sleep(1000);
			assertEquals(errorMsg, driver.findElement(By.id("result")).getText());
			
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
