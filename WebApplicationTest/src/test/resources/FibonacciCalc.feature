Feature: Fibonacci Calculator
	As a user
	I want to convert a number to words

Scenario: Calculate the Fibonacci number of 10
	Given I have access to the Fibonacci Calculator
	When I type number 10 to the number field
	And I click the Calculate Fibonacci button
	Then the calculated result is 55