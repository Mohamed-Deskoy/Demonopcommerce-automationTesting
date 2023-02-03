@smoke
Feature: F01_Registration | user register to e-commerce website


  Scenario: User could register with valid data
    Given user goes to register page
    When user enters valid data
    And user click on register option
    Then user should register successfully
    And registration completion message should appear