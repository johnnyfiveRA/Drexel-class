
package virginiacalls;

/**
 *
 * @author John White
 */

import java.util.Scanner;

public class VirginiaCalls 
{

    public static void main(String[] args) 
    {
        
        final double FIRST_MIN_RATE = 0.65; // initial minute rate
        final double CHARGES_AFTER = 0.50;
        
        /* if it's 1.15 for a 2 minute phone call with .50 being charged there after it is likely
         * the first minute rate is 0.65. Either way the math seems to work
         */ 
        
        Scanner input = new Scanner(System.in);
        double minutes;
        double charges;
        
        System.out.println("This program will help you understand the full cost of a long distance call to"
                + "XXX, Viginia");
        System.out.println("The first minute costs $1.15 and then the charges are $0.50 afterwards");
        System.out.println("Enter the predicted length of your phone call");
        minutes = input.nextDouble();
       
        charges = FIRST_MIN_RATE + ( (minutes - 1) * CHARGES_AFTER);
        
        System.out.println("Your total charges for your call will be $" + charges);
        
        // I could have put that on one line and saved the extra variable but honestly who wants to read that
    
    } // main over
    
} // end of class
