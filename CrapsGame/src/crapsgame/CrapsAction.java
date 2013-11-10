
package crapsgame;

/**
 *
 * @author John White
 */

import java.util.Scanner;
import java.util.ArrayList;

public class CrapsAction implements Runnable
{
    private static int numberOfPlayers;
    
    // the following strings are for the various sounds and music played during the game
    
    private final static String BACKGROUND_MUSIC = System.getProperty("users.dir") + System.getProperty("file.seperator") + "craps_back.mp3";
    private final static String DICE_ROLL_SOUND =  System.getProperty("users.dir") + System.getProperty("file.seperator") + "craps_dice.mp3";
    private final static String LEGS_BROKE_SOUND = System.getProperty("users.dir") + System.getProperty("file.seperator") + "craps_death.mp3";
    private final static String WIN_SOUND = System.getProperty("users.dir") + System.getProperty("file.seperator") + "craps_win.mp3";
            
    ArrayList <CrapsPlayer> players = new ArrayList<>(); // this list holds all of the current players
    
    private static final Mp3Handler BACKGROUND = new Mp3Handler(BACKGROUND_MUSIC);
    private static final Mp3Handler DICE_ROLL = new Mp3Handler(DICE_ROLL_SOUND);
    private static final Mp3Handler LEGS_BROKE = new Mp3Handler(LEGS_BROKE_SOUND);
    private static final Mp3Handler WINNER = new Mp3Handler(WIN_SOUND);
    
    public CrapsAction(int NumOfPlayers)
    {
        numberOfPlayers = NumOfPlayers;
        players.ensureCapacity(NumOfPlayers);
        this.initializePlayers();
    }
    
    private void initializePlayers()
    {
        for (int i =0; i<players.size(); i++)
        {
            System.out.print("For player " + (i+1) + " ");
            players.get(i).getPlayerData();
        }
    }
    
    private boolean gameResult ()
    {
        // if a player wins
        if ( 1!=0 ) // placeholder
            return true;
        
        // otherwise
        else
            return false;
    }
    
    @Override
    public void run()
    {
        
    }
    
    
    
    
    
}
