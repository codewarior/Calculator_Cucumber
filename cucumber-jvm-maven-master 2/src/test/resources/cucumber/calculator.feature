Feature: Calculator
  As a user
  I want to use a calculator application
  So that I don't need to perform calculations myself



# ============= following test cases are related to ADDITION feature of calculator application. =================== #

   Scenario: Add two numbers
    Given I have a calculator
    When I add 905 and 2018
    Then the result should be 2923
    
    Scenario: Add two numbers
    Given I have a calculator
    When I add 2 and -7
    Then the result should be -5
   
  Scenario: Add two numbers   
    Given I have a calculator
    When I add -4 and 97
    Then the result should be 93

  Scenario: Add two numbers
    Given I have a calculator
    When I add -666 and -7
    Then the result should be -673

  Scenario: Add two numbers
    Given I have a calculator
    When I add 6 and 7.6
    Then the result should be 13.6
        
  Scenario: Add two numbers
    Given I have a calculator
    When I add 102.2 and 7
    Then the result should be 109.2
  
  Scenario: Add two numbers  
    Given I have a calculator
    When I add 96.2 and 0.2
    Then the result should be 96.4
    
  Scenario: Add two numbers  
    Given I have a calculator
    When I add 46.2 and -0.2
    Then the result should be 46.0 

  Scenario: Add two numbers  
    Given I have a calculator
    When I add -196.7 and 0.9
    Then the result should be -195.8 
    
  Scenario: Add two numbers  
    Given I have a calculator
    When I add -155.6 and -987.9
    Then the result should be -1143.5

# ============= following test cases are related to SUBTRACTION feature of calculator application. =================== #
    
 Scenario: Subtract two numbers
    Given I have a calculator
    When I have 9 and Subtract 3
    Then the result should be 6 
    
Scenario: Subtract two numbers
    Given I have a calculator
    When I have 9 and Subtract -3
    Then the result should be 12 
    
Scenario: Subtract two numbers
    Given I have a calculator
    When I have -75 and Subtract 3
    Then the result should be -78

Scenario: Subtract two numbers
    Given I have a calculator
    When I have -9 and Subtract -3
    Then the result should be -6

Scenario: Subtract two numbers
    Given I have a calculator
    When I have 143 and Subtract 19.2
    Then the result should be 123.8

Scenario: Subtract two numbers
    Given I have a calculator
    When I have 546.3 and Subtract 235
    Then the result should be 311.3
    
Scenario: Subtract two numbers
    Given I have a calculator
    When I have 875.5 and Subtract 187.8
    Then the result should be 687.7

Scenario: Subtract two numbers
    Given I have a calculator
    When I have 1245.8 and Subtract -7347.3
    Then the result should be 8593.1

Scenario: Subtract two numbers
    Given I have a calculator
    When I have -45.2 and Subtract 747.9
    Then the result should be -793.1

Scenario: Subtract two numbers
    Given I have a calculator
    When I have -1001.4 and Subtract -9047.6
    Then the result should be 8046.2

# ============= following test cases are related to MULTIPLICATION feature of calculator application. =================== #

    
 Scenario: Multiple two numbers
    Given I have a calculator
    When I Multiply 9 with 3
    Then the result should be 27 
    
     Scenario: Multiple two numbers
    Given I have a calculator
    When I Multiply 33 with -3
    Then the result should be -99
    
         Scenario: Multiple two numbers
    Given I have a calculator
    When I Multiply -734 with 43
    Then the result should be -31562
    
         Scenario: Multiple two numbers
    Given I have a calculator
    When I Multiply -64 with -80
    Then the result should be 5120
    
         Scenario: Multiple two numbers
    Given I have a calculator
    When I Multiply 8 with 9.2
    Then the result should be 73.6
    
         Scenario: Multiple two numbers
    Given I have a calculator
    When I Multiply 7.45 with 66
    Then the result should be 491.7
    
         Scenario: Multiple two numbers
    Given I have a calculator
    When I Multiply 8.62 with 17.65
    Then the result should be 152.14
    
         Scenario: Multiple two numbers
    Given I have a calculator
    When I Multiply 3.3 with -9.1
    Then the result should be -30.03
    
         Scenario: Multiple two numbers
    Given I have a calculator
    When I Multiply -76.2 with 72.1
    Then the result should be -5494.02
    
         Scenario: Multiple two numbers
    Given I have a calculator
    When I Multiply -33.1 with -78.7
    Then the result should be 2604.97


# ============= following test cases are related to DIVISION feature of calculator application. =================== #


 Scenario: Divide two numbers
    Given I have a calculator
    When I Divide 81 by 9
    Then the result should be 9
    
     Scenario: Divide two numbers
    Given I have a calculator
    When I Divide 33 by -3
    Then the result should be -11
    
         Scenario: Divide two numbers
    Given I have a calculator
    When I Divide -734 by 43
    Then the result should be -17.07
    
         Scenario: Divide two numbers
    Given I have a calculator
    When I Divide -64 by -8
    Then the result should be 8
    
         Scenario: Divide two numbers
    Given I have a calculator
    When I Divide 78 by 3.2
    Then the result should be 24.38
    
         Scenario: Divide two numbers
    Given I have a calculator
    When I Divide 127.45 by 12
    Then the result should be 10.62
    
         Scenario: Divide two numbers
    Given I have a calculator
    When I Divide 828.62 by 17.65
    Then the result should be 46.95
    
         Scenario: Divide two numbers
    Given I have a calculator
    When I Divide 453.3 by -9.1
    Then the result should be -49.81
    
         Scenario: Divide two numbers
    Given I have a calculator
    When I Divide -76.2 by 2.1
    Then the result should be -36.29
    
         Scenario: Divide two numbers
    Given I have a calculator
    When I Divide -337.1 by -28.7
    Then the result should be 11.75