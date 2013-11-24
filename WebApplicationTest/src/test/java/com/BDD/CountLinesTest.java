package com.BDD;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CountLinesTest {
	
	WebDriver driver;
	String URL_tool = "http://www.tools4noobs.com/online_tools/count_lines/";
	
	@Given("^I want to use FireFox as my browser$")
	public void I_want_to_use_FireFox_as_my_browser() throws Throwable {
		driver = new FirefoxDriver();
	}

	@Given("^I have access to the online count lines tool$")
	public void I_have_access_to_the_online_count_lines_tool() throws Throwable {
		driver.get(URL_tool);
	}

	@When("^I type the Enter key for four times$")
	public void I_type_the_Enter_key_for_four_times() throws Throwable {
		WebElement textbox = driver.findElement(By.id("text"));
		textbox.sendKeys("\n\n\n\n");
	}

	@When("^I click the count button$")
	public void I_click_the_count_button() throws Throwable {
		driver.findElement(By.xpath("//input[@value='Count lines']")).click();
	}

	@Then("^the number of lines is five$")
	public void the_number_of_lines_is_five() throws Throwable {
		assertEquals("5", driver.findElement(By.id("resultspan")).getText() );
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}