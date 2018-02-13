package com.calculator.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.calculator.bdd.steps",
        features = "classpath:cucumber/calculator.feature",
        		plugin = { "html:target/cucumber-html-report",
        		        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        		        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" }
)
public class RunCalculatorTest {
}


//format={"pretty","html:target/Reports"}

