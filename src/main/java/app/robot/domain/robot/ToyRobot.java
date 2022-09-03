package app.robot.domain.robot;

import app.robot.constant.Direction;
import app.robot.utility.ToyRobotUtil;

import java.util.Objects;

public class ToyRobot{

    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private Direction headDirection;

    public ToyRobot(int xCoordinate, int yCoordinate, Direction headDirection) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.headDirection = headDirection;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public Direction getHeadDirection() {
        return headDirection;
    }

    public void setHeadDirection(Direction headDirection) {
        this.headDirection = headDirection;
    }

    public void increaseXPosition() {
        xCoordinate++;
    }

    public void increaseYPosition() {
        yCoordinate++;
    }

    public void decreaseXPosition() {
        xCoordinate--;
    }

    public void decreaseYPosition() {
        yCoordinate--;
    }

    public boolean compareCoordinates(int toyRobotX, int toyRobotY) {
        return ToyRobotUtil.isColliding(xCoordinate,yCoordinate,toyRobotX,toyRobotY);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s",xCoordinate,yCoordinate, headDirection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToyRobot toyRobot = (ToyRobot) o;
        return xCoordinate == toyRobot.xCoordinate && yCoordinate == toyRobot.yCoordinate && headDirection.equals(toyRobot.headDirection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, headDirection);
    }
}
