
package crapsgame;

import java.util.Scanner;

/**
 *
 * @author John White
 */

// import java.lang.Exception;

public class CrapsPlayer extends Person
{
    final static private String NEGATIVE_WALLET_MESSAGE= "Player Wallet accessed while negative";
    final static private String NEGATIVE_DEBT_MESSAGE= "Player Debt accessed while negative";
    
    private int wallet; // this contains the players money once it is zero 
                        // the player can continue by going into debt or going out
    
    // if the user decides to go into debt this will contain the level of debt which is negative
    private int debt;  
    
    private int totalWinnings =0;
    
    private int comeBetChoice=0;
    
    private int passBetAmount=0;
    private int fieldBetAmount=0;
    private int comeBetAmount=0;
    private int dontPassAmount=0;
    
    
    // exception for wallet being negative may not go with this 
    // private Exception negativeWalletException = new Exception(NEGATIVE_WALLET_MESSAGE);
    
    // exception for debt being negative may not go with this either
    // private Exception negativeDebtException = new Exception(NEGATIVE_DEBT_MESSAGE);
    
    public CrapsPlayer ()
    {
        wallet = 500;
        debt =0;     
    }
   
    public CrapsPlayer(String playerName, int wallet, int debt)
    {
        this.name=playerName;
        this.wallet=wallet;
        this.debt=debt;
    }
    
    public CrapsPlayer( String playerName)
    {
        this.name=playerName;
        wallet = 500;
        debt =0;
    }
    
    public int getWallet() 
    {
        return wallet;
    }
    
    public void setWallet(int newamount)
    {
        wallet = newamount;
    }
    
    public void subFromWallet(int amount)
    {
        wallet -= amount;
    }
    
    public void addToWallet(int amount)
    {
        wallet += amount;
    }
    
    public int getDebt() {
        return debt;
    }
    
    public void win(int amount)
    {
        this.wallet += (amount*2);
        this.totalWinnings += amount;
    }
    
    public void lose(int amount)
    {  
            this.totalWinnings-=amount;
    }
    
    public void setDebt(int newDebt)
    {
        this.debt = newDebt;
    }
    
    public void addDebt(int amount)
    {
        debt += amount;
    }
    
    public void subDebt(int amount)
    {
        debt -=amount;
    }
    
    public int getComeBetChoice()
    {
        return this.comeBetChoice;
    }
    
    public void setComeBetChoice(int choice)
    {
        this.comeBetChoice = choice;
    }        
    
    public int getPassBetAmount() {
        return passBetAmount;
    }

    public int getFieldBetAmount() {
        return fieldBetAmount;
    }

    public int getComeBetAmount() {
        return comeBetAmount;
    }

    public int getDontPassAmount() {
        return dontPassAmount;
    }

    public void setPassBetAmount(int passBetAmount) {
        this.passBetAmount = passBetAmount;
        this.wallet -= passBetAmount;
    }

    public void setFieldBetAmount(int fieldBetAmount) {
        this.fieldBetAmount = fieldBetAmount;
        this.wallet -= fieldBetAmount;
    }

    public void setComeBetAmount(int comeBetAmount) {
        this.comeBetAmount = comeBetAmount;
        this.wallet -= comeBetAmount;
    }

    public void setDontPassAmount(int dontPassAmount) {
        this.dontPassAmount = dontPassAmount;
        this.wallet -= dontPassAmount;
    }
   
    @Override
    public String toString()
    {
        if (debt == 0){
            return this.name + "\nHas " + wallet + " in their wallet and has won\n" + totalWinnings + " in total";
        }
        
        if (wallet == 0)
        {
            return this.name + "\nHas " + debt + " and is very close to getting their legs broken";
        }
        
        else {
            return this.name + "\nHas " + wallet + " in their wallet" + "\nand is " + debt + " in debt\n"
                    + "It has won " +totalWinnings + " during this game."; 
        }
    }
    
}
