package app.robot.domain.command.impl;

import app.robot.constant.Direction;
import app.robot.domain.robot.ToyRobot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoveCommandTest {

    MoveCommand moveCommand;
    ToyRobot toyRobot1;
    ToyRobot toyRobot2;
    ToyRobot toyRobot3;
    ToyRobot toyRobot4;

    @Before
    public void setUp() { prepareTestData(); }

    @Test
    public void testMoveCommand_Success() {

        ToyRobot toyRobot = new ToyRobot(0,0, Direction.NORTH);
        RightCommand rightCommand = new RightCommand(toyRobot);

        moveCommand = new MoveCommand(toyRobot,5,5);

        moveCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot1);
        moveCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot2);
        rightCommand.execute();
        moveCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot3);
        moveCommand.execute();
        Assert.assertEquals(toyRobot, toyRobot4);
    }

    private void prepareTestData() {
        toyRobot1 = new ToyRobot(0,1,Direction.NORTH);
        toyRobot2 = new ToyRobot(0,2,Direction.NORTH);
        toyRobot3 = new ToyRobot(1,2,Direction.EAST);
        toyRobot4 = new ToyRobot(2,2,Direction.EAST);
    }

}
