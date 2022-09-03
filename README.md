# Toy Robot Simulator
This is a command line **Java 8** application that simulates toy robot movement within a specified grid

## Description
- The application is a simulation of a toy robot moving on a grid with user-defined size.
- There are no obstructions on the grid.
- The robot is free to roam within the grid. Any movement that would result to falling of the 
toy robot will be ignored.
- The coordinates (0,0) will be the SOUTHWEST most corner.
- The first valid command to the robot is a PLACE command after setting the size of the grid

## Commands
- PLACE X,Y,D *- Places the robot on the grid. Sample: `PLACE 1,2,NORTH`*
- MOVE *- Moves the toy robot ahead. Sample: `MOVE`*
- LEFT *- Turns the toy robot 90 degrees counterclockwise. Sample: `LEFT`*
- RIGHT *- Turns the toy robot 90 degrees clockwise. Sample: `RIGHT`*
- REPORT *- Displays the current state of the toy robot. Sample: `REPORT`*
- EXIT *- Exits the application. Sample: `EXIT`*

## Setup
* Import the toy-robot project in your IDE
* Run all Junit tests **(Optional)**
* Build and run
