package navigation;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Robo {

    private Robot robot;

    private Robot robot() {

        if (robot == null) {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
        return robot;
    }

    public Robo copyPaste(String s) {

        sleep(500);
        StringSelection stringSelection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        robot().keyPress(KeyEvent.VK_CONTROL);
        type(KeyEvent.VK_V);
        robot().keyRelease(KeyEvent.VK_CONTROL);

        return this;
    }

    public Robo selectFile(String path, String fileName) {

        copyPaste(fileName);
        robot().keyPress(KeyEvent.VK_CONTROL);
        type(KeyEvent.VK_L);
        robot().keyRelease(KeyEvent.VK_CONTROL);
        copyPaste(path);
        type(KeyEvent.VK_ENTER);
        type(KeyEvent.VK_TAB);
        type(KeyEvent.VK_TAB);
        type(KeyEvent.VK_TAB);
        type(KeyEvent.VK_TAB);
        type(KeyEvent.VK_TAB);
        type(KeyEvent.VK_TAB);
        type(KeyEvent.VK_TAB);
        type(KeyEvent.VK_TAB);
        type(KeyEvent.VK_ENTER);

        return this;
    }

    public Robo type(String s) {

        byte[] bytes = s.getBytes();

        for (byte b : bytes) {
            int code = b;

            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) {
                code = code - 32;
                type(code);
            } else if (code > 64 && code < 91) {
                type(KeyEvent.VK_CAPS_LOCK);
                type(code);
                type(KeyEvent.VK_CAPS_LOCK);
            } else
                type(code);
        }

        return this;
    }

    //	Function to type a integer
    public Robo type(int i) {

        sleep(500);
        robot.keyPress(i);
        robot.keyRelease(i);

        return this;
    }

    //	Function to type a special character like ^,% etc
    public Robo typeSpChar(int i) {

        robot().keyPress(KeyEvent.VK_SHIFT);
        type(i);
        robot().keyRelease(KeyEvent.VK_SHIFT);

        return this;
    }

    private void sleep(long ms) {

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
