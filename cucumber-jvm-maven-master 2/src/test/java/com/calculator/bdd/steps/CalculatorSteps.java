package com.calculator.bdd.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.calculator.bdd.calculator.Calculator;

public class CalculatorSteps {

	private Calculator calculator;

	@Before
	public void setUp() {
		// create Calculator object
		calculator = new Calculator();
		// set capabilities and launch Calculator Application
		calculator.init();

	}

	@Given("^I have a calculator$")
	public void i_have_a_calculator() throws Throwable {
		assertNotNull(calculator);
	}

	/* computer results for Addition scenarios */
	@When("^I add \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_add_and(String arg1, String arg2) throws Throwable {
		calculator.ui.performCalculations(Double.parseDouble(arg1), Double.parseDouble(arg2), "+");
	}

	/* computer results for Subtraction scenarios */
	@When("^I have \"([^\"]*)\" and Subtract \"([^\"]*)\"$")
	public void i_have_and_Subtract(String arg1, String arg2) throws Throwable {
		calculator.ui.performCalculations(Double.parseDouble(arg1), Double.parseDouble(arg2), "-");
	}

	/* computer results for Multiplication scenarios */
	@When("^I Multiply \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_Multiply_with(String arg1, String arg2) throws Throwable {
		calculator.ui.performCalculations(Double.parseDouble(arg1), Double.parseDouble(arg2), "*");
	}

	/* computer results for Division scenarios */
	@When("^I Divide \"([^\"]*)\" by \"([^\"]*)\"$")
	public void i_Divide_by(String arg1, String arg2) throws Throwable {
		calculator.ui.performCalculations(Double.parseDouble(arg1), Double.parseDouble(arg2), "/");
	}

	// Result Assertion
	@Then("^the result should be \"([^\"]*)\"$")
	public void Examples_based_Expected_result(double result) throws Throwable {
		assertEquals(result, calculator.ui.getResult(), 0.0);
	}

}
