package app.robot.domain.command.impl;

import app.robot.constant.Direction;
import app.robot.domain.robot.ToyRobot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LeftCommandTest {

    LeftCommand leftCommand;
    ToyRobot toyRobot1;
    ToyRobot toyRobot2;
    ToyRobot toyRobot3;
    ToyRobot toyRobot4;

    @Before
    public void setUp() {
        prepareTestData();
    }

    @Test
    public void testLeftCommand_Success() {

        ToyRobot toyRobot = new ToyRobot(5,5, Direction.NORTH);

        leftCommand = new LeftCommand(toyRobot);

        leftCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot2);
        leftCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot3);
        leftCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot4);
        leftCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot1);
    }

    private void prepareTestData() {
        toyRobot1 = new ToyRobot(5,5,Direction.NORTH);
        toyRobot2 = new ToyRobot(5,5,Direction.WEST);
        toyRobot3 = new ToyRobot(5,5,Direction.SOUTH);
        toyRobot4 = new ToyRobot(5,5,Direction.EAST);
    }

}
