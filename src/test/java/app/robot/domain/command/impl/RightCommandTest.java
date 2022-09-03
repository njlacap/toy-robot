package app.robot.domain.command.impl;

import app.robot.constant.Direction;
import app.robot.domain.robot.ToyRobot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RightCommandTest {

    RightCommand rightCommand;
    ToyRobot toyRobot1;
    ToyRobot toyRobot2;
    ToyRobot toyRobot3;
    ToyRobot toyRobot4;

    @Before
    public void setUp() {
        prepareTestData();
    }

    @Test
    public void testRightCommand_Success() {

        ToyRobot toyRobot = new ToyRobot(5,5, Direction.NORTH);

        rightCommand = new RightCommand(toyRobot);

        rightCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot2);
        rightCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot3);
        rightCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot4);
        rightCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot1);
    }

    private void prepareTestData() {
        toyRobot1 = new ToyRobot(5,5,Direction.NORTH);
        toyRobot2 = new ToyRobot(5,5,Direction.EAST);
        toyRobot3 = new ToyRobot(5,5,Direction.SOUTH);
        toyRobot4 = new ToyRobot(5,5,Direction.WEST);
    }
}
