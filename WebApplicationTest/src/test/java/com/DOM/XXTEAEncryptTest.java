package com.DOM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XXTEAEncryptTest
{
	WebDriver driver = new FirefoxDriver();	
	String XXTEAEncryptPage = "http://www.tools4noobs.com/online_tools/xxtea_encrypt/";
	WebElement TextElement;
	WebElement KeyElement;
	WebElement ButtonElement;
	WebElement ResultElement;
	WebElement CheckBoxElement; 

	@Before
	public void setUp() {
		driver.get(XXTEAEncryptPage);
		TextElement = driver.findElement(By.id("text"));
		KeyElement = driver.findElement(By.id("key"));
		ButtonElement = driver.findElement(By.xpath("//input[@value='XXTEA Encrypt']"));
		CheckBoxElement = driver.findElement(By.id("encode"));
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
		String input = "12345";
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
	public void testEncryptWithCB()
	{
		String input = "12345";
		String key = "BlackSheepWall";
		String result = "SkbtBbgN59GfF4X2";
		try
		{
			TextElement.sendKeys(input);
			KeyElement.sendKeys(key);
			if(!(CheckBoxElement.isEnabled()))
				CheckBoxElement.click();
			ButtonElement.click();
			Thread.sleep(1000);
			ResultElement = driver.findElement(By.id("resultx"));
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
	public void testEncryptWithoutCB()
	{
		String input = "12345";
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
			Thread.sleep(1000);
			assertEquals(result, ResultElement.getText());
		}
		catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}		
	}
}