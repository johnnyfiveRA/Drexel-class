/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtw54week02shapes;

/**
 *
 * @author jtw54 Source material is taken from Deitel's 
 * How to Program 9th edition pages 184 - 186
 */

import javax.swing.JPanel;
import java.awt.Graphics;
        
public class Shapes extends JPanel
{
    private int choice;
    
    public Shapes (int userChoice)
    {
        choice = userChoice;
    } // end of constructor
    
   
    @Override public void paintComponent( Graphics g)
    {
        
        super.paintComponent(g); 
        // I see... we are overriding the paintComponent function within JComponent
        // which Jpanel inherits this function from
        //that way this function runs instead. tricky haven't used this before
        // it explains something I saw in Android development
        
        for (int i = 0; i < 10; i++)
       {
           // ah the switch statement. Typing if statements is just weird
           switch (choice)
           {
               case 1: // for rectangles
                   g.drawRect( 10 + i * 10, 10 + i * 10, 50+ i * 10, 50 + i * 10 );
                   break;
                   
               case 2: // for ovals
                   g.drawOval( 10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10 );
                   break;
               
               default: // why not?
                   g.draw3DRect(20 + i, 20 + i, 10 + i* 10, 10 + i * 10, true);
                   break;
           } // switch over
           
       } // for loop ends
        
    } // end of overridden function
    
} // class over
