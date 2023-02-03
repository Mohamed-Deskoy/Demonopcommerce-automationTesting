@smoke
Feature: F04_Product Search | user search for product

Background: user enters "MohamedAhmed@gmail.com" and "123456"

  Scenario Outline: Logged user could search using product name
    When user click on search box and write "<productname>"
    And user press on the search button
    Then "<productname>" should appear successfully
    Examples:
    |productname|
    |    book   |
    |   laptop  |
    |    nike   |


  Scenario Outline: Logged user could search for product using sku
    When user click on search box and write "<serialnumber>"
    And user press on the search button
    And user click on the product in search result
    Then "<serialnumber>" should appear successfully in product page
    Examples:
      |  serialnumber  |
      |    SCI_FAITH   |
      |    APPLE_CAM   |
      |    SF_PRO_11   |