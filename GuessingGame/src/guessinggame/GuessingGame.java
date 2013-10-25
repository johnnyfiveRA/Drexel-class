package guessinggame;

/**
 *
 * @author John White 
 */

import java.util.Random;
import java.util.Scanner;

public class GuessingGame 
{    
    public static void main(String[] args) 
    {
        Random generator = new Random();
        Scanner input = new Scanner(System.in);
        
        int guessMe = generator.nextInt(100) + 1;
        int userGuess=0;
        
        System.out.println("I have guessed a whole number between  and 100");
        System.out.println("If you guess it I will say something nice\n");
        
        while (userGuess != guessMe) // runs until users guesses the right number
        {
            System.out.print("Enter your Guess... ");
            userGuess = input.nextInt();
            
            if (userGuess < guessMe)
            {
                System.out.println("\nThe number I'm thinking of is larger\n");
            }
            else if (userGuess > guessMe)
            {
                System.out.println("\nThe number I'm thinking of is smaller\n");
            }
            else // the only other possibility is that the user has guess the right number 
            {
                System.out.println("You guessed the right number. You are also pleasing to look at");
            }
            
        } // end of while loop for guesses
    
    }// end of the main method
        
} // end of the class

