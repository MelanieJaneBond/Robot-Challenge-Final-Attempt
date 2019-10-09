// this is a Java program to demonstrate the working of Robot class. This program opens a browser to the HPA url provided
// and begins to try to fulfill the page's requests. I made many attempts at this as I learned about Java and Robots,
// this is the final draft of that journey's lessons.
import java.awt.AWTException; 
import java.awt.Robot; 
import java.awt.event.KeyEvent; 
import java.awt.event.InputEvent;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException; 

public class RobotPractice 
{ 
    public static void main(String[] args) throws IOException, 
                           AWTException, InterruptedException 
    { 
        //This section of code instructs the program to open a browser and navigate to a specific page.
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
  
        robot.delay(1000);
        // delay to allow the browser to fully load
        //Then, the robot will begin to press keys and map over the elements of the page
        //first, the robot will focus on the first box on the screen, then, it will press the mouse and release.
        robot.keyPress(KeyEvent.VK_TAB); 
        Thread.sleep(500); 
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //After each box is complete, an alert needs time to load, so, add a delay long enough for that box to load.
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
        // robot.keyPress(KeyEvent.VK_DOWN);
        // robot.keyPress(KeyEvent.VK_DOWN);
    } 
} 
//This program worked THROUGH step 3 when I first wrote it yesterday, but, some error that I cannot find must have appeared because
// it now stops after the first box.
    // I have yet to figure out how to access box 5 with just a keyboard. A friend of mine who has worked in Java for years
    // gave me a tip to check out "set x" but I'll research it later today and go ahead and turn in what I've done so far.
//Aside from what I learned in order to fulfill just the challenge requirements that got me to this point of code-creation, I studied
// Robotic Process Automation until I was comfortable with what it really does and how, I learned how to download and start running Java
// on my machine, and, I also learned that YouTube is a comforting source for a dev who does not have access to a friend who knows the language.
// My Java-fluent buddy happened to be on a vacation in Hawaii this week, and, my school mates are Python and C# people.
// Anyway, I used a lot of online documentation that I found by googling key words and tracing patterns in what other people had asked regarding
// the same topics. I wish I could keep this for a month and learn more, but, since it was asked that I turn it in soon, here I am sending it!

