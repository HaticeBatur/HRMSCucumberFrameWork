$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AddEmployee.feature");
formatter.feature({
  "name": "Add Employee",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@sprint2"
    },
    {
      "name": "@addEmployee"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Add new Employee",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I add \"\u003cFirstName\u003e\" , \"\u003cMiddleName\u003e\" and \"\u003cLastName\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "I click Save",
  "keyword": "When "
});
formatter.step({
  "name": "I see Employee with \"\u003cFirstName\u003e\" , \"\u003cMiddleName\u003e\" and \"\u003cLastName\u003e\" is succesfully added",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "FirstName",
        "MiddleName",
        "LastName"
      ]
    },
    {
      "cells": [
        "Alixy",
        "A",
        "XYZ"
      ]
    },
    {
      "cells": [
        "Velixy",
        "V",
        "XYZ"
      ]
    },
    {
      "cells": [
        "Sami",
        "X",
        "XYZ"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I logged into HRMS",
  "keyword": "Given "
});
formatter.match({
  "location": "AddEmpSteps.i_logged_into_HRMS()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigated to Add Employee Page",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmpSteps.i_navigated_to_Add_Employee_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add new Employee",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sprint2"
    },
    {
      "name": "@addEmployee"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I add \"Alixy\" , \"A\" and \"XYZ\"",
  "keyword": "When "
});
formatter.match({
  "location": "AddEmpSteps.i_add_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click Save",
  "keyword": "When "
});
formatter.match({
  "location": "AddEmpSteps.i_click_Save()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see Employee with \"Alixy\" , \"A\" and \"XYZ\" is succesfully added",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmpSteps.i_see_Employee_with_and_is_displayed(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I logged into HRMS",
  "keyword": "Given "
});
formatter.match({
  "location": "AddEmpSteps.i_logged_into_HRMS()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigated to Add Employee Page",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmpSteps.i_navigated_to_Add_Employee_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add new Employee",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sprint2"
    },
    {
      "name": "@addEmployee"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I add \"Velixy\" , \"V\" and \"XYZ\"",
  "keyword": "When "
});
formatter.match({
  "location": "AddEmpSteps.i_add_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click Save",
  "keyword": "When "
});
formatter.match({
  "location": "AddEmpSteps.i_click_Save()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see Employee with \"Velixy\" , \"V\" and \"XYZ\" is succesfully added",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmpSteps.i_see_Employee_with_and_is_displayed(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I logged into HRMS",
  "keyword": "Given "
});
formatter.match({
  "location": "AddEmpSteps.i_logged_into_HRMS()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigated to Add Employee Page",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmpSteps.i_navigated_to_Add_Employee_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add new Employee",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sprint2"
    },
    {
      "name": "@addEmployee"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I add \"Sami\" , \"X\" and \"XYZ\"",
  "keyword": "When "
});
formatter.match({
  "location": "AddEmpSteps.i_add_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click Save",
  "keyword": "When "
});
formatter.match({
  "location": "AddEmpSteps.i_click_Save()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see Employee with \"Sami\" , \"X\" and \"XYZ\" is succesfully added",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmpSteps.i_see_Employee_with_and_is_displayed(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png");
formatter.after({
  "status": "passed"
});
});