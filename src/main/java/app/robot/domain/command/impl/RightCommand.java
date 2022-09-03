package app.robot.domain.command.impl;

import app.robot.constant.Direction;
import app.robot.constant.ErrorMessage;
import app.robot.domain.command.ToyCommand;
import app.robot.domain.robot.ToyRobot;

public class RightCommand extends ToyCommand {

    private ToyRobot toyRobot;

    /**
     * Right Command constructor
     * @param toyRobot toy robot object
     */
    public RightCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    /**
     * Execute method to simulate toy robot right command
     */
    @Override
    public void execute() {
        switch (toyRobot.getHeadDirection()) {
            case NORTH:
                toyRobot.setHeadDirection(Direction.EAST);
                break;
            case EAST:
                toyRobot.setHeadDirection(Direction.SOUTH);
                break;
            case SOUTH:
                toyRobot.setHeadDirection(Direction.WEST);
                break;
            case WEST:
                toyRobot.setHeadDirection(Direction.NORTH);
                break;
            default:
                System.out.println(ErrorMessage.IGNORE_COMMAND_MESSAGE.getMessage());
                break;
        }
    }
}
