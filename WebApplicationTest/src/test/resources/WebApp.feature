Feature: Testing Menu Bar
	As an user
	In order to surf http://www.phytonbiotech.com
	I want to click on the menu buttons

Scenario: Go to the About Us page
	Given I want to use the browser Firefox
	And surf http://www.phytonbiotech.com
	When I click the About Us button on the menu bar
	Then I go to the page http://www.phytonbiotech.com/about.html