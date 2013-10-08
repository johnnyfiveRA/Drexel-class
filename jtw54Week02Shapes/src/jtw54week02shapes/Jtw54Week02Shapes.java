/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtw54week02shapes;

/**
 *
 * @author Jtw54 program is composed from some source material found on pages
 * 184 -186 of Deitel's How to Program 9th edition
 */

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Jtw54Week02Shapes 
{

    public static void main(String[] args) 
    {
        int userchoice;
        boolean numValid; // sentinel value
        
        do // some input validation when a good number is input the loop ends.
        {  // otherwise the user is pestered to read the instructions unless they cancel the input
            
            userchoice = Integer.parseInt(JOptionPane.showInputDialog("Invalid numbers will make this dialog pop up again\n\n" + "Enter 1 to draw rectangles\n" + "Enter 2 to draw ovals"));
            
            switch (userchoice) 
            {
                case 1:  // switches fall through so being that in my case 
                case 2:  // 1-3 are valid numbers I only need to use the 
                case 3:  // sentinel setting statement once for a valid number
                    numValid = true;
                    break;
                    
                default:
                    numValid = false;
            }
        } while (!numValid); 
        
        Shapes panel = new Shapes (userchoice);
        
        JFrame window = new JFrame();
        
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        window.add( panel);
        window.setSize( 300, 300);
        window.setVisible(true);
    } // main over
    
} // class complete
