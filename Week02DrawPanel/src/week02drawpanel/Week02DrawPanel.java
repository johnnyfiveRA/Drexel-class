/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package week02drawpanel;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author John White
 */
public class Week02DrawPanel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        DrawPanel dp = new DrawPanel();
        JFrame app = new JFrame();
        
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(dp);
        app.setSize(250,250);
        app.setVisible(true);        
        
        String showMe = "Enter 1 to draw a rectangle\n" + "Enter 2 to draw ovals";
        String input = JOptionPane.showInputDialog(showMe);
        
        int choice = Integer.parseInt(input);
        
    }
}
