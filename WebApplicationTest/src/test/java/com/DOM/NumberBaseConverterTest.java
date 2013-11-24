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
 * This tool can convert a number between two custom bases (between 2 and 30).
 * 
 * @author David
 *
 */
public class NumberBaseConverterTest {

	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/base_convert/";
	WebElement convertButton;
	WebElement numberTextbox;
	Select fromBaseList;
	Select toBaseList;
	
	@Before
	public void setUp() {
		driver.get(URL_tool);
		convertButton = driver.findElement(By.xpath("//input[@value='Convert number']"));
		numberTextbox = driver.findElement(By.id("number"));
		fromBaseList = new Select(driver.findElement(By.id("from_base")));
		toBaseList = new Select(driver.findElement(By.id("to_base")));
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
	
	/**
	 * test conversion of the number 1751 between its binary, octal, 
	 * decimal and hexadecimal form
	 */
	@Test
	public void testConversionBetweenBinOctDecHex() {
		int value = 1751;
		String[] toList = {"2", "8", "10", "16"};
		try {			
			for(int i = 0; i < toList.length; i++) {
				fromBaseList.selectByValue(toList[i]);
				numberTextbox.sendKeys(Keys.CONTROL + "a");
				numberTextbox.sendKeys(Keys.DELETE);
				numberTextbox.sendKeys(Integer.toString(value, Integer.valueOf(toList[i])));
				
				for(int j = 0; j < toList.length; j++) {
					toBaseList.selectByValue(toList[j]);
					convertButton.click();
					Thread.sleep(1000);
					String expected = "Number " + Integer.toString(value, Integer.valueOf(toList[i])) 
							+ " (base " + toList[i] + ") is in base " + toList[j] + ": " 
							+ Integer.toString(value, Integer.valueOf(toList[j])) + ".";
					assertEquals(expected, driver.findElement(By.id("result")).getText());
				}
			}
			
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
