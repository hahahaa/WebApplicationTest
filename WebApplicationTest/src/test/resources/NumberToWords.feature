Feature: Number to words converter
	As a user
	I want to convert a number to words

Scenario: Convert the number 123456 to English words
	Given I have access to the number to words converter
	And I clear all the text in the number to words field
	When I type 123456 to the number field
	And select "American English" as the language
	And I click the "Spell number" button
	Then the result is one hundred twenty-three thousand four hundred fifty-six