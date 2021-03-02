Feature: Login

  Scenario: Successful login with Valid Credentials
    Given User Launch Chrome browser
    When User opens Url "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com"  and Password "admin"
    And Click on Login
    Then Page tile should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser

  Scenario Outline: Successful login with Valid Credentials
    Given User Launch Chrome browser
    When User opens Url "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com"  and Password "admin"
    And Click on Login
    Then Page tile should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser
    Examples:
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin1@yourstore.com | admin2   |

