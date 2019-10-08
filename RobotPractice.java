
// Java program to demonstrate working of Robot 
// class. This program is for Windoes. It opens 
// a browser to the HPA url provided
// and begins to try to fulfill the page's requests. 
import java.awt.AWTException; 
import java.awt.Robot; 
import java.awt.event.KeyEvent; 
import java.awt.event.InputEvent;
import java.io.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException; 

        // delay to allow the browser to fully load
        //Then, the robot will begin to press keys and map over the elements of the page
        //first, the robot will focus on the first box on the screen, then, it will press the mouse and release.
        //After each box is complete, an alert needs time to load, so, add a delay long enough for that box to load.
        //This program stops at the first attempt of box 4 because it randomly generates a required output and because
        // I have yet to figure out how to access box 5 with just a keyboard.
        //More research would be fun but I've taken quite a few days with this project. Can't wait to learn MORE!!

public class RobotPractice 
{ 
    public static void main(String[] args) throws IOException, 
                           AWTException, InterruptedException 
    { 
        String url = "http://hpadevtest.azurewebsites.net/";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
  
        // Create an instance of Robot class 
        Robot robot = new Robot(); 
  
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_TAB); 
        Thread.sleep(500); 
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
    } 
} 