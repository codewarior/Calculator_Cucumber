package com.calculator.bdd.calculator;


import io.appium.java_client.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.*;
import org.openqa.selenium.By;

import cucumber.api.Scenario;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;


public class Calculator {

    public AppiumDriver<IOSElement> driver;
	// object to hold string value of argument
	protected String arg1_converted_to_String ="";
	// create array to hold each digit of operand 
	protected String[] First_Operand;
	protected boolean mark_negative;
    
    
     public void Unified_Method(double arg1, double arg2, String Operand) throws MalformedURLException {

    	 	driver = new io.appium.java_client.ios.IOSDriver<IOSElement>(new URL("http://127.0.0.1:4622/wd/hub"), new DesiredCapabilities());
    	 	// Click View -> Basic menu item so that calculator is in Basic mode before any operation is performed
    	 	IOSElement Cal_View = (IOSElement)driver.findElement(By.xpath("/AXApplication[@AXTitle='Calculator']/AXMenuBar[0]/AXMenuBarItem[@AXTitle='View']/AXMenu[0]/AXMenuItem[@AXTitle='Basic']"));
    	 	Cal_View.click();
    	 	
    	 	// clear the result screen before performing any operation
        Click_Operand_Through_Description("clear");
        // create an array of arguments passed to method
        double[] input_arguments = {arg1, arg2};
        // iterator through individual argument of method
        for(int arguments_counter=0; arguments_counter<input_arguments.length; arguments_counter++)
        {
            // Key to mark operand as negative (if any)
        		mark_negative = false;

            // determine if input operand contains fractional values or not
            Determine_Fractional_Part_Existsance(input_arguments[arguments_counter]);	                   
	        	// Method to iterate through String array holding operand and click buttons on Calculator
            Iterate_Characters_and_Click();
	        	// if its not the last operand, then click + button
	        	if(arguments_counter<input_arguments.length-1)
	        	{
	        		// click respective Operator
	        		Click_Operand_Through_Description(Get_Operand_With_Description(Operand));
	        	}
        } // for loop for arguments counter ends here

    	// click = operator to compute result. This is last step for certain computation operation
    	Click_Operand_Through_Description(Get_Operand_With_Description("="));
    }  // add method ends here
    
     
     // ********************* =========================================**********************//	
 	 // *********============ Determine if operand contains fractional value ========********//
     // ********************* =========================================**********************//	
        
     // In following method, we will first determine if the input value contains fractional part or not
     // The double value is then converted to string array, so that we can asses each individual character/digit
     // get its related AXDescription code and use driver to click appropriate button on application.
     public String Determine_Fractional_Part_Existsance(double input_operand)
     {
    		if(input_operand %1==0)
        	{
        		// convert double operand to integer and then cast to String object
        		arg1_converted_to_String = Integer.toString((int)input_operand);            
        		// create array to hold each digit of operand        
        		First_Operand = new String[arg1_converted_to_String.length()];
        		// convert string to array of String type
        		First_Operand = arg1_converted_to_String.split("");	
        	}
        	else 
        	{
        		// convert double operand to string
        		arg1_converted_to_String = Double.toString(input_operand);
        		// create array to hold each digits of operand        
        		First_Operand = new String[arg1_converted_to_String.length()];
        		// convert string to string array
        		First_Operand = arg1_converted_to_String.split("");
        	}
    		return arg1_converted_to_String;
     }	// end of Determine_Fractional_Part_Existsance
    
     
     // ********************* =========================================**********************//	
 	 // ************============ Iterate in Array and call click method ===========**********//
     // ********************* =========================================**********************//	
     
     // Method to iterate through individual character/object inside String array and call click method
     public void Iterate_Characters_and_Click()
     {
    	 	// now we need to iterate through array which holds all digits/characters of particular operand
     	for(int operand_counter = 0; operand_counter<arg1_converted_to_String.length(); operand_counter++)
     	{
     		// if first character of operand is - sign then its negative value
     		if(operand_counter == 0 & First_Operand[operand_counter].equals("-")) 
     		{
     			// enable bit that negative value found
     			mark_negative=true;
     		}
 			else 
 			{
 				// Get the AXDescription of iterating character and then click the button on calculator
 				try {
						Click_Operand_Through_Description(Get_Operand_With_Description(First_Operand[operand_counter]));
						// Once all digits are clicked, we need to toggle the value to negative (where applicable)
						if(mark_negative==true & operand_counter==arg1_converted_to_String.length()-1)
			        		{
		        				// when argument is negative, click +/- button
		        				Click_Operand_Through_Description(Get_Operand_With_Description("+/-"));
			        		}
 					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						System.out.println(" Error during object identification from Array and click on calculator Application "+e.getStackTrace());
 					}
 			}	        	
     	}
     }
             
     // ********************* =========================================**********************//	
 	 // ************============ Get label for each button found / used ===========**********//
     // ********************* =========================================**********************//	
     
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
	

    // ********************* =========================================**********************//	
	// **********============ Click button based on AXDescription value ==========**********//
    // ********************* =========================================**********************//	

    // click object passed as argument to method
	public IOSElement Click_Operand_Through_Description(String Identifier) throws MalformedURLException{
			 	
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
	
    
	// ********************* =========================================**********************//	
	// ************========== Method to get result value on calculator ========*************//
    // ********************* =========================================**********************//		

	// get the output from resultant field
    public double getResult() {
    	
    	IOSElement Result_Field_Object=null;
	 	try {
	 		
			// get hold of calculator result field
			Result_Field_Object= (IOSElement)(new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/AXApplication[@AXTitle='Calculator']/AXWindow[0]/AXGroup[0]/AXStaticText[0]")));		 
	 	
	 	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 	// round result to 2 decimal places
        return new BigDecimal(Result_Field_Object.getText()).setScale(2,RoundingMode.HALF_UP).doubleValue();
    }    


}
