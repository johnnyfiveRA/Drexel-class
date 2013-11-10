
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
    
    private int wallet; // this contains the players money it cannot go below zero
    
    // if the user decides to go into debt this will contain the level of debt which is positive
    private int debt;  
    
    private int totalWinnings =0;

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
    
    public int getWallet() 
    {
        return wallet;
    }

    public int getDebt() {
        return debt;
    }
    
    public void win(int amount)
    {
        this.wallet += amount;
        this.totalWinnings +=amount;
    }
    
    public void lose(int amount)
    {
            this.wallet -= amount;  
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
    
    public void getPlayerData()
    {
        Scanner reader = new Scanner(System.in);
		
		System.out.print("Enter the players name: ");
		name = reader.nextLine();
    }
    
    @Override
    public String toString()
    {
        if (debt ==0){
            return this.name + "\nHas " + wallet + "in their wallet and has won\n" + totalWinnings + "in total";
        }
        
        if (wallet == 0)
        {
            return this.name + "\nHas " + debt + " and is very close to getting their legs broken";
        }
        
        else{
            return this.name + "\nHas " + wallet + " in their wallet" + "\nand is " + debt + " in debt\n"
                    + "It has won " +totalWinnings + " during this game."; 
        }
    }
    
}
