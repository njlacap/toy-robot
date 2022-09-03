package app.robot.domain.command.impl;

import app.robot.constant.Direction;
import app.robot.domain.robot.ToyRobot;
import app.robot.exception.PlaceCommandException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PlaceCommandTest {

    PlaceCommand placeCommand;
    ToyRobot toyRobot1;

    @Before
    public void setUp() { prepareTestData(); }

    @Test
    public void testPlaceCommand_Success() {

        Map<Integer,ToyRobot> toyRobotMap = new HashMap<>();
        placeCommand = new PlaceCommand("PLACE 0,0,NORTH", 5,5,toyRobotMap);
        ToyRobot toyRobot = placeCommand.createRobot();

        Assert.assertEquals(toyRobot,toyRobot1);
    }

    @Test
    public void testPlaceCommand_Failed() {

        Map<Integer,ToyRobot> toyRobotMap = new HashMap<>();
        placeCommand = new PlaceCommand("PLACE 6,0,NORTH", 5,5,toyRobotMap);

        Assert.assertThrows(PlaceCommandException.class,() -> placeCommand.execute());
    }

    private void prepareTestData() {
        toyRobot1 = new ToyRobot(0,0,Direction.NORTH);
    }
}
