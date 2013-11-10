
package week07staticfinal;

/**
 *
 * @author John White
 */

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Week07staticfinal
{
    private static int testValue = 0;
    
    // private static final double WIDTH; // I'M YELLING BECAUSE IT CAN'T BE CHANGED
    private static final double PI = 3.1415;    // CAPITALS LETTERS MEAN I'M IMPORTANT!!!!
    
    public static int getTestValue()
    {
        return testValue;
    }
    
    public static void setTestValue(int thing)
    {
        Week07staticfinal.testValue = thing;
    }
    
    public static long add (long a, long b)
    {
        return a+b;
    }
    
    /*@Override 
    public void start(Stage stage) throws MalformedURLException 
    {
        //final Label status = new Label("Init");
        
        MediaPlayer mediaPlayer = new MediaPlayer("C:/Users/Public/Music/Sample Music/Future Islands - Before the Bridge.mp3"); 
      
    } */
    
    public static void main(String[] args) throws InterruptedException
    {
        
       final double WIDTH;
       WIDTH = 1.606;
       
       // WIDTH = 2.345; HA HA YOU CAN'T DO THAT!!! :D
        
        Week07staticfinal thing1 = new Week07staticfinal();
        Week07staticfinal thing2 = new Week07staticfinal();
        
        System.out.println(Week07staticfinal.add(1,2) + " great scott marty it works");
        
        thing1.setTestValue(100);
        
        System.out.println("Thing1 value is " + thing1.getTestValue());
        System.out.println("thing2 value is " + thing2.getTestValue());
        
        System.out.println("golly gee wilickers uncle bob. whys the value of thing1 equal to thing2??????");
        
        System.out.println("FINISH HIM....");
        String sound = "file://Finish_Him.mp3";
        // File filename = new File(sound);
        Media file = new Media(sound);
        MediaPlayer player = new MediaPlayer(file);
        player.play();
        
        Thread.sleep(4000);
    
        Point p1 = new Point (3,7);
        Point p2 = new Point (3,7);
        
        if (p1 == p2)
            System.out.println("They are equal"); 
        else
            System.out.println("They are NOT equal");
    
        if (p1.equals(p2))
            System.out.println("They are equal"); 
        else
            System.out.println("They are NOT equal");
   
    }   
}
