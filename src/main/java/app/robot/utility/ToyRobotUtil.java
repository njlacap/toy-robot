package app.robot.utility;

public class ToyRobotUtil {

    /**
     * Checker for collision
     * @param firstX x of 1st toy robot
     * @param firstY y of 1st toy robot
     * @param secondX x of 2nd toy robot
     * @param secondY y of 2nd toy robot
     * @return true if same coordinates else false
     */
    public static boolean isColliding(int firstX, int firstY, int secondX, int secondY) {
        return (firstX == secondX && firstY == secondY);
    }
}
