package com.DOM;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Test if we can access the tool listed on the content page
 * 
 * @author David
 *
 */
public class AccessToolsTest {
	
	WebDriver driver = new FirefoxDriver();	
	String URL_tools4noobs = "http://www.tools4noobs.com/online_tools/";
	
	@Before
	public void setUp() {
		driver.get(URL_tools4noobs);
	}
	
	@Test
	public void testNumberToWordsSpellingTool() {
		String expectedURL = "http://www.tools4noobs.com/online_tools/number_spell_words/";
		WebElement tool = driver.findElement(By.linkText("Number to words spelling tool"));
		tool.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testRomanToDecomalTool() {
		String expectedURL = "http://www.tools4noobs.com/online_tools/roman_decimal/";
		WebElement tool = driver.findElement(By.linkText("Roman to decimal converter"));
		tool.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testNumberBaseConverter() {
		String expectedURL = "http://www.tools4noobs.com/online_tools/base_convert/";
		WebElement tool = driver.findElement(By.linkText("Number base convertor"));
		tool.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testCountNumberOfLines() {
		String expectedURL = "http://www.tools4noobs.com/online_tools/count_lines/";
		WebElement tool = driver.findElement(By.linkText("Online count lines tool"));
		tool.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testUnixTimestampToDatetime () {
		String expectedURL = "http://www.tools4noobs.com/online_tools/unix_timestamp_to_datetime/";
		WebElement tool = driver.findElement(By.linkText("Unix timestamp to datetime tool"));
		tool.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testConvertSecondsToTime() {
		String expectedURL = "http://www.tools4noobs.com/online_tools/seconds_to_hh_mm_ss/";
		WebElement tool = driver.findElement(By.linkText("Convert seconds to HH:MM:SS"));
		tool.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@Test
	public void testOnlineHashCalculator() {
		String expectedURL = "http://www.tools4noobs.com/online_tools/hash/";
		WebElement tool = driver.findElement(By.linkText("Online hash calculator"));
		tool.click();
		assertEquals(expectedURL, driver.getCurrentUrl());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
