
package tranglecli;

/**
 *
 * @author John White
 */

import java.util.Scanner;

public class TrangleCli 
{

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        int inside1, inside2, inside3;
        
        System.out.println("This program takes the lengths of each side of a triangle and determines whether the triangle is a right triangle or not.");
        System.out.println("Please input each number and then press enter");
        inside1 = input.nextInt();
        
        System.out.println("Enter the second side's length");
        inside2 = input.nextInt();
        
        System.out.println("Enter the third side's length");
        inside3 = input.nextInt();
        
        Triangle theOne = new Triangle(inside1, inside2, inside3);
        
        if (theOne.getIsRight())
        {
            System.out.println("The sides of the triangle you gave me make up a right triangle.");
        }
        else
        {
            System.out.println("The sides do not make up a right triangle.");
        }
        
    }
}
