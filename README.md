# Calculator_Cucumber
A project to perform functional regression testing of native Calculator application over MAC OS. The test is based on Cucumber framework and it is executed using Appium for MAC. The project is based on Maven and all required dependencies (defined in pom.xml) will be automatically loaded in project.

Table of contents
=================

<!--ts-->
   * [Features](#features)
   * [Installation](#installation)
   * [Folder Structure](#folder-structure)
   * [Execution Report](#execution-report)
   * [Project Structure](#project-structure)
   * [Dependency](#dependency)
   * [License](#license)
<!--te-->

Features
========
This project demonstrates the functional verification of basic operations performed by calculator application. The calculator.feature file contains a dataset with 10 rows where values specified under Operand column are used as input parameters for calculator application and then Appiums trigers the code to conduct Addition, Subtraction, Multiplication and Subtraction operations.

Installation
============
In order to run the solution/project, you need to firts complete the installation of following pre-requisites (steps are based on macOS)

* Install JDK 1.8 or higher.
  * Get JDK1.8 from [Java download section](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  * Download .dmg file and complete the installation process
  * Set JAVA_HOME in .bash_profile (if file does not exist, create one)
  ```bash
  $ open -e .bash_profile
  ```
  Enter following line in .bash_profile file
  
  ```bash
  export JAVA_HOME=$(/usr/libexec/java_home)
  ```
  Refresh the file using below command
  ```bash
  $ source .bash_profile
  ```
  Check if the JAVA_HOME is set properly
  ```bash
  $ echo $JAVA_HOME
  /Library/Java/JavaVirtualMachines/jdk1.8.0_74.jdk/Contents/Home
  ```
* Install Apache Maven 3.5.2.
  Please follow instructions on [how to install & coinfigure Maven on mac](  https://openiam.atlassian.net/wiki/spaces/IAMSUITEV3/pages/524742/Installing+Apache+Maven+on+Mac).

* Download [Appium for MAC](https://www.dropbox.com/s/uhtnp3g23mxp5rs/AppiumForMac.app.zip?dl=0) application or you can even download [Appium for MAC sourcecode/project](https://github.com//appium/appium-for-mac) and open the solution in XCode. Build the code and add Appium for MAC under Accessibility section over Security & Privacy settings over MAC. Then run the Appium for MAC application.
![alt tag](https://i.imgur.com/7cI6PxG.png).

* Open Teminal and run following commands to get latest copy and execute the tests.
```bash
$ git clone https://github.com/codewarior/Calculator_Cucumber
$ cd Calculator_Cucumber
$ cd cucumber-jvm-maven-master\ 2/
$ mvn test
```
Note:- In case you need to open the solution in Eclipse, then [download Eclipse IDE]( https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/mars2) and for quick understanding of Gherkin systax, install Cucumber Eclipse plugin. Please visit the folllowing link for further details on [installing cucumber eclipse plugin]( http://toolsqa.com/cucumber/install-cucumber-eclipse-plugin/).

Folder Structure
================
Once you have got the project, the folder structure will be as shown below.
![](https://i.imgur.com/cmZxELl.png "Calculator cucumber folder structure")

Execution Report
================
The Maven will download required packages and test will be executed. After the completion of test, a report named *index.html* under cucumber-html-report inside target directory. The report will show summary of test execution and details regarding the scearnios executed. The sample report can be download from [this link](https://www.dropbox.com/s/8hnhj2cgh87yhoo/cucumber-html-report.zip?dl=0).
![alt tag](https://i.imgur.com/sVOeppI.png).

Specified below is preview of report displayed in chrome browser.
![alt tag](https://i.imgur.com/MxjKkBJ.png).

Project Structure
=================
* Calculator.feature :- This file contains the sceanrio details and Examples data which is passed as argument to each parameter in scenario steps. You may update the file to test the application with new dataset.
* CalculatorSteps.java :- This file contains definition for individual step specified in features file. It also contains methods for @Before, @Given, @When and @Then keywords. The setU() method in this class creates an instance of Calculator.java class.
* Calculator.java :- This class creates AppiumDriver object and initializes it with DesiredCapabilities. After initialization, it launches the Calculator application and passes driver object to CalculatorUI class.
* CalculatorUI.java :- This class handles the main calculation operations.
  * performCalculations(...) - It is a core method to perform all arithmetic operations (+, -, *, /). 
  * enterOperandValue(...) - This method initiates the click method to input operand value.
  * clickButton(...) - This method takes string as identifier and based on this value, performs click operation on button.
  * getButtonLabel(...) - This method returns the actual lable as per XPath of control on Calculator application.
  * getResult(..) - This method returns the result being displayed over calculator.
* RunCalculatorTest.java - This class executes the cucummber scenarios and generates resultant report.

Dependency
==========
* JDK 1.8
* Appium for Mac
* Apache Maven

Tested on macOS High Sierra 10.13.2, JDK 1.8.0_161-b12, Apache Maven 3.5.2

License
=======
Copyright (c) 2018 Nayyer Shahbaz

Permission is hereby granted, free of charge, to any person obtaining a copy of this project and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
