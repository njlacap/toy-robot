package app.robot.domain.command.impl;

import app.robot.constant.Direction;
import app.robot.constant.ErrorMessage;
import app.robot.domain.command.ToyCommand;
import app.robot.domain.robot.ToyRobot;
import app.robot.exception.PlaceCommandException;

import java.util.Map;

public class PlaceCommand extends ToyCommand {

    private String command;
    private final int maxPositionX;
    private final int maxPositionY;
    private int startXPosition;
    private int startYPosition;
    private String headDirection;
    private Map<Integer, ToyRobot> toyRobotMap;

    /**
     * Place Command constructor
     * @param command command from user input
     * @param maxPositionX maximum x position
     * @param maxPositionY maximuim y position
     * @param toyRobotMap collection of toy robots
     */
    public PlaceCommand(String command, int maxPositionX, int maxPositionY, Map<Integer,ToyRobot> toyRobotMap) {
        this.command = command;
        this.maxPositionX = maxPositionX;
        this.maxPositionY = maxPositionY;
        this.toyRobotMap = toyRobotMap;
    }

    /**
     * Execute method to simulate toy robot place command
     * @throws PlaceCommandException exception for place command cases
     */
    @Override
    public void execute() throws PlaceCommandException {
        String placementArgs = command.replace("\\s","").substring(5,command.length()).trim();
        String[] args = placementArgs.split(",");

        startXPosition = Integer.parseInt(args[0].trim());
        startYPosition = Integer.parseInt(args[1].trim());

        if (startXPosition <= maxPositionX && startXPosition >= 0
                && startYPosition <= maxPositionY && startYPosition >= 0) {
            headDirection = args[2].trim();
        } else {
            throw new PlaceCommandException(ErrorMessage.FALLOUT_MESSAGE.getMessage());
        }
    }

    /**
     * Create method to create toy robot
     * @return @{@link ToyRobot}
     */
    public ToyRobot createRobot() {
        try {
            this.execute();
            return new ToyRobot(startXPosition,startYPosition, Direction.valueOf(headDirection));
        } catch (PlaceCommandException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
