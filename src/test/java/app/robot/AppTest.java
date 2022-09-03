package app.robot;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class AppTest {

    private final InputStream sysInOriginal = System.in;
    private final PrintStream sysOutOriginal = System.out;
    private final ByteOutputStream byteOutputStream = new ByteOutputStream();


    @Before
    public void setUp() {
        System.setOut(new PrintStream(byteOutputStream,true));
    }

    @Test
    public void testInitialization_SizeCommand_Success() {
        inputSizeCommand();
        App.main(null);
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals("Size set to {5,5}",result[2]);
    }

    @Test
    public void testInitialization_SizeCommand_Failed() {
        inputSizeCommandInvalid();
        App.main(null);
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals("Input a valid size e.g. \"5,5\"",result[1]);
    }

    @Test
    public void testInitialization_InvalidSizeCommand() {
        inputSizeCommandNonDigit();
        App.main(null);
        String[] result = output().split(System.lineSeparator());

        Assert.assertEquals("Input a valid size e.g. \"5,5\"",result[1]);
    }


    private void inputSizeCommand() { System.setIn(testCommandSize()); }

    private void inputSizeCommandInvalid() {
        System.setIn(testCommandSizeInvalid());
    }

    private void inputSizeCommandNonDigit() {
        System.setIn(testCommandSizeNonDigit());
    }

    private String output() {
        return byteOutputStream.toString();
    }

    private ByteArrayInputStream testCommandSize() { return command("5,5"+System.lineSeparator()); }

    private ByteArrayInputStream testCommandSizeInvalid() {
        return command("5");
    }

    private ByteArrayInputStream testCommandSizeNonDigit() { return command("ABCdef"); }

    private ByteArrayInputStream command(String command) { return new ByteArrayInputStream(command.getBytes()); }

    @After
    public void tearDown() {
        System.setIn(sysInOriginal);
        System.setOut(sysOutOriginal);
    }

}
