package utility;

import java.awt.*;
import java.awt.event.KeyEvent;


public class KeyUtil {
    public static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    public static void pressEnterKey(){
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static  void pressTab() {
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

    }
}
