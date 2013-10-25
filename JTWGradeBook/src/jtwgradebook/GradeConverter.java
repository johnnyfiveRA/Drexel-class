/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtwgradebook;

/**
 *
 * @author Instructor provided material for this particular source
 */
import java.util.Scanner;


public class GradeConverter {

	public String convertGrade( int numberGrade ){
		if( numberGrade >= 90 ){
			return "A";
		}
		else if( numberGrade >= 80 ) {
			return "B";
		}
		else if( numberGrade >= 70 ){
			return "C";
		}
		else if( numberGrade >= 60 ){
			return "D";
		}
		else{
			return "F";
		}
	}
	
	/**
	 * This method gets input from the user
	 * @return a grade in number format from 0-100
	 */
	public int getNumberGrade(){
		// declare and intialize variables
		int userInput;
		
                Scanner reader = new Scanner(System.in);
		
		// get the user input
		System.out.print("Enter the number grade: ");
		userInput = reader.nextInt();
		
		// return the input to the caller of this method
		return userInput;
	}
        
	/**
	 * @param args
	 */

        public static void main(String[] args) {
		GradeConverter converter = new GradeConverter();
		int input = converter.getNumberGrade();
		String letterGrade = converter.convertGrade(input);
		
		System.out.println("The letter grade for " + input + " is " + letterGrade);
	}

}
