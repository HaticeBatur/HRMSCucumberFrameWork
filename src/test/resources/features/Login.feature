@sprint1 @Login
Feature: Login

  @Smoke @Regression
  Scenario: Valid login
    When I enter valid username and valid password
    And I click on login button
    Then I successfully logged in

  #@Regression
  #Scenario Outline: Invalid Login
    #When I enter "<UserName>" and "<Password>"
    #And I click on login button
    #Then I see "<ErrorMessage>"
#
    #Examples: 
      #| UserName | Password   | ErrorMessage             |
      #| Admin    | Admin123   | Invalid credentials      |
      #| Admin    |            | Password cannot be empty |
      #|          | Syntax@123 | Username cannot be empty |
      #|          |            | Username cannot be empty |

      