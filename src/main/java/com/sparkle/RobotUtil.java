package com.sparkle;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotUtil {
    static Robot robot;
    static int count;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendKey(String s) {
        if (count == 0) {
            System.out.println("自动扣字机将于3000毫秒后启动");
            robot.delay(3000);
        }
        int[] codes = getKeyCodeArray(s);
        for (int i = 0; i < codes.length; i++) {
            if (s.charAt(i) == ' ') {
                choose();
            }
            int code = codes[i];
            robot.keyPress(code);
            robot.delay(RandomUtils.nextInt(10, 30));
            robot.keyRelease(code);
        }
        choose();
        newLine();
        count++;
    }


    private static int[] getKeyCodeArray(String s) {
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.toCharArray().length; i++) {
//            String s1 = "" + s.charAt(i);
            int code = KeyEvent.getExtendedKeyCodeForChar(s.charAt(i));
            ans[i] = code;
        }
        return ans;
    }

    public static void newLine() {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(RandomUtils.nextInt(4, 13));
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void choose() {
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(RandomUtils.nextInt(4, 13));
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.delay(RandomUtils.nextInt(8, 18));
    }
}
