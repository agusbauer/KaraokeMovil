/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agustin
 */
public class ButtonsDisableController implements Runnable{

    public ButtonsDisableController() {
    }

    @Override
    public void run() {
       // Karaoke.karaokeGui.getBtnDarLaNota().setEnabled(false);
       // Karaoke.karaokeGui.getBtnKaraoke().setEnabled(false);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ButtonsDisableController.class.getName()).log(Level.SEVERE, null, ex);
        }
       // Karaoke.karaokeGui.getBtnDarLaNota().setEnabled(true);
       // Karaoke.karaokeGui.getBtnKaraoke().setEnabled(true);
    }
    
}
