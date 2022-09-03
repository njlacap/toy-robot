package app.robot.domain.command;

import app.robot.domain.robot.ToyRobot;

public abstract class ToyCommand {
    public abstract void execute() throws Exception;

    public void report(ToyRobot toyRobot) {
        System.out.println(toyRobot);
    }
}
