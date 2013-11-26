package com.BDD;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FibonacciCalcTest {

	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/fibonacci/";
	WebElement calcButton;
	WebElement textbox;
	
	@Given("^I have access to the Fibonacci Calculator$")
	public void I_have_access_to_the_Fibonacci_Calculator() throws Throwable {
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
	
	@When("^I type number (\\d+) to the number field$")
	public void I_type_number_to_the_number_field(int arg1) throws Throwable {
		textbox.sendKeys("10");
	}

	@When("^I click the Calculate Fibonacci button$")
	public void I_click_the_Calculate_Fibonacci_button() throws Throwable {
		calcButton.click();
	}

	@Then("^the calculated result is (\\d+)$")
	public void the_calculated_result_is(int arg1) throws Throwable {
		String expected = Integer.toString(getFibonacci(10));
		Thread.sleep(1000);
		assertEquals(expected, driver.findElement(By.className("smallnr")).getText());
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
