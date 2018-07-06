# BigProgram
Program to allow sales of products between three companies.

## Installation
import project to NetBeans

## Requirements
* NetBeans 8.2

## Description
A program to allow sales of products between three companies.  
BIGa produces : A / BIGb produces : B / BIGc produces : C  
Each of the companies produce one product, each company must trade with the other two to buy products.  
Company BIGa is a supplier of A's. It buys B's and C's  
BIGa has 100 depots each containing a varying number of A's (min stock of A's = 15)(max stock 50)  
   
Each depot can hold a minimum of 3 B's and C's and a maximum of 40  
Company BIGb is a supplier of B's. It buys A's and C's  
BIGb has 100 depots each containing a varying number of B's (min stock of B's = 15)(max stock 50)  
Each depot can hold a minimum of 3 A's and C's and a maximum of 40  
Company BIGc is a supplier of C's. It buys A's and B's  
BIGc has 100 depots each containing a varying number of C's (min stock of C's = 15)(max stock 50)  
Each depot can hold a minimum of 3 A's and B's and a maximum of 40  

## System Functionality  
Create environment.  
*	BigProgram class initializes.
*	BigProgram object will create CompaniesFacade, DepotStorage, DepotBuilder object and a Console object.
*	BigProgram will create three Company objects.
*	Each Company object create  a DepotIterator object.
*	Each Company object will use DepotBuilder to create a hundred Depot objects, three hundred Stock objects and a hundred   Allowance objects.  
*	DepotBuilder object assign to each Depot object,  three Stock objects and one Allowance object.
*	Company object will store each Depot created into an array in DepotStorage.
*	Company object will send the array of depots from DepotStorage object to DepotIterator object.
*	Console object will print on screen a welcome message and menu with the options for trading.
*	Console object will wait for a user input to generate a string of the selection of the user to send to CompaniesFacade object.  
	Perform transactions.  
*	CompaniesFacade object will handle the user input and will perform transactions.
*	CompaniesFacade object will select a depot from one of the three DepotIterator objects, and another Depot from different DepotIterator object to start the trading process (buying and/or selling), until DepotItertator object has no more Depot objects to trade with.
*	CompaniesFacade object will print transaction on demand based on user input. 
	Display results on screen.
*	CompaniesFacade object will call Console object to print trade information header.
*	CompaniesFacade object will call tradeInformationByDepot method of each Company object.
*	The tradeInformationByDepot method in Company object will retrieve sells, delivery sells, purchases, and delivery purchases of each Depot object, and also it will print the trade information for each Depot on demand based on user input.
*	CompaniesFacade object will call Console object to print profit and loss header.
*	CompaniesFacade object will call profitAndLoss method of each Company object to print each profit and loss results.
*	CompaniesFacade object will find the Company that spent the most, and made the most, and it will display on screen for the user.
*	CompaniesFacade object will call Console object to offer the option to quit or return to main menu.



## License
[MIT](https://choosealicense.com/licenses/mit/)
