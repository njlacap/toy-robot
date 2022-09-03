package app.robot.constant;

public enum ErrorMessage {
    FALLOUT_MESSAGE("Your robot fell out of the table, place again"),
    IGNORE_COMMAND_MESSAGE("Ignoring command"),
    TOY_ROBOT_MESSAGE("No toy robot available, place a robot");

    private final String message;
    ErrorMessage(String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}
