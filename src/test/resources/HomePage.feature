@Test
Feature: Perform Searches on Yahoo Home Page


  Scenario:Perform a normal search on Yahoo
    Given I am on the Yahoo Home Page
    When I enter "Daniel Ingram" in the search bar
    And I click the Search Web button
    Then I should see results relating to Daniel Ingram

    Scenario: Navigate to one of the Search Results
      Given I am on the Daniel Ingram results page
      When I click the Wikipedia result
      Then I should see the Daniel Ingram Wikipedia page

