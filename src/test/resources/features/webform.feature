Feature: Web Form Testing

 # This feature file is to test the functionality of filling and submitting a web form.
 # Language: Gherkin
 # Framework: Cucumber

  Scenario: Fill out and submit the form
    Given I open the Selenium web form page
    When I fill out the text input field
    And I fill out the password field
    And I fill out the text area field
    And I extract the text from the disabled text box
    And I read and display value from read-only input field
    And I select an option from the dropdown
    And I select an option from the datalist dropdown
    And I check the checkbox
    And I select the radio button
    And I select a color "#a9e4eb" from the color picker
    Then I submit the form

