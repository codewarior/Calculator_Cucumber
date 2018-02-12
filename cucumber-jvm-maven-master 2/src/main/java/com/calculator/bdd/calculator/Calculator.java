package com.calculator.bdd.calculator;

import io.appium.*;
import io.appium.java_client.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Stopwatch;

import cucumber.api.Scenario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Calculator {

    private double result;
    protected DesiredCapabilities capabilities;
    protected AppiumDriver<WebElement> driver;
    protected WebDriverWait wait;
    protected static int DEFAULT_WAIT_TIME;
    
    
     public void Unified_Method(double arg1, double arg2, String Operand) throws MalformedURLException {
        result = arg1 + arg2;

        // clear the screen before performing any addition operation
        Click_Operand_Through_Description("clear");
        // create an array of arguments passed to method
        double[] input_arguments = {arg1, arg2};
        // iterator through individual argument of method
        for(int arguments_counter=0; arguments_counter<input_arguments.length; arguments_counter++)
        {
            // check to either mark value as negative or not
            boolean mark_negative = false;

	        	// object to hold string value of argument
	        	String arg1_converted_to_String ="";
	        	// create array to hold each digit of operand 
	        	String[] First_Operand ;
	        	// check if Operand has decimal / fractional value or not
	        	if(input_arguments[arguments_counter] %1==0)
	        	{
	        		// convert double operand to integer and then cast to String object
	        		arg1_converted_to_String = Integer.toString((int)input_arguments[arguments_counter]);            
	        		// create array to hold each digit of operand        
	        		First_Operand = new String[arg1_converted_to_String.length()];
	        		// convert string to string array
	        		First_Operand = arg1_converted_to_String.split("");	
	        	}
	        	else 
	        	{
	        		// convert double operand to string
	        		arg1_converted_to_String = Double.toString(input_arguments[arguments_counter]);
	        		// create array to hold each digits of operand        
	        		First_Operand = new String[arg1_converted_to_String.length()];
	        		// convert string to string array
	        		First_Operand = arg1_converted_to_String.split("");
	        	}
	
	        	for(int operand_counter = 0; operand_counter<arg1_converted_to_String.length(); operand_counter++)
	        	{
	        		if(operand_counter == 0 & First_Operand[operand_counter].equals("-")) 
	        		{
	        			// enable bit that negative value found
	        			mark_negative=true;
	        		}
        			else 
        			{
        				Click_Operand_Through_Description(Get_Operand_With_Description(First_Operand[operand_counter]));
        				//Click_Operand(Get_Operand_Identifier(First_Operand[operand_counter]));   
		        		if(mark_negative==true & operand_counter==arg1_converted_to_String.length()-1)
			        		{
		        				// when argument is negative, click +/- button
		        				Click_Operand_Through_Description(Get_Operand_With_Description("+/-"));
			        		}
	        		}
	        	
	        	}
	        	
	        	// if its not the last operand, then click + button
	        	if(arguments_counter<input_arguments.length-1)
	        	{
	        		// click + operator once we have complete operand entered
	        		Click_Operand_Through_Description(Get_Operand_With_Description(Operand));
	        	}
        } // for loop for arguments counter ends here

    	// click = operator to compute result
    	Click_Operand_Through_Description(Get_Operand_With_Description("="));
    //  driver.closeApp();
      //  driver.quit();
    }  // add method ends here
    
        
    
    // get the output from resultant field
    public double getResult() {
    	
    	IOSElement Result_Field_Object=null;
	 	try {
	 		
			AppiumDriver<IOSElement> driver = new io.appium.java_client.ios.IOSDriver<IOSElement>(new URL("http://127.0.0.1:4622/wd/hub"), capabilities);
			Result_Field_Object= (IOSElement)(new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/AXApplication[@AXTitle='Calculator']/AXWindow[0]/AXGroup[0]/AXStaticText[0]")));		 
	 	
	 	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 	// round result to 2 decimal places
        return new BigDecimal(Result_Field_Object.getText()).setScale(2,RoundingMode.HALF_UP).doubleValue();//Double.parseDouble(Result_Field_Object.getText());
    }    
        
    
    // Get Unique Identifier of certain Operand
    public String Get_Operand_With_Description(String Operand_Number)
    {
    	String Return_code="";
    	switch(Operand_Number) 
	    	{ 
		    	case "0": Return_code = "zero";
		    			break;
		    	case "1": Return_code = "one";
		    			break;
		    	case "2": Return_code =  "two";
		    			break;
		    	case "3": Return_code =  "three";
		    			break;
		    	case "4": Return_code = "four";
		    			break;
		    	case "5": Return_code = "five";
		    			break;
		    	case "6": Return_code = "six";
		    			break;
		    	case "7": Return_code = "seven";
		    			break;
		    	case "8": Return_code = "eight";
		    			break;
		    	case "9": Return_code = "nine";
		    			break;
		    	case "+/-": Return_code = "negate";    	
		    			break;
		    	case ".": Return_code = "point";    	
					break;
		    	case "+": Return_code = "add";    	
				break;
		    	case "-": Return_code = "subtract";    	
				break;
		    	case "*": Return_code = "multiply";    	
				break;
		    	case "/": Return_code = "divide";    	
				break;
		    	case "=": Return_code = "equals";    	
				break;
		    	case "C": Return_code = "clear";    	
				break;
		    	case "AC": Return_code = "clear";    	
				break;
	    	} // Case-Switch ends here
    return Return_code;
    }  // Get_Operand_Identifier ends here		
	
	
    // click object passed as argument to method
	public IOSElement Click_Operand_Through_Description(String Identifier) throws MalformedURLException{
		
	 	AppiumDriver<IOSElement> driver = new io.appium.java_client.ios.IOSDriver<IOSElement>(new URL("http://127.0.0.1:4622/wd/hub"), capabilities);
		IOSElement Found_Object = null;
		try {
			// Identify first Operand over calculator. Wait for 10 seconds until the control becomes visible
			 Found_Object = (IOSElement)(new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/AXApplication[@AXTitle='Calculator']/AXWindow[0]/AXGroup[1]/AXButton[@AXDescription='"+Identifier+"']")));
			if (Found_Object != null) {
               Actions builder = new Actions(driver);
               builder.moveToElement(Found_Object).click().perform();
				//Found_Object.click();
		   }
		}catch(NoSuchElementException ex)
		{
			System.out.print("\n Object Not found....");
		}
		return Found_Object;
	}  // Click_Operand_Through_Description method ends here. This method takes String based Description as an argument
	

}
