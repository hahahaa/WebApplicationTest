Feature: Roman to Decimal converter
	As a user
	I want to convert between Roman and Decimal numbers

Scenario: Convert the Roman number X to its Decimal format
	Given I have access to the Roman to Decimal converter
	And I clear all the text in the number field
	And select the method roman to decimal
	When I type the MMMMCCCXII into the number field
	And I click the covert button
	Then the result is 4312