/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week08files;

/**
 *
 * @author Gregory Safko
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class collects data for a flash card, and writes it to a file.
 * Flash cards have a face (the side you see) and an answer (the other side)
 * They also have a point value, to help illustrate writing int values to files.
 */

public class FlashCardWriter {
	
	// Using a BufferedWriter instead of a plain FileWriter makes
	// the the program more efficient.
	private BufferedWriter writer;

	public FlashCardWriter(File file){
		try {
			// The FileWriter constructor with just a File param will
			// overwrite the file.  To append to the file, use the
			// the constructor that also takes a boolean.  If true, 
			// it will append, e.g. new FileWriter(file, true);
			writer = new BufferedWriter(new FileWriter(file, true));
		} catch (IOException e) {
			System.out.println("Unable to open file for writing!");
		}
	}
	
	// Extra protection in case finished() is never called
	// Note, that finalize may never get called either.
	// By adding the throws clause, we don't have to handle
	// the possible IOException
	protected void finalize()throws Throwable{
		if( null != writer ){
			writer.close();
		}
	}
	
	public void saveFlashCard(FlashCards card){
		try {
			// The write method simply takes a string and writes it to the file.
			writer.write(card.getFace() + "\n");
			writer.write(card.getAnswer() + "\n");
			writer.write(card.getPoints() + "\n");
		} catch (IOException e) {
			System.out.println("Error writing to file!");
		}
	}
	
	// Ask user for flash card data and return a FlashCard object
	public FlashCards getFlashCardData(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter Flash Card Face or Hint: ");
		String face = reader.nextLine();
		
		System.out.println("Enter Flash Card Answer: ");
		String answer = reader.nextLine();
		
		System.out.println("Enter Flash Card Point: ");
		int points = reader.nextInt();
		reader.nextLine();
		
		return new FlashCards(face, answer, points);
	}
	
	// Be sure to close the file when you are done, or your data
	// might not get written to the file!
	public void finished(){
		try {
			this.writer.close();
		} catch (IOException e) {
			System.out.println("Error closing file, your data may be lost.");
		}
	}

	public static void main(String[] args) {
		File flashCardFile = new File("flashCards.txt");
		FlashCardWriter cardWriter = new FlashCardWriter(flashCardFile);
		
		boolean quit = false;
		Scanner reader = new Scanner(System.in);
		
		while( !quit ){
			System.out.println("Enter 0 to exit or 1 to enter a card: ");
			int userChoice = reader.nextInt();
			if( userChoice != 0 ){
				FlashCards newCard = cardWriter.getFlashCardData();
				cardWriter.saveFlashCard(newCard);
			}else {
				quit = true;
			}
		}
		
		cardWriter.finished();
	}

}
