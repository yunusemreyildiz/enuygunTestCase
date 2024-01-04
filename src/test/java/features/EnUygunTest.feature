Feature: EnUygun Test

  Scenario: Go to Enuygun.com and check the time filter for flight section
      Given Navigate to website
      When Check home page is loaded
      And Click flight from the top menu
      And Choose the two way option from radio button
      And Select city
      And Select destination city
      And Click search button
      When From the results page, select take-off time from slider
      And From the results page, select landing time from the second slider
      Then After selections, check the time intervals of the results

  Scenario: Go to Enuygun.com and check the price sort for flight section
    Given Navigate to the website
    When Check the homepage loading
    And Click flight from top menu
    And Choose two way with radio button
    And Select take off city
    And Select landing city
    And Click the search button
    When From results page, select take-off time from slider
    And From results page, select landing time from the second slider
    And Select the Turk Hava Yollari from filter
    Then Check the price sorting

