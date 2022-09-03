package app.robot.utility;

public class CommandUtil {
    private static final String PLACE_COMMAND_REGEX = "^(PLACE)\\s\\d+,\\d+,(NORTH|WEST|EAST|SOUTH)$";
    private static final String GENERAL_COMMAND_REGEX = "^(MOVE|REPORT|LEFT|RIGHT)$";
    private static final String SIZE_COMMAND_REGEX = "^\\d+,\\d+$";


    /**
     * Regex checker for place command
     * @param command command from user input
     * @return boolean true if valid else false
     */
    public static boolean isValidPlaceCommand(String command) {
        return command.matches(PLACE_COMMAND_REGEX);
    }

    /**
     * Regex checker for general command
     * @param command command from user input
     * @return boolean true if valid else false
     */
    public static boolean isValidGeneralCommand(String command) {
        return command.matches(GENERAL_COMMAND_REGEX);
    }

    /**
     * Regex checker for size command
     * @param command command from user input
     * @return boolean true if valid else false
     */
    public static boolean isValidSizeCommand(String command) {
        return command.matches(SIZE_COMMAND_REGEX);
    }

}
