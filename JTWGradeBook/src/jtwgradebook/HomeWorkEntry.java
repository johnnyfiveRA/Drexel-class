/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtwgradebook;

/**
 *
 * @author John White
 */

import java.io.Serializable;

public class HomeWorkEntry extends GradeBookEntry implements Serializable
{
     private Person student;
	private int numericGrade;
	private String assessmentName;

	// The next six methods are just getters and setters
	// for the member variables of this class.
	
        // add constructor here
        
        public HomeWorkEntry ()
        {
            student = new Person();
            numericGrade =0;
            assessmentName = "";
        }
        
        public HomeWorkEntry (Person initialStudent, int grade, String assessment)
        {
            this.setStudent(initialStudent);
            this.setAssessmentName(assessment);
            this.setNumericGrade(grade);
        }
        
        public Person getStudent() {
		return student;
	}

	public final void setStudent(Person student) {
		this.student = student;
	}

        @Override
	public int getNumericGrade() {
		return numericGrade;
	}

	public final void setNumericGrade(int numericGrade) {
		this.numericGrade = numericGrade;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public final void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	
	public String getLetterGrade(){
		GradeConverter converter = new GradeConverter();
		return converter.convertGrade(numericGrade);
	}

        @Override
	public void getData(){
		System.out.println(student.toString());
		
		// instantiate a GradeConverter to get the letter grade.
		GradeConverter converter = new GradeConverter();
		System.out.println("Scored " + numericGrade );
		System.out.println("Which is a: " + converter.convertGrade(numericGrade));
		System.out.println("For assignment: " + assessmentName);
	}
    
}
