package com.calculator.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

@RunWith(Cucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
overviewReport = true,
outputFolder = "target")
@CucumberOptions(
        format = { "pretty", "html:target/Destination" },
        glue = "com.calculator.bdd.steps",
        features = "classpath:cucumber/calculator.feature",
        		plugin = { "html:target/cucumber-html-report",
        		        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        		        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" }
)
public class RunCalculatorTest {
}


//format={"pretty","html:target/Reports"}

