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
 * "Number to words" spells out the number in words.
 * It supports 20 languages but American English and French are tested here.
 * Since some languages do not support currency translation, this feature
 * is not tested here.
 * 
 * @author David
 *
 */
public class NumberToWordsSpellingToolTest {
	
	WebDriver driver = new FirefoxDriver();
	WebElement spellButton;
	WebElement numberTextbox;
	Select languageList;
	String URL_tool = "http://www.tools4noobs.com/online_tools/number_spell_words/";
	
	@Before
	public void setUp() {
		driver.get(URL_tool);
		spellButton = driver.findElement(By.xpath("//input[@value='Spell number']"));
		numberTextbox = driver.findElement(By.id("number"));
		languageList = new Select(driver.findElement(By.id("locale")));
	}
	
	@Test
	public void testDefaultNumber() {
		String expected_English = "one hundred twenty-three thousand four hundred fifty-six";
		String expected_French = "cent vingt-trois mille quatre cent cinquante-six";
				
		try {
			spellButton.click();
			Thread.sleep(1000);
			assertEquals(expected_English, driver.findElement(By.className("well")).getText());

			languageList.selectByVisibleText("French (Français)");
			spellButton.click();
			Thread.sleep(1000);
			assertEquals(expected_French, driver.findElement(By.className("well")).getText());
					
		} catch (NoSuchElementException e) {
			fail("Element not found\n" + e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testEmptyInput() {
		String errorMsg = "Please enter a valid number first.";

		try {
			numberTextbox.sendKeys(Keys.CONTROL + "a");
			numberTextbox.sendKeys(Keys.DELETE);
		
			spellButton.click();
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
		String errorMsg = "Please enter a valid number first.";
		
		try {
			numberTextbox.sendKeys("a");
		
			spellButton.click();
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
