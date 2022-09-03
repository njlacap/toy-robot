package app.robot.domain.command.impl;

import app.robot.constant.Direction;
import app.robot.constant.ErrorMessage;
import app.robot.domain.command.ToyCommand;
import app.robot.domain.robot.ToyRobot;

public class LeftCommand extends ToyCommand {

    private ToyRobot toyRobot;

    /**
     * Left Command constructor
     * @param toyRobot toy robot object
     */
    public LeftCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    /**
     * Execute method to simulate toy robot left command
     */
    @Override
    public void execute() {
        switch (toyRobot.getHeadDirection()) {
            case NORTH:
                toyRobot.setHeadDirection(Direction.WEST);
                break;
            case EAST:
                toyRobot.setHeadDirection(Direction.NORTH);
                break;
            case SOUTH:
                toyRobot.setHeadDirection(Direction.EAST);
                break;
            case WEST:
                toyRobot.setHeadDirection(Direction.SOUTH);
                break;
            default:
                System.out.println(ErrorMessage.IGNORE_COMMAND_MESSAGE.getMessage());
        }
    }
}
