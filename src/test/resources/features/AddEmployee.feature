@sprint2 @addEmployee
Feature: Add Employee

  Background: 
    Given I logged into HRMS
    And I navigated to Add Employee Page

  @smok
  Scenario: Add a new Employee
    When I add "Ann" , "Mr." and "Clark"
    And I click Save
    And I see Employee with "Anna " , "Mr. " and "Clark"

  @regression
  Scenario Outline: Add new Employee
    When I add "<FirstName>" , "<MiddleName>" and "<LastName>"
    When I click Save
    And I see Employee with "<FirstName> " , "<MiddleName> " and "<LastName>"

    Examples: 
      | FirstName | MiddleName | LastName |
      | Alixy     | A          | XYZ      |
      | Velixy    | V          | XYZ      |
      | Sami      | X          | XYZ      |

  @PersonalDetails
  Scenario: Add and Modify Employee Details
    When I enter employee details
      | FirstName | MiddleName | LastName |
      | AAAAAAA     | Jr.       | Maria    |
      
      
      
    And I click Save
    Then I am able to modify Employee Details
      | DriverLisence | ExpirationDate | SSN         | SIN      | DateOfBirth | Gender | Nationality | MaritalStatus |
      | N385456466    | 2021-12-23     | 123-45-6745 | 34567878 | 1993-07-24  | Female   | Spanish     | Other         |
  		| M345456400    | 2020-10-20     | 123-45-6756 | 45667745 | 1990-04-20  | Female   | Mexican     | Single         |
  
  #@smoke
  #Scenario: Add Employee without employee id
    #When I add "Marm" , "Hose" and "Adria"
    #And I delete employee id
    #And I click Save
    #Then I see employee without employee id is being added
#
  #@smoke
  #Scenario: Add Employee negative scenario
    #When I click Save
    #Then I see required error message next to the first and last name
#
  #@smoke
  #Scenario: AddEmployee and Login Credentials
    #When I add "Tarxy.." , "Jr" and "Adria"
    #And I click on create login details checkbox
    #And I enter "Tarxy..Jr" , "123$%^54TarHos" and confirm password
    #When I click Save
    #And I see Employee with "Tarxy.. " , "Jr " and "Adria"
