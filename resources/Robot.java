package RCRobotsImpl.resources;

import java.util.HashMap;
import java.util.Map;

public class Robot {

    private final Map<String, Integer> DIRECTIONS = new HashMap<>() {{
        put("N", 0);
        put("E", 1);
        put("S", 2);
        put("W", 3);
    }};

    private Warehouse warehouse;
    private int xCoord = 0;
    private int yCoord = 0;
    private int currentDirection = 0;

    public Robot(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Robot(Warehouse warehouse, int xCoord, int yCoord) {
        this(warehouse);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Robot(Warehouse warehouse, String currentDirection) {
        this(warehouse);
        this.currentDirection = DIRECTIONS.get(currentDirection);
    }

    public Robot(Warehouse warehouse, int xCoord, int yCoord, String currentDirection) {
        this(warehouse, xCoord, yCoord);
        this.currentDirection = DIRECTIONS.get(currentDirection);
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public int getCurrentX() {
        return xCoord;
    }

    public int getCurrentY() {
        return yCoord;
    }

    public String getCurrentDirection() {
        for(Map.Entry<String, Integer> entry: DIRECTIONS.entrySet())
            if(entry.getValue() == currentDirection)
                return entry.getKey();
        return "";
    }

    public void runCommands(String commands) {
        for (String command : commands.split("")) {
            if (command.equalsIgnoreCase("R")) {
                moveRight();
            } else if (command.equalsIgnoreCase("L")) {
                moveLeft();
            } else if (command.equalsIgnoreCase("M")) {
                moveForward();
            }
        }
    }

    public void moveRight() {
        currentDirection = currentDirection + 1 > 3 ? 0 : currentDirection + 1;
    }

    public void moveLeft() {
        currentDirection = currentDirection - 1 < 0 ? 3 : currentDirection - 1;
    }

    public void moveForward() {
        if (currentDirection == 0) {
            yCoord = yCoord + 1 > warehouse.getMaximumY() ? warehouse.getMaximumY() : yCoord + 1;
        } else if (currentDirection == 1) {
            xCoord = xCoord + 1 > warehouse.getMaximumX() ? warehouse.getMaximumX() : xCoord + 1;
        } else if (currentDirection == 2) {
            yCoord = yCoord - 1 < 0 ? 0 : yCoord - 1;
        } else if (currentDirection == 3) {
            xCoord = xCoord - 1 < 0 ? 0 : xCoord - 1;
        }
    }

}