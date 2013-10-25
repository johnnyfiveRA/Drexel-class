/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtwgradebook;

/**
 *
 * @author Instructor provided material
 */
import java.util.Scanner;

public class GradeBookEntry {

	private Person student;
	private int numericGrade;
	private String assessmentName;

	// The next six methods are just getters and setters
	// for the member variables of this class.
	public Person getStudent() {
		return student;
	}

	public void setStudent(Person student) {
		this.student = student;
	}

	public int getNumericGrade() {
		return numericGrade;
	}

	public void setNumericGrade(int numericGrade) {
		this.numericGrade = numericGrade;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	
	public String getLetterGrade(){
		GradeConverter converter = new GradeConverter();
		return converter.convertGrade(numericGrade);
	}

	public void printEntry(){
		System.out.println(student.toString());
		
		// instantiate a GradeConverter to get the letter grade.
		GradeConverter converter = new GradeConverter();
		System.out.println("Scored " + numericGrade );
		System.out.println("Which is a: " + converter.convertGrade(numericGrade));
		System.out.println("For assessment: " + assessmentName);
	}
	
	public static void main(String[] args) {
		// instantiate the GradeBookEntry, just like we have
		// done with the Scanner class.
		GradeBookEntry gradeBookEntry = new GradeBookEntry();
		Scanner reader = new Scanner(System.in);
	
		// instantiate a new person object
		Person student = new Person();
		student.getPersonData();
		gradeBookEntry.setStudent(student);
		

		System.out.print("Enter this students numeric grade: ");
		int grade = reader.nextInt();
		
		gradeBookEntry.setNumericGrade(grade);
		gradeBookEntry.setAssessmentName("test1");
		
		gradeBookEntry.printEntry();
	}

}
