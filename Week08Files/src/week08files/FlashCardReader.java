/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week08files;

/**
 *
 * @author Gregory Safko
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlashCardReader {
	
	// Class FileInputStream has methods to help read a file.
	private FileInputStream input;
	private ArrayList<FlashCards> flashCards;
	
	public FlashCardReader(File file){
		try {
			// Create a new instance of a FileInputStream
			// based on parameter
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file!");
		}
		
		flashCards = new ArrayList<>();
	}
	
	public void readFlashCardFile(){
		// Use a scanner to read the input stream
		Scanner reader = new Scanner(this.input);
		while (reader.hasNext()) {
			// We know that each entry as two strings and an int
			// So it is safe to do all three of those reads each
			// time through the loop, unless the data in the file
			// is bad, in which case there will be an exception thrown.
			String face = reader.nextLine();

			String answer = reader.nextLine();

			int points = reader.nextInt();
			reader.nextLine();
			
			this.flashCards.add(new FlashCards(face, answer, points));
		}
	}
	
	public void showCards(){
		int i=1;
		for( FlashCards card : flashCards ){
			System.out.println( "Flash Card " + i + "\n" + card.toString());
			i++;
		}
	}
	
	// Even for reading, the file must be closed to ensure data integrity.
	public void finished(){
		try {
			this.input.close();
		} catch (IOException e) {
			System.out.println("Error closing file, your data may be lost.");
		}
	}

	public static void main(String[] args) {
		File flashCardFile = new File("flashCards.txt");
		FlashCardReader reader = new FlashCardReader(flashCardFile);
		reader.readFlashCardFile();
		reader.showCards();
		reader.finished();
	}
}
