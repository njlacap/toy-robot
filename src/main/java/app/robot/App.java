package app.robot;

import app.robot.service.Simulation;
import app.robot.utility.CommandUtil;

import java.util.Scanner;
import java.util.stream.Stream;

public class App {
    public static void main( String[] args ) {
        int[] tableSize = new int[2];
        boolean onSetting = true;

        System.out.println("To start the simulation, enter the size of the table \"5,5\": ");

        Scanner scanner = new Scanner(System.in);
        while (onSetting && scanner.hasNext()) {
            String sizeCommand = scanner.nextLine();
            if(CommandUtil.isValidSizeCommand(sizeCommand)) {
                tableSize = Stream.of(sizeCommand.split(",")).mapToInt(Integer::parseInt).toArray();
                onSetting = false;
            } else {
                System.out.println("Input a valid size e.g. \"5,5\"");
            }
        }
        System.out.println(String.format("%n%s {%s,%s}%n","Size set to",tableSize[0],tableSize[1]));
        new Simulation(tableSize[0],tableSize[1]).simulate();
    }
}
