Feature: Calculator
  As a user
  I want to use a calculator application
  So that I don't need to perform calculations myself


# ============= following test cases are related to ADDITION feature of calculator application. =================== #

   Scenario Outline: Add two numbers
    Given I have a calculator
    When I add <Operand_1> and <Operand_2>
    Then the result should be <Result>
    
Examples: Data set for Addition scenarios
    | Operand_1 | Operand_2 	| Result		|
    |	12		|	5		|	17		|
    |	2		|	-7		|	-5		|
    |	-4		|	97		|	93		|
    |	-666		|	-7		|	-673		|
    |	6		|	7.6		|	13.6		|
    |	102.2	|	7		|	109.2	|
    |	96.2		|	0.2		|	96.4		|
    |	46.2		|	-0.2		|	46.0		|
    |	-196.7	|	0.9		|	-195.8	|
    |	-155.6	|	-987.9	|	-1143.5	|

   Scenario Outline: Subtract two numbers
    Given I have a calculator
    When I have <Operand_1> and Subtract <Operand_2>
    Then the result should be <Result> 
             
Examples: Data set for Subtraction operations
    | Operand_1 | Operand_2 	| Result		|
    |	9		|	3		|	6		|
    |	9		|	-3		|	12		|
    |	-75		|	3		|	-78		|
    |	-9		|	-3		|	-6		|
    |	143		|	19.2		|	123.8	|
    |	546.3	|	235		|	311.3	|
    |	875.5	|	187.8	|	687.7	|
    |	1245.8	|	-7347.3	|	8593.1	|
    |	-45.2	|	747.9	|	-793.1	|
    |	-1001.4	|	-9047.6	|	8046.2	|
    
   Scenario Outline: Multiply two numbers
    Given I have a calculator
    When I Multiply <Operand_1> with <Operand_2>
    Then the result should be <Result>
    
Examples: Data set for Multiplication operations
    | Operand_1 | Operand_2 	| Result		|
    |	9		|	3		|	27		|
    |	33		|	-3		|	-99		|
    |	-734		|	43		|	-31562	|
    |	-64		|	-80		|	5120		|
    |	8		|	9.2		|	73.6		|
    |	7.45		|	66		|	491.7	|
    |	8.62		|	17.65	|	152.14	|
    |	3.3		|	-9.1		|	-30.03	|
    |	-76.2	|	72.1		|	-5494.02	|
    |	-33.1	|	-78.7	|	2604.97	|
    
  Scenario Outline: Divide two numbers
    Given I have a calculator
    When I Divide <Operand_1> by <Operand_2>
    Then the result should be <Result>
    
Examples: Data set for Division operations
    | Operand_1 | Operand_2 	| Result		|
    |	81		|	9		|	9		|
    |	33		|	-3		|	-11		|
    |	-734		|	43		|	-17.07	|
    |	-64		|	-8		|	8		|
    |	78		|	3.2		|	24.38	|
    |	127.45	|	12		|	10.62	|
    |	828.62	|	17.65	|	46.95	|
    |	453.3	|	-9.1		|	-49.81	|
    |	-76.2	|	2.1		|	-36.29	|
    |	-337.1	|	-28.7	|	11.75	|