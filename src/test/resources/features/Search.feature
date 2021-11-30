Feature: Search a person and get details for that person in Imdb
  As a user,
    I want to search a celebrity in Imdb and get details for that person

  Scenario: Search a person and get the list of directed movies
    Given User is in search page of Imdb website
    When user enters "Steven Spielberg" and clicks on search button
    Then user should be navigated to "Steven Spielberg" details page
    And user search for "Steven Spielberg" directed movies
    And validate directed movies by "Steven Spielberg"

