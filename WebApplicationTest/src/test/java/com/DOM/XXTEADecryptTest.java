package com.DOM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XXTEADecryptTest
{
	WebDriver driver = new FirefoxDriver();	
	String XXTEADecryptPage = "http://www.tools4noobs.com/online_tools/xxtea_decrypt/";
	WebElement TextElement;
	WebElement KeyElement;
	WebElement ButtonElement;
	WebElement ResultElement;
	WebElement CheckBoxElement; 

	@Before
	public void setUp() {
		driver.get(XXTEADecryptPage);
		TextElement = driver.findElement(By.id("text"));
		KeyElement = driver.findElement(By.id("key"));
		ButtonElement = driver.findElement(By.xpath("//input[@value='XXTEA Decrypt']"));
		CheckBoxElement = driver.findElement(By.id("decode"));
	}

	@Test
	public void testTextEmpty()
	{
		String input = "";
		String key = "BlackSheepWall";
		String result = "Please enter some text first.";
		try
		{
			TextElement.sendKeys(input);
			KeyElement.sendKeys(key);
			CheckBoxElement.click();			
			ButtonElement.click();
			Thread.sleep(1000);
			ResultElement = driver.findElement(By.id("result"));
			Thread.sleep(1000);
			assertEquals(result, ResultElement.getText());
		}
		catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testKeyEmpty()
	{
		String input = "SkbtBbgN59GfF4X2";
		String key = "";
		String result = "The secret key cannot be empty.";
		try
		{
			TextElement.sendKeys(input);
			KeyElement.sendKeys(key);
			CheckBoxElement.click();			
			ButtonElement.click();
			Thread.sleep(1000);
			ResultElement = driver.findElement(By.id("result"));
			Thread.sleep(1000);
			assertEquals(result, ResultElement.getText());
		}
		catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testDecryptWithCB()
	{
		String input = "SkbtBbgN59GfF4X2";
		String key = "BlackSheepWall";
		String result = "12345";
		try
		{
			TextElement.sendKeys(input);
			KeyElement.sendKeys(key);
			if(!(CheckBoxElement.isEnabled()))
				CheckBoxElement.click();
			ButtonElement.click();
			Thread.sleep(1000);
			ResultElement = driver.findElement(By.id("resultx"));
			Thread.sleep(3000);
			assertEquals(result, ResultElement.getText());
		}
		catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}		
	}

	@Test
	public void testDecryptWithoutCB()
	{
		String input = "SkbtBbgN59GfF4X2";
		String key = "BlackSheepWall";
		String result = "";
		try
		{
			TextElement.sendKeys(input);
			KeyElement.sendKeys(key);
			if(CheckBoxElement.isEnabled())
				CheckBoxElement.click();
			ButtonElement.click();
			Thread.sleep(1000);
			ResultElement = driver.findElement(By.id("resultx"));
			Thread.sleep(2000);
			assertEquals(result, ResultElement.getText());
		}
		catch (NoSuchElementException e) {
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