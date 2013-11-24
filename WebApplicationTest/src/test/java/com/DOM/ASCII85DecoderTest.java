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

public class ASCII85DecoderTest
{
	WebDriver driver = new FirefoxDriver();	
	String decoderPage = "http://www.tools4noobs.com/online_tools/ascii85_decode/";
	WebElement TextElement;
	WebElement ButtonElement;
	WebElement ResultElement;

	@Before
	public void setUp() {
		driver.get(decoderPage);
		TextElement = driver.findElement(By.id("text"));
		ButtonElement = driver.findElement(By.xpath("//input[@value='ASCII85 decode']"));

	}

	@Test
	public void testEmpty()
	{
		String input = "";
		String result = "Please enter some text first.";
		try
		{
			TextElement.sendKeys(input);
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
	public void testDecoder()
	{
		String input = "<~0etOA2#~>";
		String result = "12345";

		try
		{
			TextElement.sendKeys(input);
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