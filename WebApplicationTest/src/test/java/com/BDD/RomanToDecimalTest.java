package com.BDD;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RomanToDecimalTest {

	WebDriver driver = new FirefoxDriver();
	String URL_tool = "http://www.tools4noobs.com/online_tools/roman_decimal/";
	WebElement convertButton;
	WebElement numberTextbox;
	Select methodList;
	
	@Given("^I have access to the Roman to Decimal converter$")
	public void I_have_access_to_the_Roman_to_Decimal_converter() throws Throwable {
		driver.get(URL_tool);
	}

	@Given("^I clear all the text in the number field$")
	public void I_clear_all_the_text_in_the_number_field() throws Throwable {
		numberTextbox = driver.findElement(By.id("number"));
		numberTextbox.sendKeys(Keys.CONTROL + "a");
		numberTextbox.sendKeys(Keys.DELETE);
	}

	@Given("^select the method roman to decimal$")
	public void select_the_method_roman_to_decimal() throws Throwable {
		methodList = new Select(driver.findElement(By.id("m")));
		methodList.selectByValue("1");
	}
	
	@Given("^select the method decimal to roman$")
	public void select_the_method_decimal_to_roman() throws Throwable {
		methodList = new Select(driver.findElement(By.id("m")));
		methodList.selectByValue("0");
	}

	@When("^I type the MMMMCCCXII into the number field$")
	public void I_type_the_MMMMCCCXII_into_the_number_field() throws Throwable {
		numberTextbox.sendKeys("MMMMCCCXII");
	}
	
	@When("^I type the (\\d+) into the number field$")
	public void I_type_the_into_the_number_field(int arg1) throws Throwable {
		numberTextbox.sendKeys("4312");
	}

	@When("^I click the covert button$")
	public void I_click_the_covert_button() throws Throwable {
		convertButton = driver.findElement(By.xpath("//input[@value='Convert number']"));
		convertButton.click();
	}

	@Then("^the result is (\\d+)$")
	public void the_result_is(int arg1) throws Throwable {
		String expectedResult = "4312";
		new WebDriverWait(driver, 1).until(ExpectedConditions.presenceOfElementLocated(By.className("well")));
		assertEquals(expectedResult, driver.findElement(By.className("well")).getText());
	}
	
	@Then("^the result is MMMMCCCXII$")
	public void the_result_is_MMMMCCCXII() throws Throwable {
		String expectedResult = "MMMMCCCXII";
		new WebDriverWait(driver, 1).until(ExpectedConditions.presenceOfElementLocated(By.className("well")));
		assertEquals(expectedResult, driver.findElement(By.className("well")).getText());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
