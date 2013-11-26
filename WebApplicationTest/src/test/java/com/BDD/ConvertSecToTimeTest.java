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

	@When("^I type the abc into the number field$")
	public void I_type_the_abc_into_the_number_field() throws Throwable {
		secondsTextbox.sendKeys("abc");
	}
	
	@When("^I click the covert seconds button$")
	public void I_click_the_covert_button() throws Throwable {
		convertButton = driver.findElement(By.xpath("//input[@value='Convert']"));
		convertButton.click();
	}

	@Then("^the result is \"([^\"]*)\"$")
	public void the_result_is(String arg1) throws Throwable {
		String expected = "Result: " + secondsToStr(123456);
		Thread.sleep(1000);
		assertEquals(expected, driver.findElement(By.id("result")).getText());
	}
	
	@Then("^the app returns an error msg, \"([^\"]*)\"$")
	public void the_app_returns_an_error_msg(String arg1) throws Throwable {
		String expected = "Invalid number of seconds given";
		Thread.sleep(1000);
		assertEquals(expected, driver.findElement(By.id("result")).getText());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	private String secondsToStr(int seconds) {
		int secOfOneDay = 86400;
		String str = "";
		int days = seconds / secOfOneDay;
		if(days != 0) {
			str = str + Integer.toString(days) + " days ";
			seconds = seconds - days*secOfOneDay;
		}		
		str = str + String.format("%02d:%02d:%02d.", (seconds/3600)%24, (seconds/60)%60, seconds%60);
		return str;
	}
}
