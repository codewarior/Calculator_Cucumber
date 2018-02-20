package com.calculator.bdd.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import io.appium.java_client.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSElement;

public class CalculatorUI {

	private AppiumDriver<IOSElement> driver;
	protected String operandInStringView = ""; // Object to hold Operand in string format
	protected String[] operandInArrayView; /// Array to hold each digit of operand
	protected boolean isNegativeValue;

	public CalculatorUI(AppiumDriver<IOSElement> inputDriver) {
		this.driver = inputDriver;
	}

	public void performCalculations(double arg1, double arg2, String operand) throws MalformedURLException {

		// create an array of arguments passed to method
		double[] inputArgs = { arg1, arg2 };
		// iterate through each value in Array
		for (int counter = 0; counter < inputArgs.length; counter++) {
			// Flag if input is negative
			isNegativeValue = false;

			// determine of Operand is Integer or Double
			if (inputArgs[counter] % 1 == 0)
				operandInStringView = Integer.toString((int) inputArgs[counter]); // Convert Integer to String
			else
				operandInStringView = Double.toString(inputArgs[counter]); // Convert Double to String

			// convert string to array, so that we can access individual digit/character
			operandInArrayView = operandInStringView.split("");

			// Iterate through String array holding operand and click buttons on Calculator
			enterOperandValue();

			// Click Operator when all digits for operand are entered
			if (counter < inputArgs.length - 1) {
				// click respective Operator button.
				clickButton(getButtonLabel(operand));
			}
		} // for loop for arguments counter ends here
		clickButton(getButtonLabel("="));
	} // Unified method ends here

	// Enter operand value
	public void enterOperandValue() {
		// Iterate through array which holds all digits/characters of operand
		for (int counter = 0; counter < operandInStringView.length(); counter++) {
			// if first character of operand is - sign then its negative value
			if (counter == 0 & operandInArrayView[counter].equals("-")) {
				// enable flag as the value is negative
				isNegativeValue = true;
			} else {
				// Get the AXDescription of iterating character and click button on calculator
				try {
					clickButton(getButtonLabel(operandInArrayView[counter]));
					// Once all digits are clicked, toggle value to negative (where applicable)
					if (isNegativeValue == true & counter == operandInStringView.length() - 1) {
						// when argument is negative, click +/- button
						clickButton(getButtonLabel("+/-"));
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					System.out.println(" Error during object identification from Array " + e.getStackTrace());
				}
			}
		}
	}

	// Click button based on AXDescription value
	public IOSElement clickButton(String Identifier) throws MalformedURLException {

		IOSElement calculatorButton = null;
		try {
			// Wait for 10 seconds until the control becomes visible
			calculatorButton = (IOSElement) (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"/AXApplication[@AXTitle='Calculator']/AXWindow[0]/AXGroup[1]/AXButton[@AXDescription='"
									+ Identifier + "']")));
			if (calculatorButton != null) {
				Actions builder = new Actions(driver);
				builder.moveToElement(calculatorButton).click().perform();
				// Found_Object.click();
			}
		} catch (NoSuchElementException ex) {
			System.out.print("\n Button object not found....");
		}
		return calculatorButton;
	}

	// Get label for each button
	public String getButtonLabel(String buttonDisplayLabel) {
		String buttonActualLabel = "";
		switch (buttonDisplayLabel) {
		case "0":
			buttonActualLabel = "zero";
			break;
		case "1":
			buttonActualLabel = "one";
			break;
		case "2":
			buttonActualLabel = "two";
			break;
		case "3":
			buttonActualLabel = "three";
			break;
		case "4":
			buttonActualLabel = "four";
			break;
		case "5":
			buttonActualLabel = "five";
			break;
		case "6":
			buttonActualLabel = "six";
			break;
		case "7":
			buttonActualLabel = "seven";
			break;
		case "8":
			buttonActualLabel = "eight";
			break;
		case "9":
			buttonActualLabel = "nine";
			break;
		case "+/-":
			buttonActualLabel = "negate";
			break;
		case ".":
			buttonActualLabel = "point";
			break;
		case "+":
			buttonActualLabel = "add";
			break;
		case "-":
			buttonActualLabel = "subtract";
			break;
		case "*":
			buttonActualLabel = "multiply";
			break;
		case "/":
			buttonActualLabel = "divide";
			break;
		case "=":
			buttonActualLabel = "equals";
		} // Case-Switch ends here
		return buttonActualLabel;
	}

	// get the output from resultant field
	public double getResult() {

		IOSElement resultFieldValue = null;
		try {
			// get hold of calculator result field
			resultFieldValue = (IOSElement) (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("/AXApplication[@AXTitle='Calculator']/AXWindow[0]/AXGroup[0]/AXStaticText[0]")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// round result to 2 decimal places
		return new BigDecimal(resultFieldValue.getText()).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
}
