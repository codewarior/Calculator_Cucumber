package com.calculator.bdd.calculator;

import io.appium.java_client.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.IOException;
import java.net.URL;

public class Calculator {

	public AppiumDriver<IOSElement> driver;
	protected DesiredCapabilities capabilities;
	public CalculatorUI ui;

	public void init() {

		// kill any existing instance of Calculator application
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("killall -9 " + "Calculator");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * Connect Appium Server on port 4622. Specify DesiredCapabilities for Appium
		 * server
		 */

		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "mac");
		capabilities.setCapability("deviceName", "mac");
		capabilities.setCapability("app", "/Applications/Calculator.app");
		try {

			// create an object of AppiumDriver class
			driver = new io.appium.java_client.ios.IOSDriver<IOSElement>(new URL("http://127.0.0.1:4622/wd/hub"),
					capabilities);
			// launch calculator application
			driver.get("/Applications/Calculator.app");

			// Set calculator to Basic mode. click View -> Basic menu item
			IOSElement basicViewMenuItem = (IOSElement) driver.findElement(By.xpath(
					"/AXApplication[@AXTitle='Calculator']/AXMenuBar[0]/AXMenuBarItem[@AXTitle='View']/AXMenu[0]/AXMenuItem[@AXTitle='Basic']"));
			basicViewMenuItem.click();

			ui = new CalculatorUI(driver);

		} catch (Exception e) {
			System.out.println("\n Unable to launch Calculator with Appium" + e.getStackTrace());
		}
	}
}
