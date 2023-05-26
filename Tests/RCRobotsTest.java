package RCRobotsImpl.Tests;

import RCRobotsImpl.resources.Robot;
import RCRobotsImpl.resources.Warehouse;
import org.junit.Assert;
import org.junit.Test;

public class RCRobotsTest {
    @Test
    public void shouldReturn34E_whenCommandIsMMRMMLMMR() {
        int maximumX = 5;
        int maximumY = 5;
        int xCoord = 1;
        int yCoord = 0;
        Warehouse warehouse = new Warehouse(maximumX, maximumY);
        Robot robot = new Robot( warehouse, xCoord, yCoord, "N");
        robot.runCommands("MMRMMLMMR");
        Assert.assertEquals(3, robot.getCurrentX());
        Assert.assertEquals(4, robot.getCurrentY());
        Assert.assertEquals("E", robot.getCurrentDirection());
    }

    @Test
    public void shouldReturn24N_whenCommandIsMLLMMRMM() {
        int maximumX = 5;
        int maximumY = 5;
        int xCoord = 3;
        int yCoord = 2;
        Warehouse warehouse = new Warehouse(maximumX, maximumY);
        Robot robot = new Robot( warehouse, xCoord, yCoord, "E");
        robot.runCommands("MLLMMRMM");
        Assert.assertEquals(2, robot.getCurrentX());
        Assert.assertEquals(4, robot.getCurrentY());
        Assert.assertEquals("N", robot.getCurrentDirection());
    }




}
