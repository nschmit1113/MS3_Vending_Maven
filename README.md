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
chunks and then solving the small parts first. I then wrote down what I thought would be some required methods for the classes to solve each of the smaller parts. I also considered factors such as mutable vs immutable classes and how that would affect my solution, as well as other factors such as implementing a UI vs commandline project. In the end, both mutable and commandline were chosen in the interest of time and coding efficiency. 

The Credit, Snack, and Inventory classes are mostly barebones with only limited types of functions. The cmdui class is the launch point of the project and serves to create the main run loop for the project. The main work of the function happens in the LoadMachine and SelectSnack classes. These classes pull from the three underlying methods to function. To keep the readability better, I tried to seperate each piece into indiviual methods whenever possible. 

A second .json file was used for testing purposes. Also, I did user testing and implemented some JUnit tests. The next steps for this project would be to expand the testing reach and create a full testing suite as well as implement a GUI using React.js or a similar framework. 

## How To Run

To run using the command line, you will need to have maven installed on your machine.
It is also possible that the .json file will need to have its path set or have a new file loaded.

* Step 1: Navigate to the cloned directory, it should have the src and pom.xml files in it.
* Step 2: Run the following commands: 
* Step 3: '''mvn clean install'''
* Step 4: '''mvn dependency:copy-dependencies'''
* step 5: '''java -cp "target/vending-1.0.jar:target/dependency/*" vendingmachine.cmdui'''  (For mac/linux)
* Step 5: '''java -cp "target\vending-1.0.jar;target\dependency\*" vendingmachine.cmdui''' (For Windows)

# Alternate Run Method
Use VSCode to run the program as a maven project.

The program should now be running, enjoy!
