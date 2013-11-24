package com.BDD;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConvertNumberToWordsTest {

	WebDriver driver = new FirefoxDriver();
	WebElement spellButton;
	WebElement numberTextbox;
	Select languageList;
	String URL_tool = "http://www.tools4noobs.com/online_tools/number_spell_words/";
	
	@Given("^I have access to the number to words converter$")
	public void I_have_access_to_the_number_to_words_converter() throws Throwable {
		driver.get(URL_tool);
		spellButton = driver.findElement(By.xpath("//input[@value='Spell number']"));
		numberTextbox = driver.findElement(By.id("number"));
		languageList = new Select(driver.findElement(By.id("locale")));
	}

	@Given("^I clear all the text in the number to words field$")
	public void I_clear_all_the_text_in_the_number_field() throws Throwable {
		numberTextbox.sendKeys(Keys.CONTROL + "a");
		numberTextbox.sendKeys(Keys.DELETE);
	}

	@When("^I type (\\d+) to the number field$")
	public void I_type_to_the_number_field(int arg1) throws Throwable {	
		numberTextbox.sendKeys("123456");
	}

	@When("^select \"([^\"]*)\" as the language$")
	public void select_as_the_language(String arg1) throws Throwable {
		languageList.selectByVisibleText("American English (American English)");
	}

	@When("^I click the \"([^\"]*)\" button$")
	public void I_click_the_button(String arg1) throws Throwable {
		spellButton.click();
	}

	@Then("^the result is one hundred twenty-three thousand four hundred fifty-six$")
	public void the_result_is() throws Throwable {
		String expected = "one hundred twenty-three thousand four hundred fifty-six";
		Thread.sleep(1000);
		assertEquals(expected, driver.findElement(By.className("well")).getText());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
