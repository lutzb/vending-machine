# Vending Machine

## Project Summary

Implementation of the `Vending Machine` code kata defined by the requirements [found here.](https://github.com/PillarTechnology/kata-vending-machine) The project is implemented in Java8 using as little dependencies as possible, while still maintaining readability, efficiency, and clean code principles.  

Unit tests are written in standard JUnit (4.12).

## Project Structure

The main source code found at `vending-machine/src/main/java/*`

Unit tests found at `vending-machine/test/main/java/*`

`vending-machine/src/main/java/kata/UserInteraction.java` provides a main method that allows the user to interact with the VendingMachine via command-line/console.

`vending-machine/src/main/java/kata/VendingMachine.java` provides the majority of the work and calculations

## Build

The project is built using Maven 3.  The details for the build can be found in `vending-machine/pom.xml`.  To run the build, execute this command from the project root:

`mvn clean install`

This will compile/build the source, run all unit tests, and produce an executable jar file.

## Run

#### Command Line
After the project is built, execute the jar file using the following command:

`java -jar target/VendingMachine-jar-with-dependencies.jar`

#### IDE Execution
If using an IDE such as IntelliJ or Eclipse, right-click on `src/main/java/kata/UserInteraction.java` and run as Java Application. Once this starts up, you may interact with the application via the IDE console.

To execute Junit tests, right-click on the `test` package -> `Run As` -> `Junit test`

## Example Transcript

An example transcript of a user interaction can be [found here.](example-transcript.txt)

## Author and Personal Comments

#### Author
Implemented by Bryan Lutz - bryanlutz.212@gmail.com

#### Kata Submission Time-boxing
To maintain my sanity, I wanted to time-box my effort on this project as the implementation can quite easily spiral out of control by adding various `bells-and-whistles`. This will allow me to submit my solution in a reasonable amount of time as opposed to working on it in my free time over the next 6 months.

#### Implementation Comments
This project provided incredible practice in TDD and implementation of requirements.  As the code evolved, I was able to identify refactor opportunities that were able to be safely completed due to my unit test coverage.  I was also faced with some relatively complex user cases involving coins, returning change, and when the machine would display "EXACT CHANGE ONLY".  My ultimate conclusion was that this test scenario is based on the user input.

For example, if the machine contains one dime, but zero nickels, and the user wants to buy Candy for 0.65 cents using 3 quarters (0.75 cents), the machine CAN make change by returning the dime.  However, if the user has two quarters and two dimes (0.70 cents), the machine CANNOT make change because it has no nickels. The final solution I provided for these scenarios was to add a `safety mechanism` where the machine will only return change if it contains two of each coin.  This will ensure the machine never runs out of coins and can always make change when necessary.  I imagine this is similar to how a real vending machine works.  

#### Future Contributions
However, Since I did feel a good deal of entertainment and accomplishment out of implementing this, I want to continue contributing to it.  I want to establish a formal backlog of tasks such as a MVC framework, web interface for the user to interact with, and TomCat server runtime environment.  I'd like to create a Ruby Automation test suite implemented via Ruby Cucumber with Acceptance tests in Gherkin.  I'd also like to explore the options of implementing this project in different languages, but that may be in the distant future.

