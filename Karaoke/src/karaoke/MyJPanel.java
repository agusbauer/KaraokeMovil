/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Agustin
 */
public class MyJPanel extends JPanel {
    
     Image bgimage;
        
    
    public MyJPanel(){
       URL imageURL = getClass().getResource("Karaoke.png");
        if (imageURL == null) {
           try {
               throw new FileNotFoundException();
           } catch (FileNotFoundException ex) {
               Logger.getLogger(MyJPanel.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
         try {
             this.bgimage = ImageIO.read(imageURL);
         } catch (IOException ex) {
             Logger.getLogger(MyJPanel.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgimage, 0, 0, getWidth(), getHeight(), this);
    }
}
