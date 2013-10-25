package jtwgradebook;

/**
 *
 * @author John White, some source is instructor provided
 * I am simultaneously elated and terrified that something so unnatural could work at all.
 */

import java.util.Scanner;

public class JTWGradeBook {

	public static void main(String[] args) 
        {
                Scanner input = new Scanner(System.in);
		
                Person person1 = new Person();
		person1.setName("John");
		person1.setAge(20);
                person1.setEmail("something@goggle.com");
                
		Person person2 = new Person();
		person2.setName("Lisa");
		person2.setAge(18);
                person2.setEmail("mine@goggle.com");
                
		Person person3 = new Person();
		person3.setName("Bill");
		person3.setAge(22);
                person3.setEmail("Jingles@billybobs.com");
                
		Person person4 = new Person();
		person4.setName("Sarah");
		person4.setAge(24);
                person4.setEmail("sarah@superultracorp.com");
		
                GradeBook book = new GradeBook();
		book.setCourse("CT-290");
		
                // from here down is code from JTW
                
                book.addStudent(person1);
                book.addStudent(person2);
                book.addStudent(person3);
                book.addStudent(person4);
                
		// DONE: add some gradbook entries
		
                String doMore;
                
                do // while the user wants to add entries
                {
                    System.out.println("You will be asked to select a student, please enter grades as promtped");
                    book.addEntry();
                    System.out.println("Would you like to add another entry? Type y or yes to continue");
                    doMore = input.next();
                    System.out.println(doMore + " " + doMore.equalsIgnoreCase("yes") + doMore.equalsIgnoreCase("y"));
                
                }while ( doMore.equalsIgnoreCase("yes") || doMore.equalsIgnoreCase("y") );
                
                // TODO: list the entries and display the bar chart by JTW
                
                System.out.println("Here are the entries in the grade book");
                
                book.listGrades();
                
                System.out.println("Summary of grades for class " + book.getCourse());
		book.displaySummary();
                	
	}

}
