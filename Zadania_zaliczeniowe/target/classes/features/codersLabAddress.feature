Feature: TestLab account management

  Scenario Outline: user can add new addresses

    When user click 'sign in' and log into account using nowyemail@breiz.com and nowehaslo357
    Then user create new address and fills out the form with <alias>, <address>, <city>, <zipPostalCode>, <phone>
    And user click on save button and check if every date is correct
    Then user delete new address

    Examples:
      |alias | address | city | zipPostalCode  | phone |
      | MyAddress | Mieszka1 | Krakow | 22-110 | 321321321 |