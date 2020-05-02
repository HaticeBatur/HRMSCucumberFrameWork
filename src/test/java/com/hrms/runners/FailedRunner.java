 package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/failed.txt"
		,glue="com/hrms/steps"
		,monochrome=true
		,plugin= {"pretty", "html:target/rerun-default-cucumber-reports"}
		)
public class FailedRunner {

}
