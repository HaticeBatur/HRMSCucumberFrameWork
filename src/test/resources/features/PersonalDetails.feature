
@sprint4 @PersonalDetails
Feature: Personal Details
    Background: 
    Given I logged into HRMS
    And I navigated to Add Employee Page

 @Smoke @Regression
  Scenario: Add and Modify Employee Details
    When I enter employee details
      | FirstName | MiddleName | LastName |
      | AAAAAAA     | Jr.       | Maria    |
   
    And I click Save
    Then I am able to modify Employee Details
      | DriverLisence | ExpirationDate | SSN         | SIN      | DateOfBirth | Gender | Nationality | MaritalStatus |
      | N385456466    | 2021-12-23     | 123-45-6745 | 34567878 | 1993-07-24  | Female   | Spanish     | Other         |
  		| M345456400    | 2020-10-20     | 123-45-6756 | 45667745 | 1990-04-20  | Female   | Mexican     | Single         |
