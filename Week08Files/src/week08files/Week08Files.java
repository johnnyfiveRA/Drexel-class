
package week08files;

/**
 *
 * @author John White
 */


import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Week08Files {

	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		FlashCards firstOne = new FlashCards("What did george Washindton do before he chopped down the cherry tree?"
			   , "He lied to get an axe", 100);
		FlashCards secondOne = new FlashCards("How do you cross a busy street?", "Have a chicken do it first",10);
		FlashCards thirdOne = new FlashCards("What is the worst practical sorting algorithim","Bubble Sort", 1);
		
		FlashCardWriter outFile1 = new FlashCardWriter(new File("Card1.crd"));
		outFile1.saveFlashCard(firstOne);
		outFile1.saveFlashCard(secondOne);
		outFile1.saveFlashCard(thirdOne);
		outFile1.finished();
		
		FlashCardReader inFile1 = new FlashCardReader(new File("Card1.crd"));
		inFile1.readFlashCardFile();
		inFile1.showCards();
	}
}
