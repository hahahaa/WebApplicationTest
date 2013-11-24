package com.BDD;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebAppTest {
	WebDriver driver;
	List<WebElement> buttons;
	
	String aboutUsURL = "http://www.phytonbiotech.com/about.html";
	
	@Given("^I want to use the browser Firefox$")
	public void I_want_to_use_the_browser_Firefox() throws Throwable {
	    driver = new FirefoxDriver();
	}

	@Given("^surf http://www.phytonbiotech.com$")
	public void surf_http_www_phytonbiotech_com() throws Throwable {
		driver.get("http://www.phytonbiotech.com/");
	}

	@When("^I click the About Us button on the menu bar$")
	public void I_click_the_About_Us_button_on_the_menu_bar() throws Throwable {
		buttons = driver.findElements(By.className("MainMenu"));
		WebElement aboutUsButton = buttons.get(getButtonIndex(aboutUsURL));
		aboutUsButton.click();
	}

	@Then("^I go to the page http://www.phytonbiotech.com/about.html$")
	public void I_go_to_the_page_http_www_phytonbiotech_com_about_html() throws Throwable {
		assertEquals(aboutUsURL, driver.getCurrentUrl());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	private int getButtonIndex(String href) {
		for(int i = 0; i < buttons.size(); i++) {
			if(buttons.get(i).getAttribute("href").equals(href))
				return i;
		}
		fail("Invalid href");
		return -1;
	}
}