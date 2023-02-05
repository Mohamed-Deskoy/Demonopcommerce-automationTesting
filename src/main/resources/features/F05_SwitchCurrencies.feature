@smoke
Feature: F05_Switching Currencies | user switch between US and Euro currencies

  Scenario: Logged User could choose US currency
    When user click on the currency selector and choose the US currency
    Then US dollar symbol is chosen and displayed on all products

  Scenario: Logged User could choose Euro currency
    When user click on the currency selector and choose the Euro currency
    Then Euro symbol is chosen and displayed on all products