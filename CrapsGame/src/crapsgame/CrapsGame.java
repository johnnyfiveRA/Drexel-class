/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crapsgame;

/**
 *
 * @author John White
 */

import java.util.Scanner;

public class CrapsGame {
    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("How many players are coming to the table?");
        CrapsAction theGame = new CrapsAction(input.nextInt());
        theGame.run();

    }
}
