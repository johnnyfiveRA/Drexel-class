/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week02drawpanel;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 *
 * @author John
 */
public class DrawPanel extends JPanel
{
   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);
       int width;
       int height;
       width = getWidth();
       height = getHeight();
       
       g.setColor(Color.RED);
       g.drawLine(0,0, width, height); // draws a line within the panel diagonally across
       g.setColor(Color.BLUE);
       g.drawLine(0, height, width, 0);
       
   }
    
    
}
