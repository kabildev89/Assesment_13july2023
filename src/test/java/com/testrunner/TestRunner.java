
package com.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(glue = { "com.stepdefinitions",
		"com.ebay.hooks" }, monochrome = true, features = "src/test/resources/",

		plugin = { "pretty", "html:Reports" },

		tags = { "@ebay" })

public class TestRunner {

}
