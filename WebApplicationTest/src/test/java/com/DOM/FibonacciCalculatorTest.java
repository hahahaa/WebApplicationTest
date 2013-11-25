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

public class FibonacciCalculatorTest {

	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/fibonacci/";
	WebElement calcButton;
	WebElement textbox;
	
	@Before
	public void setUp() throws InterruptedException {
		driver.get(URL_tool);
		driver.findElement(By.linkText("Open Fibonacci calculator")).click();
		for(String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		calcButton = driver.findElement(By.xpath("//input[@value='Calculate Fibonacci']"));	
		textbox = driver.findElement(By.id("n"));
		textbox.sendKeys(Keys.CONTROL + "a");
		textbox.sendKeys(Keys.DELETE);
	}
	
	@Test
	public void testEmpty() {
		String errorMsg = "Please enter a number first.";
		
		try {		
			calcButton.click();
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
		String expected = Integer.toString(getFibonacci(0));
		
		try {	
			textbox.sendKeys("0");
			calcButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.className("smallnr")).getText());
			
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testDefault() {
		String expected = Integer.toString(getFibonacci(10));
		
		try {	
			textbox.sendKeys("10");
			calcButton.click();
			Thread.sleep(1000);
			assertEquals(expected, driver.findElement(By.className("smallnr")).getText());
			
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
	
	private int getFibonacci(int n) {
		if (n < 2)
			return n;
		else
			return getFibonacci(n-1) + getFibonacci(n-2);
	}
}
