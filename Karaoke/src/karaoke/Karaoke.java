/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


    
/**
 *
 * @author Agustin
 */
public class Karaoke implements KeyListener {

    public static KaraokeGui karaokeGui;
    String pathsFromFile;
    private int selection = 1;
    private boolean canSelect = true;
    public ConfigController config;
    public static String exe1Path, exe2Path, exe3Path;
    private Thread thread;
    Process p;
   // private String exe2 = "C:\\Users\\Agustin\\Desktop\\marduk64.exe";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Karaoke karaoke = new Karaoke();
        } catch (IOException ex) {
            Logger.getLogger(Karaoke.class.getName()).log(Level.SEVERE, null, ex);
        }
        readFile();
        System.out.println(exe1Path);
        System.out.println(exe2Path);
        System.out.println(exe3Path);
    }
    
    public static void readFile(){
        try {
            FileReader fr = new FileReader("karaokeFile.txt");
            BufferedReader br = new BufferedReader(fr);
            exe1Path = br.readLine();
            exe2Path = br.readLine();
            exe3Path = br.readLine();
            br.close();
        } catch (FileNotFoundException ex) {
             new ConfigController();
        } catch (IOException ex) {
            Logger.getLogger(Karaoke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Karaoke() throws IOException{
        karaokeGui = new KaraokeGui();
        //karaokeGui.setActionListener(this);
        karaokeGui.setKeyListener(this);
        thread = new Thread (new ButtonsDisableController());
     
        karaokeGui.setVisible(true);
    }
    
  

    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keycode =  e.getKeyCode(); 
        if(keycode == KeyEvent.VK_RIGHT){
            selection++;
            if(selection > 3)
                selection = 1;
            karaokeGui.toggleVisiblePanels(selection);
        }
        if(keycode == KeyEvent.VK_LEFT){
            selection--;
            if(selection < 1)
                selection = 3;
            karaokeGui.toggleVisiblePanels(selection);
        }
        if((keycode == KeyEvent.VK_ENTER && p == null) || (keycode == KeyEvent.VK_ENTER && p != null && !p.isAlive())){
                System.out.println("enteer");
                switch(selection){
                    case 1:
                        System.out.println("karaoke");
                        try { 
                        //karaokeGui.rmKeyListener(this);
                        new Thread (new WindowsClickController()).start();
                        p = Runtime.getRuntime().exec(exe1Path);
                        //karaokeGui.setVisible(false);
                        
                       
                        //karaokeGui.setKeyListener(this);
                        //karaokeGui.setVisible(true);

                        } catch (IOException ex) {
                            Logger.getLogger(Karaoke.class.getName()).log(Level.SEVERE, null, ex);
                        } /*catch (InterruptedException ex) {
                            Logger.getLogger(Karaoke.class.getName()).log(Level.SEVERE, null, ex);
                        }*/
                        break;
                    case 2:
                        System.out.println("musica");
                        try { 
                       // karaokeGui.rmKeyListener(this);
                         new Thread (new WindowsClickController()).start();
                        p = Runtime.getRuntime().exec(exe2Path);
                        //karaokeGui.setVisible(false);
                       
                        //karaokeGui.setKeyListener(this);
                        //karaokeGui.setVisible(true);

                        } catch (IOException ex) {
                            Logger.getLogger(Karaoke.class.getName()).log(Level.SEVERE, null, ex);
                        } /*catch (InterruptedException ex) {
                            Logger.getLogger(Karaoke.class.getName()).log(Level.SEVERE, null, ex);
                        }*/
                        break;
                    case 3:
                        System.out.println("darlanota");
                        try { 
                        new Thread (new WindowsClickController()).start();
                        p = Runtime.getRuntime().exec(exe3Path);

                        } catch (IOException ex) {
                            Logger.getLogger(Karaoke.class.getName()).log(Level.SEVERE, null, ex);
                        }/* catch (InterruptedException ex) {
                            Logger.getLogger(Karaoke.class.getName()).log(Level.SEVERE, null, ex);
                        }*/
                        break;    
                }
               
                
         
        }
        if(keycode == KeyEvent.VK_C){
            new ConfigController();
        }
    }
    
   
    
}
