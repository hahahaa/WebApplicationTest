Feature: Convert seconds to HH:MM:SS
	As a user
	I want to a number of seconds in human readable time using hours/minutes/seconds.

Scenario: Count 1432 seconds to its readable format
	Given I have access to the seconds to text converter
	And I clear all the text in the seconds field
	When I type the "123456" into the number field
	And I click the covert seconds button
	Then the result is "Result: 1 days 10:17:36."