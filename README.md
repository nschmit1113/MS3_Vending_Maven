# MS3_Vending_Machine

## Vending Machine Software
We are building new Java based software that will run on a vending machine. The application
will receive a JSON file at any given time and will update the functionality of the machine. When
a consumer enters a selection, it should report what was selected.
### Requirements:

- Provide a loading option for new product lists to update.
- Rows will be Letters.
- Columns will be Numbers.
- User must be able to enter a selection.
- Machine must prompt the user for payment and amount in US dollars.
- If user enters in payment, calculation must occur and be reported.
- Machine must state the current state of the transaction.
- Actions must be cleanly logged for audit purposes.
  ### Bonus features:
- Unit testing.
- UI/UX for the user entry and product loading.
  ### Rules and guidelines:

1. Source must be loaded into a public GitHub repository.
2. Feel free to use any 3rd party libraries or resources.
3. Utilizing existing tools like Maven and open source libraries is encouraged.
4. While a full solution is best, incomplete submissions still be evaluated on approach.
5. It is required that you provide a README detailing the challenge. Your README should
   include instructions to run your code, and a description of the approach you took to solve
   the challenge.
6. Submission deadline: Solution must be received by Talent Acquisition Team within 1
   week.

## Solution

In my solution I decided to approach this problem by breaking the components of the assignment up into smaller 
chunks and then solving the small parts first. For example, the Credit and Inventory classes are mostly barebones with only limited types of functions. 

## How To Run

To run using the command line, you will need to have maven installed on your machine.
It is also possible that the .json file will need to have its path set or have a new file loaded.

* Step 1: Navigate to the cloned directory, it should have the src and pom.xml files in it.
* Step 2: Run the following commands: 
* Step 3: '''mvn clean install'''
* Step 4: '''mvn dependency:copy-dependencies'''
* Step 5: '''cd target'''
* step 6: '''java -cp "vending-1.0.jar:dependency/*" vendingmachine.cmdui'''



The program should now be running, enjoy!
