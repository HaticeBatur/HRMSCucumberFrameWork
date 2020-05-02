@API
Feature: Validating Syntax /getOneEmployee.php HRMS API
 
 Background:
	Given user generates token

@APITEST
@GetOneEmp
  Scenario: This test will validate the employee created by POSTCreateEmployee
    Given user calls getOneEmployee API
    When user receives response from getOneEmployee
    Then status codeiis 200
    Then employee id matches with the test POSTCreateEmployee
  


