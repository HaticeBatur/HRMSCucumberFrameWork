@sprint2 @addEmployee
Feature: Add Employee
  Background: 
    Given I logged into HRMS
    And I navigated to Add Employee Page

@Smokeeee @Regression  @AddEmployee
  Scenario: Add a new Employee
    When I add "Annnnnn" , "Mr." and "Clark"
    And I click Save
    And I see Employee with "Annnnnn" , "Mrs." and "Clark" is succesfully added

@Regression   @AddEmployee
  Scenario Outline: Add new Employee
    When I add "<FirstName>" , "<MiddleName>" and "<LastName>"
    When I click Save
    And I see Employee with "<FirstName>" , "<MiddleName>" and "<LastName>" is succesfully added

    Examples: 
      | FirstName | MiddleName | LastName |
      | Alixy     | A          | XYZ      |
      | Velixy    | V          | XYZ      |
      | Sami      | X          | XYZ      |

  
 @Smoke @Regression
  Scenario: Add Employee without employee id
    When I add "Marmmmm" , "Hose" and "Adria"
    And I delete employee id
    And I click Save
    Then I see employee without employee id is being added

  @Smoke   @Regression
  Scenario: Add Employee negative scenario
    When I click Save
    Then I see required error message next to the first and last name

  @Smokeee  @Regressionn
  Scenario: AddEmployee and Login Credentials
    When I add "Tarxy.." , "Jr" and "Adria"
    And I click on create login details checkbox
    And I enter "Tarxy..Jr" , "123$%^54TarHos" and confirm password
    When I click Save
    And I see Employee with "Tarxy.. " , "Jr " and "Adria" is succesfully added
    
  @DBTest   @Regression
    Scenario: Add Employee and validate database
    	When I add "Halide" , "Edip" and "Adivar"
    	And I click Save
    	And I see Employee with "Halide" , "Edip" and "Adivar" is succesfully added
    	Then I collect employee from database
    	And I verify employee data is matching for employee "Halide Edip Adivar"
    	
   @DBTestSingleEmpl   @Regression
    Scenario: Add Employee and validate database
    	When I add "Ayse" , "Fatma" and "Hayriye"
    	And I click Save
    	Then I collect the single employee from database
    	And I verify employee data is matching for single employee
    	|emp_firstname| emp_middle_name| emp_lastname|
    	|Ayse|Fatma|Hayriye|
    	
    	
