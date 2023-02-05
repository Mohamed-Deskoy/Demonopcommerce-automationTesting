@smoke
Feature: F03_Password Reset | user reset password


  Scenario: User could reset his/her password successfully
    Given user goes to login page
    And user click on forgot password
    When user enters his registered email
    And press on Recover button
    Then user should reset his password successfully


