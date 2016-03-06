/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agustin
 */
public class ConfigController implements ActionListener {

    private final ConfigGui configGui;
    private String exe1toSave = "";
    private String exe2toSave = "";
    
    public ConfigController() {
        configGui = new ConfigGui();
        configGui.setActionListener(this);
        configGui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(configGui.getBtnOk())) {
            FileWriter fw = null;
            exe1toSave = configGui.getjTextField1().getText().replaceAll("\\s+","");
            exe2toSave = configGui.getjTextField2().getText().replaceAll("\\s+","");       
            try {
                fw = new FileWriter("karaokeFile.txt");
            } catch (IOException ex) {
                Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
            }
            PrintWriter pw = new PrintWriter(fw);
            pw.println(exe1toSave);
            pw.println(exe2toSave);
            pw.close();
            Karaoke.readFile();
            configGui.dispose();
        }
    }
    
}
