package RCRobotsImpl.resources;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Warehouse warehouse = null;
        List<Robot> robotList = new ArrayList<>();

        if (sc.hasNextLine()) {
            String[] lineArray = sc.nextLine().split(" ");
            warehouse = new Warehouse(Integer.parseInt(lineArray[0]), Integer.parseInt(lineArray[1]));
        }

        boolean isOccupied = false;
        Robot robot = null;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty())
                break;
            if (!isOccupied) {
                String[] lineArray = line.split(" ");
                robot = new Robot(warehouse, Integer.parseInt(lineArray[0]),  Integer.parseInt(lineArray[1]), lineArray[2]);
                isOccupied = true;
            } else {
                robot.runCommands(line);
                robotList.add(robot);
                isOccupied = false;
            }
        }

        for (Robot robotResult : robotList) {
            System.out.println(robotResult.getCurrentX() + " " + robotResult.getCurrentY() + " " + robotResult.getCurrentDirection());
        }
    }

}