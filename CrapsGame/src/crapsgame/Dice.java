package crapsgame;

/**
 *
 * @author John White
 * @comment might have gone a little over board on the OOP for this but it seemed like a good idea
 */

import java.util.Random;

public class Dice
{
    private Random dice; // this is the part of the dice that counts once it's rolled
    private int lastRoll=0;
    public Dice() 
    {
        // the default constructor is overridden to initialize the random number generator
        dice = new Random(); 
    }
    
    public int diceRoll()
    {
        lastRoll = dice.nextInt(6)+ 1;
        return lastRoll;
    }
    
    public int getLastRoll()
    {
        return lastRoll;
    }
}
