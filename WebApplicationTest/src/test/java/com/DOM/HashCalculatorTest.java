package com.DOM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Test the buttons on the left menu bar on http://www.phytonbiotech.com/
 * @author David
 *
 */
public class HashCalculatorTest {

	WebDriver driver = new FirefoxDriver();
	List<WebElement> textBoxes;

	@Before
	public void setUp() {
		driver.get("http://www.tools4noobs.com/online_tools/hash/");
	}
	
	@Test
	public void testHomeButton() {	
		WebElement button = driver.findElement(By.xpath("//input[@value='Hash this!']"));
		
		button.click();
		
		WebElement result = driver.findElement(By.id("result"));
		System.out.println("result: " + result.getText());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement well = driver.findElement(By.className("well"));
		System.out.println(well.getText());
		
//		textBox.sendKeys("123");
//		System.out.println(textBox.getText());

	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}