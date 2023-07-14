
package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(glue = { "com.stepdefinitions", "com.hooks" }, features = "src/test/resources/",

		plugin = { "pretty", "html:CucumberReports/Reports" }, monochrome = true,

		tags = "@cart")

public class TestRunner {

}
