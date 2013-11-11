
package crapsgame;

/**
 *
 * @author John White
 * So here's what here and here's what's not. 
 * First, Line Bets only
 * Second, no odds Bets right now 
 * Third, no multi-roll bets right now
 * Forth, no Big 6 or big 8 it's stupid and you're stupid if you want it.
 * Fifth, no place or Buy Bets (they're kinda similar to come anyway.)
 * Sixth, 2 and 12 field bets pay extra just like in real life. 
 *      -current rule is 2:1
 * Seventh, if you take money from the loan shark, you may get your legs broken
 * Eighth, You cannot load the dice. The computer is also perfectly fair.
 * Ninth, each player gets to roll the dice after each one has rolled the status
 *      -is displayed
 * The essence of the game is here but it is simplified.      
 */

import java.util.Scanner;
import java.util.ArrayList;

public class CrapsAction implements Runnable
{
    private static int numberOfPlayers;
    private int marker=0; // might want to move this into crapsplayer. 
    private final static int FIELD_2_12_ODDS = 2; 
    // yes I'm a meanie not paying 3:1 on 12 or 2
    // this is casino game not a charity
    
    // the following lists hold which players have active bets on each field
    private ArrayList <CrapsPlayer> passLine = new ArrayList<>();
    private ArrayList <CrapsPlayer> dontPass = new ArrayList<>();
    private ArrayList <CrapsPlayer> come  = new ArrayList<>();
    private ArrayList <CrapsPlayer> field  = new ArrayList<>();
    
    private Dice rolled1 = new Dice();
    private Dice rolled2 = new Dice();
    private boolean comeOutRoll = true;
    
    // System.getProperty("users.dir") + System.getProperty("file.seperator") +  put back if needed returned null when used
    
    // the following strings are for the various sounds and music played during the game
    private final static String BACKGROUND_MUSIC = "craps_back.mp3";
    private final static String DICE_ROLL_SOUND =  "craps_dice.mp3";
    private final static String LEGS_BROKE_SOUND = "craps_death.mp3";
    private final static String ROUND_SOUND = "craps_round.mp3";
            
    private ArrayList <CrapsPlayer> players = new ArrayList<>(); // this list holds all of the current players
    
    private static final Mp3Handler BACKGROUND = new Mp3Handler(BACKGROUND_MUSIC);
    private static final Mp3Handler DICE_ROLL = new Mp3Handler(DICE_ROLL_SOUND);
    private static final Mp3Handler LEGS_BROKE = new Mp3Handler(LEGS_BROKE_SOUND);
    private static final Mp3Handler ROUND_OVER = new Mp3Handler(ROUND_SOUND);
    
    public CrapsAction(int NumOfPlayers)
    {
        numberOfPlayers = NumOfPlayers;
        players.ensureCapacity(NumOfPlayers);
        for (int i =0; i < numberOfPlayers; i++)
        {
            System.out.print("For player " + (i+1) + " ");
            players.add(i, new CrapsPlayer(this.initializePlayer()));
        }
    }
    
    private void rollCrapsDice()
    {
        this.rolled1.diceRoll();
        this.rolled2.diceRoll();
    }
    
    private int getLastTotalRoll()
    {
        return ( rolled1.getLastRoll() + rolled2.getLastRoll() );
    }
    
    private void holdOn(int ms)
    {
        try {
            Thread.sleep(ms);
        }
        catch ( InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    private String initializePlayer()
    {
        Scanner reader = new Scanner(System.in);
		
		System.out.print("Enter the players name: ");
		return reader.nextLine();
    }
    
    private void placeBet(CrapsPlayer bettor)
    {  
        Scanner input = new Scanner(System.in);
        int selector=0;
        int amountHolder;
        System.out.println(bettor.getName() + " where would you like to place your bets");
        
        while (selector != 5) {
            if (selector !=0) 
            {
                System.out.println(bettor.getName() + " is still betting");
            }
        System.out.println("1: The Pass Line");
        System.out.println("2: The No Pass Bar");
        System.out.println("3: The Come Line");
        System.out.println("4: The Field");
        System.out.println("5: Done betting (no bet for this player for this round if selected first");
        
        System.out.println("Enter the corresponding number for where to place your bet");
        selector = input.nextInt();
        
        
            
            switch (selector) {
                case 1: if (passLine.contains(bettor) )
                        {
                            System.out.println("You already bet on this line.");
                            holdOn(1000);
                            break;
                        }
                        else { // if bettor has not place a bet on the line yet then
                            do
                            {
                                System.out.println("Amount of your bet?");
                                amountHolder = input.nextInt();
                                if (amountHolder <= bettor.getWallet())
                                {
                                    bettor.setPassBetAmount(amountHolder);
                                    amountHolder =0;
                                    passLine.add(bettor);
                                } 
                                else {
                                System.out.println("Not enough in you wallet to bet that much. " + bettor.getWallet() 
                                + " is in your wallet");   
                                }      
                            } while ( !(amountHolder <= bettor.getWallet() ) );
                        }
                        break;
            
                case 2: if (dontPass.contains(bettor) )
                        {
                            System.out.println("You already bet on this line.");
                            holdOn(1000);
                            break;
                        }
                        else{
                            do
                            {
                                System.out.println("Amount of your bet?");
                                amountHolder = input.nextInt();
                                if (amountHolder > bettor.getWallet())
                                {
                                    System.out.println("Not enough in you wallet to bet that much. " + bettor.getWallet() 
                                            + " is in your wallet");
                                }
                            } while ( !(amountHolder <= bettor.getWallet() ) );
                            bettor.setDontPassAmount(amountHolder);
                            amountHolder =0;
                            dontPass.add(bettor);
                        }
                        break;
                case 3: // only the come option is simulated right now. Just need to get this done for now 11/10
                        if (marker==0)
                        {
                            System.out.println("The dice is not in play for the come bet");
                            break;
                        }
                        /*I'm simplifying the craps come bets a little. A 
                         * Player can only have one on the table at a time. 
                         */
                        else if (come.contains(bettor))  
                        {                              
                            System.out.println("You already bet on this line.");
                            holdOn(1000);
                            break;
                        }
                        else 
                        {
                            do 
                            {
                            System.out.println("Amount of your bet?");
                            amountHolder = input.nextInt();
                            if (amountHolder > bettor.getWallet())
                            {
                                System.out.println("Not enough in you wallet to bet that much. " + bettor.getWallet() 
                                         + " is in your wallet");
                            }
                            } while ( !(amountHolder <= bettor.getWallet() ) );
                            bettor.setComeBetAmount(amountHolder);
                            amountHolder =0;
                            come.add(bettor);
                        }
                        break;
                
                case 4: if (field.contains(bettor) )
                        {
                            System.out.println("You already bet on this line.");
                            holdOn(1000);
                            break;
                        }
                        else {
                            do 
                            {
                            System.out.println("Amount of your bet?");
                            amountHolder = input.nextInt();
                            if (amountHolder > bettor.getWallet())
                                {
                                    System.out.println("Not enough in you wallet to bet that much. " + bettor.getWallet() 
                                            + " is in your wallet");
                                }
                            } while ( !(amountHolder <= bettor.getWallet() ) );
                            bettor.setFieldBetAmount(amountHolder);
                            amountHolder =0;
                            field.add(bettor);
                        }
                        break;
                                
                default: break;
            } // end of switch statement
        }
    } // end of placeBet

    private void fieldBetOutcome(CrapsPlayer thisGuy)
    {
            switch (this.getLastTotalRoll())
            { 
                case 2:  
                case 12: System.out.println(thisGuy.getName() + " won a field bet");
                        thisGuy.win(thisGuy.getFieldBetAmount());
                        thisGuy.addToWallet(thisGuy.getFieldBetAmount()); // this is too add the correct amount to the wallet for a 2 to 1 bet.
                        thisGuy.setFieldBetAmount(0);
                        break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 11: System.out.println(thisGuy.getName() + " won a field bet");
                         thisGuy.win(thisGuy.getFieldBetAmount());
                         thisGuy.setFieldBetAmount(0);
                         break;
                    
                default: System.out.println(thisGuy.getName() + " lost a field bet");
                         thisGuy.lose(thisGuy.getFieldBetAmount());
                         thisGuy.setFieldBetAmount(0);
            }
            // all actions completed now remove player from field bet list
            field.remove(thisGuy);
            
    } // end fieldBetoutcome run after every roll.
    
    private void checkComeBetOutcome(CrapsPlayer thisGuy)
    {
        if (thisGuy.getComeBetChoice() == this.getLastTotalRoll()) // it is imposssible to roll zero
        {
            System.out.println(thisGuy.getName() + " won a come bet");
            thisGuy.win(thisGuy.getComeBetAmount());
            thisGuy.setComeBetChoice(0);
            come.remove(thisGuy);
        }
        else if (thisGuy.getComeBetChoice() == 0 && 
        /* and dice roll totals 7 or 11 and */  (this.getLastTotalRoll() == 7 || this.getLastTotalRoll() == 11) )
        {
            System.out.println(thisGuy.getName() + " won a come bet");
            thisGuy.win(thisGuy.getComeBetAmount());
            thisGuy.setComeBetChoice(0);
            come.remove(thisGuy);
        }
        else if (thisGuy.getComeBetChoice() != 0 && 
        /* and dice roll totals 7 or 11 */  (this.getLastTotalRoll() == 7 || this.getLastTotalRoll() == 11) )
        {
            System.out.println(thisGuy.getName() + " lost a come bet");
            thisGuy.lose(thisGuy.getComeBetAmount());
            thisGuy.setComeBetChoice(0);
            come.remove(thisGuy);
        }
        else if (thisGuy.getComeBetChoice() == 0 && 
        /* and dice roll totals 2,3... */(this.getLastTotalRoll() == 2 || this.getLastTotalRoll() == 3
         /* or 12 */                        || this.getLastTotalRoll() == 12) )
        {
            System.out.println(thisGuy.getName() + " lost a come bet");
            thisGuy.lose(thisGuy.getComeBetAmount());
            thisGuy.setComeBetChoice(0);
            come.remove(thisGuy);
        }    
        else if (thisGuy.getComeBetChoice() == 0)
        {
            thisGuy.setComeBetChoice(this.marker); // 
        }
    } 
    /* end of comebet outcome check. 
     * this should be run after ever roll if the come bet list is not empty
    */
    private void passBetOutcome(CrapsPlayer thisGuy)
    {
        if (marker == 0 && comeOutRoll) // this means the last roll was a come out roll
        {
            switch (this.getLastTotalRoll()) {
                case 2:
                case 3:
                case 12:
                        System.out.println("Craps!" + thisGuy.getName() + " loses their pass bet");
                        thisGuy.lose(thisGuy.getPassBetAmount());
                        thisGuy.setPassBetAmount(0);
                        passLine.remove(thisGuy);
                        break;
                case 7:
                case 11:
                        System.out.println(thisGuy.getName() + " wins their pass bet");
                        thisGuy.win(thisGuy.getPassBetAmount());
                        thisGuy.setPassBetAmount(0);
                        passLine.remove(thisGuy);
                        break;
                default:
                        marker = getLastTotalRoll(); 
            } // end switch for come out roll
            
        } // end come out roll pass line bet routine
        
        else // if the marker has been moved that means that a come out roll happened
        {    // and that it was not 2,3,7,11, or 12 which means the marker should
             // be checked against the last roll this round. if the roll matches 
             // the marker the pass bet is payed out. if it's 7 the pass bet loses
            if (marker == this.getLastTotalRoll() && !comeOutRoll)
            {
                System.out.println(thisGuy.getName() + " wins their pass bet");
                        thisGuy.win(thisGuy.getPassBetAmount());
                        thisGuy.setPassBetAmount(0);
                        passLine.remove(thisGuy);
            }
            else if (this.getLastTotalRoll() == 7)
            {
                System.out.println(thisGuy.getName() + " loses their pass bet");
                        thisGuy.lose(thisGuy.getPassBetAmount());
                        thisGuy.setPassBetAmount(0);
                        passLine.remove(thisGuy);
            }
                
        } // end non-comeout roll routine
        
    } // end passbet outcome check
    
    private void dontPassBetOutcome(CrapsPlayer thisGuy)
    {
        if (marker == 0 && comeOutRoll) // this means the last roll was a come out roll
        {
            switch (this.getLastTotalRoll())
            {
                case 2:
                case 3:
                case 12:
                        System.out.println("Craps!" + thisGuy.getName() + " wins their Don't Pass bet");
                        thisGuy.win(thisGuy.getDontPassAmount());
                        thisGuy.setDontPassAmount(0);
                        dontPass.remove(thisGuy);
                        break;
                case 7:
                case 11:
                        System.out.println(thisGuy.getName() + " loses their Don't Pass bet");
                        thisGuy.lose(thisGuy.getDontPassAmount());
                        thisGuy.setDontPassAmount(0);
                        dontPass.remove(thisGuy);
                        break; 
            }
        } // end come out roll pass line bet routine
        
        else { // if the marker has been moved that means that a come out roll happened
               // and that it was not 2,3,7,11, or 12 which means the marker should
               // be checked against the last roll this round. if the roll matches 
               // the marker the pass bet is payed out and don't pass bets lose. 
               // if it's 7 the don't pass bet wins
            
            if (marker == this.getLastTotalRoll() && !comeOutRoll)
            {
                System.out.println(thisGuy.getName() + " loses their Don't Pass bet");
                        thisGuy.lose(thisGuy.getDontPassAmount());
                        thisGuy.setDontPassAmount(0);
                        dontPass.remove(thisGuy);
                        if(dontPass.isEmpty())
                            marker =0;
            }
            else if ( (marker !=0 && this.getLastTotalRoll() == 7) && !comeOutRoll)
            {
                System.out.println(thisGuy.getName() + " wins their Don't Pass bet");
                        thisGuy.win(thisGuy.getDontPassAmount());
                        thisGuy.setDontPassAmount(0);
                        dontPass.remove(thisGuy);
                        if(dontPass.isEmpty())
                            marker =0;
            }
                
        }
    } //end don't pass outcome check
    
    private void isOut(CrapsPlayer loser)
    {
        passLine.remove(loser);
        dontPass.remove(loser);
        come.remove(loser);
        field.remove(loser);
    }
    
    private boolean openBets(CrapsPlayer thisGuy)
    {
        if (passLine.contains(thisGuy))
            return true;
        else if (come.contains(thisGuy))
            return true;
        else if (field.contains(thisGuy))
            return true;
        else if (dontPass.contains(thisGuy))
            return true;
        else
            return false;
    }
    
    private void checkStatus(CrapsPlayer p)
    {
        if (openBets(p))
            return;
        
        String theChoice;
        Scanner input = new Scanner(System.in);
        
        if (p.getWallet() == 0 && p.getDebt() == 0) {
                    
               System.out.println(p.getName() + " has run out of money. Would you like to lose? Or....");
               System.out.println("get a $1000 loan from a large Italian man of questionable repute?");
               System.out.println("Type \"I suck\" to lose or \"Loan\" to continue");
               theChoice = input.nextLine();
               if (theChoice.equalsIgnoreCase("I suck"))
               {
                   System.out.println(p.getName() + " is out");
                   players.remove(p);
                   this.isOut(p);
               }
               else
               {
                   p.setDebt(-1000);
                   p.addToWallet(1000);
                   System.out.println("See you later buddy.... -_-");
                   holdOn(2000);
               }
                    
          }
        else if (p.getDebt() < 0 && p.getWallet() > 0) {
                    
               int amountHolder =0;
               System.out.println(p.getName() + " is in debt. Would they like to pay their debt? y or n");
               theChoice = input.nextLine();
               if (theChoice.equalsIgnoreCase("y") || theChoice.equalsIgnoreCase("yes") )
               {
                   do
                   {
                       System.out.println(p.getWallet() + " is in your Wallet. How much do you want to pay off?");
                       amountHolder = input.nextInt();
                        
                       if (amountHolder > p.getWallet())
                       {
                           System.out.println("You don't have that much.");
                       }
                       else 
                       {
                           p.subDebt(amountHolder);
                           p.subFromWallet(amountHolder);
                       }
                   } while ( !( amountHolder <= p.getWallet() ) ); // makes sure the user chooses an amount that is within the wallet
               }
                    
          } // end debt payment
                
          if (p.getDebt() < 0 && p.getWallet()<=0) {
               System.out.println("Large Italian Man:\n \"It appears as if you got a little problem\" >_<");
               LEGS_BROKE.play();
               holdOn(2000);
               System.out.println(p.getName() + "Stepped into the alley and isn't coming back.");
               players.remove(p);
               this.isOut(p); // might want to change this name
           }
                
                
    } // end of checkStatus
    
    @Override
    public void run() 
    {
        boolean runMe = true;
        Scanner input = new Scanner(System.in);
        
        while (runMe) {
 
            // not needed yet BACKGROUND.play();
            
            for (CrapsPlayer roller : players) {
               if (marker == 0)
                   comeOutRoll = true;
               else
                    comeOutRoll = false;
               
               for (int i = 0; i < players.size(); i++)
               {
                    placeBet(players.get(i));
               }
                   System.out.println(roller.getName() + " has the Dice"); //
                   rollCrapsDice();
                // not needed yet DICE_ROLL.play();
                
               holdOn(1000); 
               /* try catch blocks for sleeping are in here instead of clogging
                * up this space in this method. Not the best thing but ok for 
                * this program.
                */ 
               System.out.println(roller.getName() + " rolled " + rolled1.getLastRoll() + " and a " + rolled2.getLastRoll() 
                        + " for a total of " + this.getLastTotalRoll() );
               
               for (int i =0; i < field.size(); i++)
               {   
                    fieldBetOutcome(field.get(i));
               }
               holdOn(1000);
               
               for (int i =0; i < passLine.size(); i++)
               {   
                    passBetOutcome(passLine.get(i));
               }
               
               holdOn(1000);
               
               for (int i =0; i < come.size(); i++)
               {
                    checkComeBetOutcome(come.get(i));
               }
               
               for (int i =0; i < dontPass.size(); i++)
               {
                    dontPassBetOutcome(dontPass.get(i)); 
               }
               holdOn(1000);
               /* Someone must be wondering why I'm using so many sleeps
                * All I'm really doing is making sure the users know what's 
                * going on instead of it flying past very quickly. 
                */
               
               // not needed yet WINNER.play();
                
            } // end roll for each player
            
            System.out.println("Status of each player");
            for (int i =0; i < players.size(); i++) { 
                System.out.println(players.get(i).toString());
                this.checkStatus(players.get(i));
                holdOn(2000);
            } // end player status loop
            
            if (players.isEmpty()) // if there are no more players than the game is over
                runMe = false;
        } // end game while loop
        System.out.println("The Game is over");
    } // end run method
    
} // end of class 
