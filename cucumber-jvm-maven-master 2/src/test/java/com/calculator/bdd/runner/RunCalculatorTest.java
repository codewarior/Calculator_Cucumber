package com.calculator.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = "com.calculator.bdd.steps", 
		features = "classpath:cucumber/calculator.feature", 
		plugin = {
		"html:target/cucumber-html-report" })
public class RunCalculatorTest {
}