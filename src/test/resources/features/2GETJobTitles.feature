@API
Feature: Validating Syntax HRMS API`s Job Title
	Background:
Given user generates token

  @GETJobTitlesAPI
  Scenario: This test will retrieve Job Title
    Given user calls GETJobTitles API
    When user retrieves response from getJobTitles
    Then status codeis 200
    Then user verifies the number of Job Titles
    Then user validates job titles
    Then user compares the results btw API and SQL




