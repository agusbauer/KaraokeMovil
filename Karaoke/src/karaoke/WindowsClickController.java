/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agustin
 */
public class WindowsClickController implements Runnable{
    
    public WindowsClickController() {
        
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ButtonsDisableController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            click(1,1);
        } catch (AWTException ex) {
            Logger.getLogger(WindowsClickController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void click(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);    
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
         System.out.println("clickkkk");
    }
}
