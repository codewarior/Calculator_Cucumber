package com.calculator.bdd.calculator;

import io.appium.java_client.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;


public class Calculator {

    public AppiumDriver<IOSElement> driver;
	protected String operand_in_String ="";		// Object to hold Operand in string format
	protected String[] operand_in_Array;			/// Array to hold each digit of operand 
	protected boolean is_Negative;
    protected DesiredCapabilities capabilities;

    public void init()
    {
    		/* key piece of code as we are connecting to local Appium Server running over 127.0.0.1 with port 4622 */
    	    /* Specify desired capabilities required by Appium server*/
    	
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "mac");
        capabilities.setCapability("deviceName", "mac");
        capabilities.setCapability("app", "/Applications/Calculator.app");
        try {

        		/* Since we need to connect to Appium-for-Mac, so we need to create an object of AppiumDriver class*/
			driver = new io.appium.java_client.ios.IOSDriver<IOSElement>(new URL("http://127.0.0.1:4622/wd/hub"), capabilities);	
			// launch calculator application
			driver.get("/Applications/Calculator.app");
			
			// Set calculator to Basic mode. click View -> Basic menu item 
    	 		IOSElement Basic_View = (IOSElement)driver.findElement(By.xpath("/AXApplication[@AXTitle='Calculator']/AXMenuBar[0]/AXMenuBarItem[@AXTitle='View']/AXMenu[0]/AXMenuItem[@AXTitle='Basic']"));
    	 		Basic_View.click();

		} catch (Exception e) {
			System.out.println("\n ------- Unable to launch Calculator with Appium");
        }
    }
	
     public void Unified_Method(double arg1, double arg2, String Operand) throws MalformedURLException {    	 
        
        // create an array of arguments passed to method
        double[] input_args = {arg1, arg2};
        // iterate through each value in Array
        for(int counter=0; counter<input_args.length; counter++)
        {
            // Flag if input is negative
        		is_Negative = false;

	        		// determine of Operand is Integer or Double
		        	if(input_args[counter]%1 ==0)
		        		operand_in_String = Integer.toString((int)input_args[counter]); 	// No Fractional values
		        	else
		        		operand_in_String = Double.toString(input_args[counter]);			// Contains Fractional values
		        		
		        		// convert string to array, so that we can access individual digit/character
		        		operand_in_Array = operand_in_String.split("");
        			        		
	        	// Method to iterate through String array holding operand and click buttons on Calculator
            click_Operand_Buttons();
	        
            // Click Operator when all digits for operand are entered
	        	if(counter<input_args.length-1)
	        	{
	        		// click respective Button.
	        		click_Button(get_Button_Code(Operand));
	        	}	        	
        } // for loop for arguments counter ends here
        click_Button(get_Button_Code("="));	// perform calculations
    }  // Unified method ends here
         
    
     
     // ********************* =========================================**********************//	
 	 // ************============ Iterate Array and call click method ===========**********//
     // ********************* =========================================**********************//	
     
     public void click_Operand_Buttons()
     {
    	 	// Iterate through array which holds all digits/characters of operand
     	for(int counter = 0; counter<operand_in_String.length(); counter++)
     	{
     		// if first character of operand is - sign then its negative value
     		if(counter == 0 & operand_in_Array[counter].equals("-")) 
     		{
     			// enable bit that negative value found
     			is_Negative=true;
     		}
 			else 
 			{
 				// Get the AXDescription of iterating character and then click the button on calculator
 				try {
 						click_Button(get_Button_Code(operand_in_Array[counter]));
						// Once all digits are clicked, toggle value to negative (where applicable)
						if(is_Negative==true & counter==operand_in_String.length()-1)
			        		{
		        				// when argument is negative, click +/- button
							click_Button(get_Button_Code("+/-"));
			        		}
 					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						System.out.println(" Error during object identification from Array "+e.getStackTrace());
 					}
 			}	        	
     	}
     }
             
     // ********************* =========================================**********************//	
 	 // ************============ Get label for each button found / used ===========**********//
     // ********************* =========================================**********************//	
     
    // Get Unique Identifier of certain Operand
    public String get_Button_Code(String Operand_Number)
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
	    	} // Case-Switch ends here
    return Return_code;
    }  // Get_Operand_Identifier ends here		
	

    // ********************* =========================================**********************//	
	// **********=========== Click button based on AXDescription value ==========**********//
    // ********************* =========================================**********************//	

    // click object passed as argument to method
	public IOSElement click_Button(String Identifier) throws MalformedURLException{
			 	
		IOSElement Found_Object = null;
		try {
			// Wait for 10 seconds until the control becomes visible
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
	}  
	
    
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
