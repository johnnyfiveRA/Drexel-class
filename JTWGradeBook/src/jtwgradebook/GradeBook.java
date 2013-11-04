package jtwgradebook;

/**
 *
 * @author John White some source provided by instructor
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GradeBook {
	
	private String course;
	private ArrayList<Person> students = new ArrayList<>();
	private ArrayList<HomeWorkEntry> homeWorkEntries = new ArrayList<>();
        private ArrayList<ExamEntry> ExamEntries = new ArrayList<>();
        
	
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
            
            String homeorExam;
            
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
                
            System.out.println("Is this a Homework assignemnt or an Exam?");
            System.out.println("Type homework or exam to make the appropriate entry");
            homeorExam = reader.next();
            
            while (  !(homeorExam.equalsIgnoreCase("homework")) && !(homeorExam.equalsIgnoreCase("exam")) )
            {
                System.out.println(" Please type either \"homework\" or \"exam\" (without quotes) to make the appropriate entry");
                homeorExam = reader.next();
            }
            
            if (homeorExam.equals("homework"))
            {
                HomeWorkEntry hEntry = new HomeWorkEntry();
                hEntry.setStudent(students.get(studentSelect));
                
                System.out.println("What was the name of the assignment");
                hEntry.setAssessmentName(reader.next());
                
                System.out.println("Enter the numeric grade of the assignment in whole numbers (0-100) only");
                int grade = reader.nextInt();
                
                while (grade < 0 || grade > 100)
                {
                    System.out.println("Only whole numbers between 0 and 100 are accepted as grades. Please enter a valid grade");
                    grade = reader.nextInt();
                }
                
                hEntry.setNumericGrade(grade);
		
                homeWorkEntries.add(hEntry);
            }
            
            if (homeorExam.equals("exam"))
            {
                ExamEntry eEntry = new ExamEntry();
                eEntry.setStudent(students.get(studentSelect));
                
                System.out.println("What was the name of the assesment");
                eEntry.setAssessmentName(reader.next());
                
                System.out.println("Enter the numeric grade of the assesment (before any curve) in whole numbers (0-100) only");
                int grade = reader.nextInt();
                
                while (grade < 0 || grade > 100)
                {
                    System.out.println("Only whole numbers between 0 and 100 are accepted as grades. Please enter a valid grade");
                    grade = reader.nextInt();
                }
                
                // set a curve
                System.out.println("Enter the flat curve on the exam");
                int curve = reader.nextInt();
                
                while (curve < 0 || curve > 100)
                {
                    System.out.println("Only whole numbers between 0 and 100 are accepted as curves. Please enter a valid flat curve");
                    curve = reader.nextInt();
                }
                
                eEntry.setNumericGrade(grade, curve);
		
                ExamEntries.add(eEntry);
            }
            
	}
	
	public void listGrades() throws InterruptedException
        {
            // DONE: Print out all the grade entries in this gradebook coded by JTW
            
            System.out.println(" Homework assignments for course: " + course);
            for (int i =0; i < homeWorkEntries.size();i++)
            {
                homeWorkEntries.get(i).getData(); // easy enough
            }
            System.out.println("Any Exams will display in 5 seconds");
            Thread.sleep(5000);
            
            System.out.println("Exam assessments for course: " + course);
            for (int i =0; i < ExamEntries.size();i++)
            {
                ExamEntries.get(i).getData();
            }
	}
	
	public void displaySummary() throws InterruptedException
        {
            // Done: show a distribution of letter grades in this class. by JTW
            System.out.println("Homework for: " + course);
            
            for (int i =0; i <=4; i++)
            {
                switch (i) 
                {
                    case 0:  System.out.print("F: ");    
                             for(int index =0; index < homeWorkEntries.size(); index++)
                             {
                                if (homeWorkEntries.get(index).getLetterGrade().equals("F"))
                                    {
                                        System.out.print("*");
                                    }
                             }
                             System.out.println();
                            break;
                    
                    case 1: System.out.print("D: ");    
                            for(int index =0; index < homeWorkEntries.size(); index++)
                            {
                                if (homeWorkEntries.get(index).getLetterGrade().equals("D"))
                                {
                                    System.out.print("*");
                                }
                            }
                            System.out.println();
                            break;
                        
                    case 2: System.out.print("C: ");
                            for(int index =0; index < homeWorkEntries.size(); index++)
                            {
                                if (homeWorkEntries.get(index).getLetterGrade().equals("C"))
                                {
                                    System.out.print("*");
                                }
                            }
                           
                            System.out.println();
                            break;
                        
                    case 3: System.out.print("B: ");   
                            for(int index =0; index < homeWorkEntries.size(); index++)
                            {
                                if (homeWorkEntries.get(index).getLetterGrade().equals("B"))
                                {
                                    System.out.print("*");
                                }
                            } 
                            
                            System.out.println();
                            break;
                        
                    case 4: System.out.print("A: ");
                            for(int index =0; index < homeWorkEntries.size(); index++)
                            {
                                if (homeWorkEntries.get(index).getLetterGrade().equals("A"))
                                {
                                    System.out.print("*");
                                }
                            }
                            
                            System.out.println();
                            break;
                        
                } // end switch for homework
                
            } // end of outer for for homework entries
            System.out.println("Chart for any exams will display in 5 seconds");
            Thread.sleep(5000);
            
            System.out.println("Exams for: " + course);
            
            for (int i =0; i <=4; i++) // need a second one of these so that the summaries for exams don't mash with homework entries
            {
                switch (i)  
                {
                    case 0:  System.out.print("F: ");    
                             for(int index =0; index < ExamEntries.size(); index++)
                            {
                                if (ExamEntries.get(index).getLetterGrade().equals("F"))
                                {
                                    System.out.print("*");
                                }
                            }
                            
                             System.out.println();
                            break;
                    
                    case 1: System.out.print("D: ");    
                            
                            for(int index =0; index < ExamEntries.size(); index++)
                            {
                                if (ExamEntries.get(index).getLetterGrade().equals("D"))
                                {
                                    System.out.print("*");
                                }
                            }
                            
                            System.out.println();
                            break;
                        
                    case 2: System.out.print("C: ");
                            
                            for(int index =0; index < ExamEntries.size(); index++)
                            {
                                if (ExamEntries.get(index).getLetterGrade().equals("C"))
                                {
                                    System.out.print("*");
                                }
                            }
                            System.out.println();
                            break;
                        
                    case 3: System.out.print("B: ");   
                                         
                            for(int index =0; index < ExamEntries.size(); index++)
                            {
                                if (ExamEntries.get(index).getLetterGrade().equals("B"))
                                {
                                    System.out.print("*");
                                }
                            } 
                            System.out.println();
                            break;
                        
                    case 4: System.out.print("A: ");
                            for(int index =0; index < ExamEntries.size(); index++)
                            {
                                if (ExamEntries.get(index).getLetterGrade().equals("A"))
                                {
                                    System.out.print("*");
                                }
                            }
                            System.out.println();
                            break;
                        
                } // end switch for exam entries
                
            } // end of outer for for Exam Entries
            
	} // end of display summary

    // this is a library now. No main here.

} // end of class
