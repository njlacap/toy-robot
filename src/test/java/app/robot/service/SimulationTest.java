package app.robot.service;

import app.robot.constant.ErrorMessage;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class SimulationTest {

    Simulation simulation;
    private final InputStream sysInOriginal = System.in;
    private final PrintStream sysOutOriginal = System.out;
    private final ByteOutputStream byteOutputStream = new ByteOutputStream();


    @Before
    public void setUp() {
        System.setOut(new PrintStream(byteOutputStream,true));
    }

    @Test
    public void testSimulation_PlaceReport_Success() {
        simulation = new Simulation(5,5);
        inputPlaceReport();
        simulation.simulate();
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals("0,0,NORTH",result[1]);
    }

    @Test
    public void testSimulation_PlaceMoveReport_Success() {
        simulation = new Simulation(5,5);
        inputPlaceMoveReport();
        simulation.simulate();
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals("0,1,NORTH",result[1]);
    }

    @Test
    public void testSimulation_PlaceMoveTurnLeftReport_Success() {
        simulation = new Simulation(5,5);
        inputPlaceMoveLeftReport();
        simulation.simulate();
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals("0,1,WEST",result[1]);
    }

    @Test
    public void testSimulation_PlaceMoveTurnRightReport_Success() {
        simulation = new Simulation(5,5);
        inputPlaceMoveRightReport();
        simulation.simulate();
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals("0,1,EAST",result[1]);
    }

    @Test
    public void testSimulation_Place_OutOfBounds() {
        simulation = new Simulation(5,5);
        inputPlaceFall();
        simulation.simulate();
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals(ErrorMessage.FALLOUT_MESSAGE.getMessage(),result[1]);
    }

    @Test
    public void testSimulation_Move_NoRobot() {
        simulation = new Simulation(5,5);
        inputNoRobot();
        simulation.simulate();
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals(ErrorMessage.TOY_ROBOT_MESSAGE.getMessage(),result[1]);
    }

    @Test
    public void testSimulation_Move_Beyond() {
        simulation = new Simulation(5,5);
        inputMoveBeyond();
        simulation.simulate();
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals(ErrorMessage.IGNORE_COMMAND_MESSAGE.getMessage(),result[1]);
    }

    @Test
    public void testSimulation_Invalid_Command() {
        simulation = new Simulation(5,5);
        inputInvalidCommand();
        simulation.simulate();
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals(ErrorMessage.IGNORE_COMMAND_MESSAGE.getMessage(),result[1]);
    }


    private void inputPlaceReport() {
        System.setIn(testCommandPlaceReport());
    }

    private void inputPlaceMoveReport() {
        System.setIn(testCommandPlaceMoveReport());
    }

    private void inputPlaceMoveLeftReport() {
        System.setIn(testCommandPlaceMoveLeftReport());
    }

    private void inputPlaceMoveRightReport() {
        System.setIn(testCommandPlaceMoveRightReport());
    }

    private void inputPlaceFall() {
        System.setIn(testCommandPlaceFall());
    }

    private void inputNoRobot() {
        System.setIn(testNoRobot());
    }

    private void inputMoveBeyond() {
        System.setIn(testMoveBeyond());
    }

    private void inputInvalidCommand() {
        System.setIn(testInvalidCommand());
    }

    private String output() {
        return byteOutputStream.toString();
    }

    private ByteArrayInputStream testCommandPlaceReport() {
        return command(String.format("%s%n%s","PLACE 0,0,NORTH","REPORT"));
    }

    private ByteArrayInputStream testCommandPlaceMoveReport() {
        return command(String.format("%s%n%s%n%s","PLACE 0,0,NORTH","MOVE","REPORT"));
    }

    private ByteArrayInputStream testCommandPlaceMoveLeftReport() {
        return command(String.format("%s%n%s%n%s%n%s","PLACE 0,0,NORTH","MOVE","LEFT","REPORT"));
    }

    private ByteArrayInputStream testCommandPlaceMoveRightReport() {
        return command(String.format("%s%n%s%n%s%n%s","PLACE 0,0,NORTH","MOVE","RIGHT","REPORT"));
    }

    private ByteArrayInputStream testCommandPlaceFall() {
        return command("PLACE 6,6,NORTH");
    }

    private ByteArrayInputStream testNoRobot() {
        return command("MOVE");
    }

    private ByteArrayInputStream testMoveBeyond() {
        return command(String.format("%s%n%s%n%s","PLACE 0,0,NORTH","LEFT","MOVE"));
    }

    private ByteArrayInputStream testInvalidCommand() {
        return command("UNKNOWN COMMAND");
    }

    private ByteArrayInputStream command(String command) {
        return new ByteArrayInputStream(command.getBytes());
    }

    @After
    public void tearDown() {
        System.setIn(sysInOriginal);
        System.setOut(sysOutOriginal);
    }
}
