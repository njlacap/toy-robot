package app.robot.domain.command.impl;

import app.robot.constant.ErrorMessage;
import app.robot.domain.command.ToyCommand;
import app.robot.domain.robot.ToyRobot;
import app.robot.exception.FallOutException;

public class MoveCommand extends ToyCommand {

    private ToyRobot toyRobot;
    private final int maxPositionX;
    private final int maxPositionY;

    public MoveCommand(ToyRobot toyRobot, int maxPositionX, int maxPositionY) {
        this.toyRobot = toyRobot;
        this.maxPositionX = maxPositionX;
        this.maxPositionY = maxPositionY;
    }

    /**
     * Execute method to simulate toy robot move command
     */
    @Override
    public void execute() {
        int toyRobotXPos = toyRobot.getxCoordinate();
        int toyRobotYPos = toyRobot.getyCoordinate();
        try {
            switch (toyRobot.getHeadDirection()) {
                case NORTH:
                    moveNorthCommand(toyRobotYPos);
                    break;
                case EAST:
                    moveEastCommand(toyRobotXPos);
                    break;
                case SOUTH:
                    moveSouthCommand(toyRobotYPos);
                    break;
                case WEST:
                    moveWestCommand(toyRobotXPos);
                    break;
                default:
                    System.out.println(ErrorMessage.IGNORE_COMMAND_MESSAGE.getMessage());
            }
        } catch (FallOutException e) {
            System.out.println(ErrorMessage.IGNORE_COMMAND_MESSAGE.getMessage());
        }
    }

    /**
     * Move north method to move toy robot north
     * @param toyRobotYPos current y position of toy robot
     * @throws FallOutException exception for falling out cases
     */
    private void moveNorthCommand(int toyRobotYPos) throws FallOutException {
        if ((toyRobotYPos++) >= maxPositionY) {
            throw new FallOutException(ErrorMessage.FALLOUT_MESSAGE.getMessage());
        }
        toyRobot.increaseYPosition();
    }

    /**
     * Move east method to move toy robot north
     * @param toyRobotXPos current x position of toy robot
     * @throws FallOutException exception for falling out cases
     */
    private void moveEastCommand(int toyRobotXPos) throws FallOutException {
        if ((toyRobotXPos++) >= maxPositionX) {
            throw new FallOutException(ErrorMessage.FALLOUT_MESSAGE.getMessage());
        }
        toyRobot.increaseXPosition();
    }

    /**
     * Move south method to move toy robot north
     * @param toyRobotYPos current y position of toy robot
     * @throws FallOutException exception for falling out cases
     */
    private void moveSouthCommand(int toyRobotYPos) throws FallOutException {
        if ((toyRobotYPos--) <= 0) {
            throw new FallOutException(ErrorMessage.FALLOUT_MESSAGE.getMessage());
        }
        toyRobot.decreaseYPosition();
    }

    /**
     * Move west method to move toy robot north
     * @param toyRobotXPos current x position of toy robot
     * @throws FallOutException exception for falling out cases
     */
    private void moveWestCommand(int toyRobotXPos) throws FallOutException {
        if ((toyRobotXPos--) <= 0) {
            throw new FallOutException(ErrorMessage.FALLOUT_MESSAGE.getMessage());
        }
        toyRobot.decreaseXPosition();
    }
}
