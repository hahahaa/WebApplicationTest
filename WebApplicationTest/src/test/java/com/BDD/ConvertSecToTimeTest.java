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

public class ConvertSecToTimeTest {

	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/seconds_to_hh_mm_ss/";
	WebElement convertButton;
	WebElement secondsTextbox;
	
	@Given("^I have access to the seconds to text converter$")
	public void I_have_access_to_the_seconds_to_text_converter() throws Throwable {
		driver.get(URL_tool);
	}

	@Given("^I clear all the text in the seconds field$")
	public void I_clear_all_the_text_in_the_seconds_field() throws Throwable {
		secondsTextbox = driver.findElement(By.id("seconds"));
		secondsTextbox.sendKeys(Keys.CONTROL + "a");
		secondsTextbox.sendKeys(Keys.DELETE);
	}

	@When("^I type the \"([^\"]*)\" into the number field$")
	public void I_type_the_into_the_number_field(String arg1) throws Throwable {
		String seconds = "123456";
		secondsTextbox.sendKeys(seconds);
	}

	@When("^I click the covert seconds button$")
	public void I_click_the_covert_button() throws Throwable {
		convertButton = driver.findElement(By.xpath("//input[@value='Convert']"));
		convertButton.click();
	}

	@Then("^the result is \"([^\"]*)\"$")
	public void the_result_is(String arg1) throws Throwable {
		String expected = "Result: 1 days 10:17:36.";
		Thread.sleep(1000);
		assertEquals(expected, driver.findElement(By.id("result")).getText());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
