/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtwgrade.converter;

/**
 *
 * @author John White 
 * @see modified from java source provided by instructor
 */
import java.util.Scanner;

public class JTWGradeConverter {
	
    public String convertGrade( int numberGrade )
    {
		
                if( numberGrade > 89 ){
			return "A";
		}
                
                else if (numberGrade > 79 )
                {
                    return "B";
                }
                
                else if (numberGrade > 69 )
                {
                    return "C";
                }
                
                else if (numberGrade > 59 )
                {
                    return "D";
                }
		
                else
                {
			return "F";
		}
                
		// TODO: fill in the rest of this method.
		// Use else if statements and else to finish
		// the grade conversion.
	}
	
	/**
	 * This method gets input from the user
	 * @return a grade in number format from 0-100
	 */
    
	public int getNumberGrade()
        {
		int userInput;
		// TODO complete this method
                Scanner inputLine = new Scanner(System.in);
                System.out.println("Please enter a whole number grade for the student");
		userInput = inputLine.nextInt();
                return userInput;
	}
        
	public static void main(String[] args) {
		JTWGradeConverter converter = new JTWGradeConverter();
		int input = converter.getNumberGrade();
		String letterGrade = converter.convertGrade(input);
		
		System.out.println("The letter grade for " + input + " is " + letterGrade);
	}

}
