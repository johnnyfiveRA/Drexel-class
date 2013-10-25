package jtwgradebook;

/**
 *
 * @author John White some source provided by instructor
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GradeBook {
	
	private String course;
	private ArrayList<Person> students = new ArrayList<Person>();
	private ArrayList<GradeBookEntry> entries = new ArrayList<GradeBookEntry>();
	
	public String getCourse() {
            return course;
	}

	public void setCourse(String course) {
            this.course = course;
	}

	public void addStudent( Person student ){
            students.add(student);
	}
	
	public void addEntry()
        {	
            // Print out each students name and choose one
            System.out.println("Grade which student: ");
            for( int i=0; i<students.size(); i++ )
            {
            	System.out.println(i + ": " + students.get(i).getName() );
            }
		
            Scanner reader = new Scanner(System.in);
            int studentSelect = reader.nextInt();
		
            if ( (studentSelect > ( students.size() ) + 1) || studentSelect < 0)
            {
                System.err.println("Error: User selection out of bounds");
                return;
            }
                
            // DONE: get the assessment name and numeric grade coded by JTW
            // DONE: set the data in the new entry coded by JTW
                
            GradeBookEntry entry = new GradeBookEntry();
            entry.setStudent(students.get(studentSelect));
                
            System.out.println("What was the name of the assesment");
            entry.setAssessmentName(reader.next());
                
            System.out.println("Enter the numeric grade of the assesment in whole numbers (0-100) only");
            int grade = reader.nextInt();
                
            while (grade < 0 || grade > 100)
            {
                System.out.println("Only whole numbers between 0 and 100 are accepted as grades. Please enter a valid grade");
                grade = reader.nextInt();
            }
                
            entry.setNumericGrade(grade);
		
            entries.add(entry);
	}
	
	public void listGrades()
        {
            // DONE: Print out all the grade entries in this gradebook coded by JTW
            System.out.println("For course: " + course);
            for (int i =0; i < entries.size();i++)
            {
                entries.get(i).printEntry(); // easy enough
            }
                
	}
	
	public void displaySummary()
        {
            // Done: show a distribution of letter grades in this class. by JTW
            
            for (int i =0; i <=4; i++)
            {
                switch (i) // might be a weird way to do it. Might try enums. 
                {
                    case 0:  System.out.print("F: ");    
                             for(int index =0; index < entries.size(); index++)
                             {
                                if (entries.get(index).getLetterGrade().equals("F"))
                                    {
                                        System.out.print("*");
                                    }
                             }
                             System.out.println();
                            break;
                    
                    case 1: System.out.print("D: ");    
                            for(int index =0; index < entries.size(); index++)
                            {
                                if (entries.get(index).getLetterGrade().equals("D"))
                                {
                                    System.out.print("*");
                                }
                            }
                            System.out.println();
                            break;
                        
                    case 2: System.out.print("C: ");
                            for(int index =0; index < entries.size(); index++)
                            {
                                if (entries.get(index).getLetterGrade().equals("C"))
                                {
                                    System.out.print("*");
                                }
                            }    
                            System.out.println();
                            break;
                        
                    case 3: System.out.print("B: ");   
                            for(int index =0; index < entries.size(); index++)
                            {
                                if (entries.get(index).getLetterGrade().equals("B"))
                                {
                                    System.out.print("*");
                                }
                            }
                            System.out.println();
                            break;
                        
                    case 4: System.out.print("A: ");
                            for(int index =0; index < entries.size(); index++)
                            {
                                if (entries.get(index).getLetterGrade().equals("A"))
                                {
                                    System.out.print("*");
                                }
                            }
                            System.out.println();
                            break;
                        
                } // end switch
                
            } // end of outer for
            
	} // end of display summary

    // this is a library now. No main here.

} // end of class
