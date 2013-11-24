package com.BDD;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@Cucumber.Options(
		format = {"pretty", "html:target/cucumber"},
		features = "src/test/resources"
		)
public class CukesRunner {
}
