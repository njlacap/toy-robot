package app.robot.service;

import app.robot.constant.ErrorMessage;
import app.robot.domain.command.impl.LeftCommand;
import app.robot.domain.command.impl.MoveCommand;
import app.robot.domain.command.impl.PlaceCommand;
import app.robot.domain.command.impl.RightCommand;
import app.robot.domain.robot.ToyRobot;
import app.robot.exception.ToyRobotException;
import app.robot.utility.CommandUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Simulation {

    private int maxPositionX;
    private int maxPositionY;
    private PlaceCommand toyPlaceCommand;
    private ToyRobot toyRobot;
    private MoveCommand toyCommandMove;
    private LeftCommand toyCommandTurnLeft;
    private RightCommand toyCommandTurnRight;
    private int robotCounter = 1;
    private boolean onMenu = true;

    /**
     * Public constructor Simulation class
     * @param maxPositionX maximum x position
     * @param maxPositionY maximum y position
     */
    public Simulation(int maxPositionX, int maxPositionY) {
        this.maxPositionX = maxPositionX;
        this.maxPositionY = maxPositionY;
    }

    /**
     * Simulate method to start the toy robot simulation
     */
    public void simulate() {

        Map<Integer, ToyRobot> toyRobotMap = new HashMap<>();

        System.out.println("\n\nStarted Toy Robot Simulation! \n\nYou can now execute toy robot commands such as: \n" +
                "\"PLACE 1,3,SOUTH\" to place or replace the toy robot on the table \n" +
                "OR \"MOVE\" to make the toy robot move ahead \n" +
                "OR \"LEFT\" to turn the 90 degrees counter clockwise \n" +
                "OR \"RIGHT\" to turn the 90 degrees clockwise \n" +
                "OR \"REPORT\" to display the current state of the toy robot \n" +
                "OR \"EXIT\" to exit the simulation\n");

        Scanner scanner = new Scanner(System.in);
        while (onMenu && scanner.hasNextLine()) {
            String command = scanner.nextLine();

            initialCommand(command,toyRobotMap);
        }

    }

    /**
     * Initialize the different objects to start the simulation
     * @param command command from user input
     * @param toyRobotMap collection of toy robots
     */
    private void initializeSimulation(String command, Map<Integer, ToyRobot> toyRobotMap) {
        placeCommand(command,toyRobotMap);
        createRobot();
        addToyRobotToCollection(toyRobotMap);
        toyCommandMove = new MoveCommand(toyRobot,maxPositionX,maxPositionY);
        toyCommandTurnLeft = new LeftCommand(toyRobot);
        toyCommandTurnRight = new RightCommand(toyRobot);
    }

    /**
     * Place command method
     * @param command command from user input
     * @param toyRobotMap collection of toy robots
     */
    private void placeCommand(String command, Map<Integer, ToyRobot> toyRobotMap) {
        toyPlaceCommand = new PlaceCommand(command,maxPositionX,maxPositionY,toyRobotMap);
    }

    /**
     * Create robot method to generate a toy robot
     */
    private void createRobot() {
        toyRobot = toyPlaceCommand.createRobot();
    }

    /**
     * Add toy robot to toy collection
     * @param toyRobotMap collection of toy robots
     */
    private void addToyRobotToCollection(Map<Integer, ToyRobot> toyRobotMap) {
        toyRobotMap.put(robotCounter,toyRobot);
    }

    /**
     * Move command method
     */
    private void moveCommand() {
        toyCommandMove.execute();
    }

    /**
     * Left command method
     */
    private void leftCommand() {
        toyCommandTurnLeft.execute();
    }

    /**
     * Right command method
     */
    private void rightCommand() {
        toyCommandTurnRight.execute();
    }

    /**
     * Report command method
     */
    private void reportCommand() {
        toyCommandMove.report(toyRobot);
    }

    /**
     * Exit command method
     */
    private void exitCommand() {
        onMenu = false;
        System.exit(1);
    }

    /**
     * Null check method for toy robot
     * @throws ToyRobotException exception for toy robot cases
     */
    private void checkRobot() throws ToyRobotException {
        if (Objects.isNull(toyRobot)) {
            throw new ToyRobotException(ErrorMessage.IGNORE_COMMAND_MESSAGE.getMessage());
        }
    }

    /**
     * Execute command method
     * @param command command from user input
     */
    private void executeCommand(String command) {
        switch (command) {
            case "MOVE":
                moveCommand();
                break;
            case "LEFT":
                leftCommand();
                break;
            case "RIGHT":
                rightCommand();
                break;
            case "REPORT":
                reportCommand();
                break;
            default:
                System.out.println(ErrorMessage.IGNORE_COMMAND_MESSAGE.getMessage());
        }
    }

    /**
     * Initial command method to execute prior steps
     * @param command command from user input
     * @param toyRobotMap collection of toy robots
     */
    private void initialCommand(String command,Map<Integer, ToyRobot> toyRobotMap) {
        try {
            if (CommandUtil.isValidPlaceCommand(command)) {
                initializeSimulation(command, toyRobotMap);
            } else if (CommandUtil.isValidGeneralCommand(command)) {
                if (toyRobotMap.size() < 1) {
                    System.out.println(ErrorMessage.TOY_ROBOT_MESSAGE.getMessage());
                } else {
                    checkRobot();
                    executeCommand(command);
                }
            } else if (command.equals("EXIT")) {
                exitCommand();
            } else {
                System.out.println(ErrorMessage.IGNORE_COMMAND_MESSAGE.getMessage());
            }
        } catch (ToyRobotException e) {
            System.out.println(e.getMessage());
        }
    }

}
