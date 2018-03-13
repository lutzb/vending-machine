# Vending Machine

## Project Summary

Implementation of the `Vending Machine` code kata defined by the requirements [found here.](https://github.com/PillarTechnology/kata-vending-machine) The project is implemented in simple Java8 using as little dependencies as possible, while still maintaining readability, efficiency, and clean code principles.  

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

To execute Junit tnit tests, right-click on the `test` package -> `Run As` -> `Junit test`

## Example Transcript

An example transcript of a user interaction can be [found here.](example-transcript.txt)

## Author and Personal Comments

Implemented by Bryan Lutz - bryanlutz.212@gmail.com