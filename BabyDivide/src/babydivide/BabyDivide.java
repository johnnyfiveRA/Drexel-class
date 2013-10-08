package babydivide;

/**
 *
 * @author John White
 */

import java.util.Scanner;

public class BabyDivide {

    public static void main(String[] args) {
        // TODO code application logic here
        int firstNum;
        int secondNum; // both are set to not zero so that loop will run at least once
        
        // this will 
        Scanner input = new Scanner(System.in);
        
        System.out.println("This program divides two whole numbers like a child would");
        System.out.println("The largest number will be the divisor regardless of "
                + "order they are entered. Enter zero for either number to quit");
        
        System.out.println("Enter a whole number");
        firstNum = input.nextInt();
        
        System.out.println("\nEnter another whole number");
        secondNum = input.nextInt();
        
        while (!(firstNum == 0 || secondNum==0))
        {
            // the largest of the two numbers will be the dividend and the small is the divisor
        
            if (firstNum > secondNum) // if firstNum is bigger it is the dividend
            {
                System.out.println("\nThe result is " + firstNum/secondNum + " remainder " + firstNum%secondNum);
            }
        
            else if (firstNum < secondNum) // if secondNum is bigger then it is the dividend
            {
                System.out.println("\nThe result is " + secondNum/firstNum + " remainder " + secondNum%firstNum);
            }
        
            else // otherwise the remainder is zero. Might be an extra logic step but it's clear
            {
                System.out.println("\nThe result is " + secondNum/firstNum + " remainder " + secondNum%firstNum);
            } // obviously the order of the dividend or divisor is irrelevant here
            
            System.out.println("\nEnter another number to continue.");
            firstNum = input.nextInt();
        
            System.out.println("\nEnter another number to continue. Zero to quit.\n");
            secondNum = input.nextInt();
            
        } // end while
        
    }
}
