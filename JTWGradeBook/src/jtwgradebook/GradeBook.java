package jtwgradebook;

/**
 *
 * @author John White some source provided by instructor
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

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
            
            if (homeorExam.equalsIgnoreCase("homework"))
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
            
            if (homeorExam.equalsIgnoreCase("exam"))
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
	
	// adding file IO to this class. This method will be our template
	
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
	
	// add the file handling classes here.
	
	public void saveGrades()
        {
            // ToDo: make this method save the grades and the person they are
		   // attached to into a file (not sure if will do binary or text)
		   
		   // need to add an indicator of whether the entry is a homework or exam.
		   // using extension to do so. Not optimal but will work
		   
            for (int i =0; i < homeWorkEntries.size();i++)
            {  
			 try
			 {
				 File homeworkEntry = new File((homeWorkEntries.get(i).getStudent().getName() + "-"  
					+ homeWorkEntries.get(i).getAssessmentName() + ".hwe"));
				 FileOutputStream fileOut = new FileOutputStream(homeworkEntry);
				 
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(homeWorkEntries.get(i));
				out.close();
				fileOut.close();
				
				/*
				BufferedWriter entryWriter = new BufferedWriter(new FileWriter (homeworkEntry,true) );
				entryWriter.write(homeWorkEntries.get(i).getAssessmentName() + "," 
					   + homeWorkEntries.get(i).getNumericGrade());
				entryWriter.close(); */
			 } 
			 catch (IOException e)
			 {
				 System.out.println("Could not save entry");
			 }
		  
		  }
            
		  for (int i =0; i < ExamEntries.size();i++)
            {
                try
			 {
				 File examEntry = new File((ExamEntries.get(i).getStudent().getName() + "-"  
					+ ExamEntries.get(i).getAssessmentName() + ".exm"));
				 FileOutputStream fileOut = new FileOutputStream(examEntry);
				 
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(ExamEntries.get(i));
				out.close();
				fileOut.close();
				
				/*BufferedWriter entryWriter = new BufferedWriter(new FileWriter (examEntry,true) );
				entryWriter.write(" " + ExamEntries.get(i).getAssessmentName() + " " 
					   + ExamEntries.get(i).getNumericGrade());
				entryWriter.close(); */
			 } 
			 catch (IOException e)
			 {
				 System.out.println("Could not save entry");
			 }
            }
	}
	
	// load grades method will go here. may use a constructor as well. 
	
	public void loadGrades()
	{
		File cwd = new File(System.getProperty("user.dir"));
		
		if (cwd.isDirectory()) {
			for (File child : cwd.listFiles()) {
				// this loop will go over each file
	
				if (child.getName().contains(".hwe")) { // just so we all know this is probably a bad way to do this
					File hwRead = new File(child.getName());
					try
					{
						HomeWorkEntry temp = new HomeWorkEntry();
						FileInputStream input = new FileInputStream(hwRead);
						ObjectInputStream reader = new ObjectInputStream(input);
						homeWorkEntries.add((HomeWorkEntry)reader.readObject());
						reader.close();
						/*
						Scanner stringRead = new Scanner(input);
					
						while (stringRead.hasNext())
						{
							temp.setAssessmentName(stringRead.next());
							temp.setNumericGrade(stringRead.nextInt());
						}
						homeWorkEntries.add(temp);
						input.close(); */
					}
					catch (IOException e)
					{
						System.out.println("Could not read file: " + child.getName());
					}
					catch (ClassNotFoundException e)
					{
						System.out.println("File read was not in correct format: " + child.getName());
					}
					
				} // end homeworkentry if
				
				else if (child.getName().contains(".exm")) { // just so we all know this is probably a bad way to do this
					File exRead = new File(child.getName());
					
					try
					{
						// ExamEntry temp = new ExamEntry();
						FileInputStream input = new FileInputStream(exRead);
						ObjectInputStream reader = new ObjectInputStream(input);
						ExamEntries.add((ExamEntry)reader.readObject());
						reader.close();
						/*
						Scanner stringRead = new Scanner(input);
					
						while (stringRead.hasNext())
						{
							temp.setAssessmentName(stringRead.next());
							temp.setNumericGrade(stringRead.nextInt(), 0);
						}
						ExamEntries.add(temp);
						input.close();
						*/
					}
					catch (IOException e)
					{
						System.out.println("Could not read file: " + child.getName());
					}
					catch (ClassNotFoundException e)
					{
						System.out.println("File read was not in correct format: " + child.getName());
					}
					
				} // end else if for exam entry
				
			} // end for loop
		} // end directory check
	} // end load method
	
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
