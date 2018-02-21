Feature: Calculator 
	As a user
	I want to use a calculator application
 	So that I don't need to perform calculations myself

Scenario Outline: Perform operations using two numbers 
	Given I have a calculator 
	When I add "<operand1>" and "<operand2>" 
	Then the result should be "<sumResult>" 
	When I have "<operand1>" and Subtract "<operand2>" 
	Then the result should be "<subResult>" 
	When I Multiply "<operand1>" with "<operand2>" 
	Then the result should be "<mulResult>" 
	When I Divide "<operand1>" by "<operand2>" 
	Then the result should be "<divResult>" 
Examples: Data set for all scenarios 
		| operand1 	| operand2 	| sumResult	|	subResult	|	mulResult	|	divResult	|
		|	12		|	5		|	17		|	7			|	60			|	2.4			|
		|	2		|	-7		|	-5		|	9			|	-14			|	-0.29		|
		|	-490		|	97		|	-393		|	-587			|	-47530		|	-5.05		|
		|	-666		|	-7		|	-673		|	-659			|	4662			|	95.14		|
		|	6		|	7.6		|	13.6		|	-1.6			|	45.6			|	0.79			|
		|	102.2	|	7		|	109.2	|	95.2			|	715.4		|	14.6			|
		|	96.2		|	0.2		|	96.4		|	96			|	19.24		|	481			|
		|	46.2		|	-0.2		|	46.0		|	46.4			|	-9.24		|	-231			|
		|	-196.7	|	0.9		|	-195.8	|	-197.6		|	-177.03		|	-218.56		|
		|	-155.6	|	-987.9	|	-1143.5	|	832.3		|	153717.24	|	0.16			|
