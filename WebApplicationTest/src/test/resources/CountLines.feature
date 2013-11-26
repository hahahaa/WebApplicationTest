Feature: Online count lines tool
	As a user
	I want to count the number of lines of some texts

Scenario: Count the number of lines of a text with 5 new lines
	Given I have access to the online count lines tool
	When I type the Enter key for four times
	And I click the count button
	Then the number of lines is five
	
Scenario: Count the number of lines of a text with 1 line
	Given I have access to the online count lines tool
	When I type abc in the textbox
	And I click the count button
	Then the number of lines is one