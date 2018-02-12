package com.calculator.bdd.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import cucumber.api.PendingException;
import cucumber.api.java.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.calculator.bdd.calculator.Calculator;

public class CalculatorSteps {

    private Calculator calculator;
    protected DesiredCapabilities capabilities;
    public AppiumDriver<IOSElement> driver;
    protected WebDriverWait wait;
    
    @Before
    public void setUp() {

    	Runtime rt = Runtime.getRuntime();
    	try {
			rt.exec("killall -9 " +"Calculator");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	calculator = new Calculator();
        
        /* key piece of code as we are connecting to local Appium Server running over 127.0.0.1 with port 4622
         * The port was specified while compiling the codebase of Appium-for-Mac
         * Since the test is on local MAC machine, so platform_name is set as MAC.*/

    	    /*In following code lines we are specifying the desired capabilities required by Appium server*/
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "mac");
        capabilities.setCapability("platformVersion", "10.13.2");
        capabilities.setCapability("deviceName", "mac");
        capabilities.setCapability("app", "/Applications/Calculator.app");
        try {

		/* Since we need to connect to Appium-for-Mac, so we need to create an object of AppiumDriver class
		 * The object will be initialized using above mentioned desired capabilities
		 * In order to test if Appium server is running/listening on 4622 port, try opening following URL in web browser
		 */
			
			driver = new io.appium.java_client.ios.IOSDriver<IOSElement>(new URL("http://127.0.0.1:4622/wd/hub"), capabilities);	
			// launch calculator application
			driver.get("/Applications/Calculator.app");
			
		} catch (Exception e) {
			System.out.println("\n ------- Unable to launch Calculator with Appium");
        }
    }

    @Given("^I have a calculator$")
    public void i_have_a_calculator() throws Throwable {
        assertNotNull(calculator);
    }

    // *******************************************************************************//
    // =======================  Addition scenarios start here ======================= //
    // *******************************************************************************//

    @When("^I add (\\d+) and (\\d+)$")
    public void i_add_and(int arg1, int arg2) throws Throwable {
        calculator.Unified_Method((double)arg1, (double)arg2,"+");
      }

    // if second operand is negative
    @When("^I add (\\d+) and -(\\d+)$")
    public void i_add_second_operand_negative(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method((double)arg1, Double.parseDouble("-"+arg2),"+");
       // throw new PendingException();
    }

    // if first operand is negative
    @When("^I add -(\\d+) and (\\d+)$")
    public void i_add_first_operand_negative(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1), (double)arg2,"+");
       // throw new PendingException();
    }

    @When("^I add -(\\d+) and -(\\d+)$")
    public void i_add_and_both_negative(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1), Double.parseDouble("-"+arg2),"+");
      //  throw new PendingException();
    }
    
    @When("^I add (\\d+) and (\\d+)\\.(\\d+)$")
    public void i_add_and_second_double(int arg1, int arg2, int arg3) throws Throwable {
    	calculator.Unified_Method((double)arg1,Double.parseDouble(arg2+"."+arg3),"+");
       // throw new PendingException();
    }
   
    @When("^I add (\\d+)\\.(\\d+) and (\\d+)$")
    public void i_add_and(int arg1, int arg2, int arg3) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2), (double)arg3,"+");
        //throw new PendingException();
    }
         
    @When("^I add (\\d+)\\.(\\d+) and (\\d+)\\.(\\d+)$")
    public void i_add_and(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),Double.parseDouble(arg3+"."+arg4),"+");
       // throw new PendingException();
    }

    @When("^I add (\\d+)\\.(\\d+) and -(\\d+)\\.(\\d+)$")
    public void i_add_fload_second_negative_float(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),Double.parseDouble("-"+arg3+"."+arg4),"+");
        //throw new PendingException();
    }
    
    @When("^I add -(\\d+)\\.(\\d+) and (\\d+)\\.(\\d+)$")
    public void i_add_negative_double_and_second_positive_double(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1+"."+arg2),Double.parseDouble(arg3+"."+arg4),"+");
       // throw new PendingException();
    }
    
    @When("^I add -(\\d+)\\.(\\d+) and -(\\d+)\\.(\\d+)$")
    public void i_add_both_negative_doublea(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1+"."+arg2),Double.parseDouble("-"+arg3+"."+arg4),"+");
       // throw new PendingException();
    }
    
    // *******************************************************************************//
    // =======================  Subtraction scenarios start here ==================== //
    // *******************************************************************************//
    
    @When("^I have (\\d+) and Subtract (\\d+)$")
    public void i_Subtract_from(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method((double)arg1, (double)arg2,"-");
   //     throw new PendingException();
    }
    
    @When("^I have (\\d+) and Subtract -(\\d+)$")
    public void First_Postive_Second_Negative(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method((double)arg1, Double.parseDouble("-"+arg2),"-");
        //throw new PendingException();
    }
    
    @When("^I have -(\\d+) and Subtract (\\d+)$")
    public void i_have_first_negative_and_Subtract(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1), (double)arg2,"-");
        //throw new PendingException();
    }
    
    @When("^I have -(\\d+) and Subtract -(\\d+)$")
    public void Both_Numbers_are_Negative(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1), Double.parseDouble("-"+arg2),"-");
        //throw new PendingException();
    }
    
    @When("^I have (\\d+) and Subtract (\\d+)\\.(\\d+)$")
    public void First_Integer_Second_Double_Subtraction(int arg1, int arg2, int arg3) throws Throwable {
    	calculator.Unified_Method((double)arg1, Double.parseDouble(arg2+"."+arg3),"-");
       // throw new PendingException();
    }

    @When("^I have (\\d+)\\.(\\d+) and Subtract (\\d+)$")
    public void First_Double_Second_Integer_Subtraction(int arg1, int arg2, int arg3) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),(double)arg3,"-");
       // throw new PendingException();
    }

    @When("^I have (\\d+)\\.(\\d+) and Subtract (\\d+)\\.(\\d+)$")
    public void Both_Double_Values_Subtraction(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),Double.parseDouble(arg3+"."+arg4),"-");
        //throw new PendingException();
    }

    @When("^I have (\\d+)\\.(\\d+) and Subtract -(\\d+)\\.(\\d+)$")
    public void Both_Double_with_Second_Negative_Subtraction(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),Double.parseDouble("-"+arg3+"."+arg4),"-");
        //throw new PendingException();
    }

    @When("^I have -(\\d+)\\.(\\d+) and Subtract (\\d+)\\.(\\d+)$")
    public void Both_Double_with_First_Negative_Subtraction(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1+"."+arg2),Double.parseDouble(arg3+"."+arg4),"-");
      //  throw new PendingException();
    }

    @When("^I have -(\\d+)\\.(\\d+) and Subtract -(\\d+)\\.(\\d+)$")
    public void i_have_and_Subtract(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1+"."+arg2),Double.parseDouble("-"+arg3+"."+arg4),"-");
     //   throw new PendingException();
    }
    
    
    // *******************************************************************************//
    // =======================  Multiplication scenarios start here ================== //
    // *******************************************************************************//
    
    @When("^I Multiply (\\d+) with (\\d+)$")
    public void i_Multiply_Positive_Doubles(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method((double)arg1, (double)arg2,"*");
    //    throw new PendingException();
    }
    
    @When("^I Multiply (\\d+) with -(\\d+)$")
    public void Integer_Vaues_With_Second_Negative_Multiplication(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method((double)arg1, Double.parseDouble("-"+arg2),"*");
    //    throw new PendingException();
    }
    
    @When("^I Multiply -(\\d+) with (\\d+)$")
    public void Integer_Vaues_With_First_Negative_Multiplication(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1), (double)arg2,"*");
        //throw new PendingException();
    }

    @When("^I Multiply -(\\d+) with -(\\d+)$")
    public void Integer_Vaues_With_Both_Negative_Multiplication(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1), Double.parseDouble("-"+arg2),"*");
      //  throw new PendingException();
    }

    @When("^I Multiply (\\d+) with (\\d+)\\.(\\d+)$")
    public void Vaues_With_Second_Double_Multiplication(int arg1, int arg2, int arg3) throws Throwable {
    	calculator.Unified_Method((double)arg1, Double.parseDouble(arg2+"."+arg3),"*");    	
     //   throw new PendingException();
    }

    @When("^I Multiply (\\d+)\\.(\\d+) with (\\d+)$")
    public void Vaues_With_First_Double_Multiplication(int arg1, int arg2, int arg3) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),(double)arg3,"*");  
       // throw new PendingException();
    }

    @When("^I Multiply (\\d+)\\.(\\d+) with (\\d+)\\.(\\d+)$")
    public void Vaues_With_Both_Double_Multiplication(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),Double.parseDouble(arg3+"."+arg4),"*");  
        //throw new PendingException();
    }

    @When("^I Multiply (\\d+)\\.(\\d+) with -(\\d+)\\.(\\d+)$")
    public void Vaues_With_Both_Double_Second_Negative_Multiplication(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),Double.parseDouble("-"+arg3+"."+arg4),"*");
        //throw new PendingException();
    }

    @When("^I Multiply -(\\d+)\\.(\\d+) with (\\d+)\\.(\\d+)$")
    public void Vaues_With_Both_Double_First_Negative_Multiplication(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1+"."+arg2),Double.parseDouble(arg3+"."+arg4),"*");
       // throw new PendingException();
    }

    @When("^I Multiply -(\\d+)\\.(\\d+) with -(\\d+)\\.(\\d+)$")
    public void Vaues_With_Both_Double_Both_Negative_Multiplication(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1+"."+arg2),Double.parseDouble("-"+arg3+"."+arg4),"*");
       // throw new PendingException();
    }
    
    
    // *******************************************************************************//
    // =======================  Division scenarios start here ==================== //
    // *******************************************************************************//
    
    
    @When("^I Divide (\\d+) by (\\d+)$")
    public void i_Divide_by(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method((double)arg1, (double)arg2,"/");
       // throw new PendingException();
    }

    @When("^I Divide (\\d+) by -(\\d+)$")
    public void First_Positive_Second_Negative_Division(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method((double)arg1, Double.parseDouble("-"+arg2),"/");
      //  throw new PendingException();
    }

    @When("^I Divide -(\\d+) by (\\d+)$")
    public void First_Negative_Second_Positive_Division(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1), (double)arg2,"/");
     //   throw new PendingException();
    }

    @When("^I Divide -(\\d+) by -(\\d+)$")
    public void First_Negative_Second_Negative_Division(int arg1, int arg2) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1), Double.parseDouble("-"+arg2),"/");
      //  throw new PendingException();
    }

    @When("^I Divide (\\d+) by (\\d+)\\.(\\d+)$")
    public void First_Integer_Second_Double_Division(int arg1, int arg2, int arg3) throws Throwable {
    	calculator.Unified_Method((double)arg1, Double.parseDouble(arg2+"."+arg3),"/");
     //   throw new PendingException();
    }

    @When("^I Divide (\\d+)\\.(\\d+) by (\\d+)$")
    public void First_Double_Second_Integer_Division(int arg1, int arg2, int arg3) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),(double)arg3,"/");  
      //  throw new PendingException();
    }

    @When("^I Divide (\\d+)\\.(\\d+) by (\\d+)\\.(\\d+)$")
    public void First_Double_Second_Double_Division(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),Double.parseDouble(arg3+"."+arg4),"/"); 
      //  throw new PendingException();
    }

    @When("^I Divide (\\d+)\\.(\\d+) by -(\\d+)\\.(\\d+)$")
    public void First_Double_Positive_Second_Double_Negative_Division(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble(arg1+"."+arg2),Double.parseDouble("-"+arg3+"."+arg4),"/");
     //   throw new PendingException();
    }

    @When("^I Divide -(\\d+)\\.(\\d+) by (\\d+)\\.(\\d+)$")
    public void First_Double_Negative_Second_Double_Positive_Division(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1+"."+arg2),Double.parseDouble(arg3+"."+arg4),"/");
     //   throw new PendingException();
    }

    @When("^I Divide -(\\d+)\\.(\\d+) by -(\\d+)\\.(\\d+)$")
    public void First_Double_Negative_Second_Double_Negative_Division(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    	calculator.Unified_Method(Double.parseDouble("-"+arg1+"."+arg2),Double.parseDouble("-"+arg3+"."+arg4),"/");
      //  throw new PendingException();
    }

    // *******************************************************************************//
    // =======================  Results Assertion =================================== //
    // *******************************************************************************//    
    
    
    // when result is positive value
    @Then("^the result should be (\\d+)$")
    public void the_result_should_be(double result) throws Throwable {
        assertEquals(result, calculator.getResult(),0.0);
    }
    
    // when result is negative value
    @Then("^the result should be -(\\d+)$")
    public void the_result_should_be_negative_value(double result) throws Throwable {
    		assertEquals(Double.parseDouble("-"+result), calculator.getResult(),0.0);
      //  throw new PendingException();
    }
    
    @Then("^the result should be (\\d+)\\.(\\d+)$")
    public void the_result_should_be(int arg1, int arg2) throws Throwable {
    	assertEquals(Double.parseDouble(arg1+"."+arg2), calculator.getResult(),0.0);
     //   throw new PendingException();
    }

    @Then("^the result should be -(\\d+)\\.(\\d+)$")
    public void the_result_should_be_negative_double(int arg1, int arg2) throws Throwable {
    	assertEquals(Double.parseDouble("-"+arg1+"."+arg2), calculator.getResult(),0.0);
       // throw new PendingException();
    }
    
    @And("^close Calculator Application$")
    public void Close_Calculator() throws Throwable {
    		
    }
    
    @After
    public void Teardown()
    {
   // driver.closeApp();
 //driver.quit();
    
    }
    
 
}
