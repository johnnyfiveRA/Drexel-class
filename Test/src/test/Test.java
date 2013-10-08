/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author John
 */


public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int number = 25;
        while (number >=10)
        {
            System.out.println("Square root is" + Math.sqrt(number));
            number-=5;
        }
        
        System.out.print("Enter a positive integer: ");
        
        Scanner reader = new Scanner(System.in);
        
        int a =5;
        int b =a;
        int c = b;
        
        if ( a == b == c )
        {
            
        }
        int n = reader.nextInt();

        int limit = n / 2;

        for (int d = 2; d <= limit; d++){
            if (n % d == 0)
            System.out.print (d + " ");
        }
        
        
    }
}
