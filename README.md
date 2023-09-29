# Adthena Shopping Basket

## Introduction

ShoppingBasket is a Scala application designed to calculate the total cost of items in a shopping basket, considering applicable discounts.

## Prerequisites

Before running ShoppingBasket, ensure you have the following installed:
1. Java 8 or above  
   Download and install Java from AdoptOpenJDK (https://adoptopenjdk.net/) or Oracle’s official website (https://www.oracle.com/java/technologies/javase-downloads.html). To verify the installation, you can run the following command in your terminal or command prompt:
   
   java -version


2. Scala and SBT  
   Download and install Scala from the official download page https://www.scala-lang.org/download/. To verify the installation, you can run the following command in your terminal or command prompt:
   
   scala -version  
   sbt -version


3. Git  
   Download and install Git from Git’s official website (https://git-scm.com/download/). To verify the installation, you can run the following command in your terminal or command prompt:
   
   git --version

Once all of the above software is installed correctly, you should be able to clone your project using Git, navigate to your project directory, and run your project using SBT.


## Installation
1. Open a terminal/command prompt.  

2. Navigate to the directory where you want to clone the repository. 

2. Run the following command to clone the repository:  
   
   git clone https://github.com/rakeshchy1811/AdthenaShoppingBasket.git
   

3. Navigate to the project directory:
   
   cd AdthenaShoppingBasket
 
 
## Building the Project (OPTIONAL)
1. inside the project directory, run the following command to compile the project and download the necessary dependencies:  

	sbt compile

2. Once the project is compiled successfully, create an assembly JAR using the following command:

	sbt assembly

## Running the Precompiled JAR (If sbt assembly fails)

1. Navigate to the project directory.
2. Run the following command to execute the precompiled JAR:

	.\PriceBasket Apples Milk Bread
	
	Note: See usage for more details
	

## Running the Application
This application can be executed using provided scripts. Depending on your operating system, follow the appropriate steps below:

### For Windows:

1. Ensure you are in the project directory ShoppingBasket.  
2. Run the following command, replacing item1 item2 item3 ... from the list of items (Apples, Milk, Bread, and Soup]) you want to price:
   
   .\PriceBasket item1 item2 item3 ...
   

### For Unix-like Systems:
1. Ensure you are in the project directory ShoppingBasket.
2. Grant execute permissions to the script:
   
   chmod +x PriceBasket  
   
3. Run the script with the desired items: 

   ./PriceBasket item1 item2 item3 ...
   

Notes  
1. Replace item1 item2 item3 ... with the actual items you want to price. Items should be separated by a space.
2. If you face any permissions issues on Unix-like systems, ensure that your user has the right permissions to read and execute the script.

## Usage

To use the application, input items through the command line in the form PriceBasket item1 item2 item3 .... Here, item1, item2, item3, ... represent the names of the items, like Apples, Milk, Bread, and Soup.  

Example: .\PriceBasket Apples Milk Bread  

The application will calculate and display:  

The subtotal (the sum of the normal prices of the items)  
The special offer discounts, if applicable  
The total amount payable after applying the discounts  

Output Example  
For the command above, the output will be:  

Subtotal: £3.10  
Apples 10% off: 10p    
Total price: £3.00  

Items and Special Offers  
The goods that can be purchased, along with their normal prices, are:  

Soup – 65p per tin  
Bread – 80p per loaf  
Milk – £1.30 per bottle  
Apples – £1.00 per bag  
Current Special Offers  
Apples have a 10% discount off their normal price this week    
Buy 2 tins of soup and get a loaf of bread for half price  



## Running Tests
In the project directory, run:
   
   sbt test
   

## Additional Information
- Please ensure that the `PriceBasket.bat` (for Windows) or `PriceBasket` (for Unix-like) file is in the same directory as your `ShoppingBasket-assembly-1.0.jar` file before running the commands.
- If encountering issues with running the `.bat` or shell script, ensure the script files have the correct path to the `ShoppingBasket-assembly-1.0.jar` file.
- The program accepts a list of items in the basket in the form: `PriceBasket item1 item2 item3 ...` and outputs the subtotal, the special offer discounts, and the final price to the console.
