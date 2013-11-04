/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtwgradebook;

/**
 *
 * @author John
 */
public class ExamEntry extends GradeBookEntry
{
    
        private Person student;
	private int numericGrade;
	private String assessmentName;
        
	// The next six methods are just getters and setters
	// for the member variables of this class.
	
        public ExamEntry ()
        {
            student = new Person();
            numericGrade = 0;
            assessmentName = "";
        }
        public ExamEntry(Person initialStudent, String assessment, int grade, int examCurve)
        {
            this.setStudent(initialStudent);
            this.setAssessmentName(assessment);
            this.setNumericGrade(grade,examCurve);
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

	public final void setNumericGrade(int numericGrade, int curve) 
        {
                // flat curve is the best this can do without a collection to work with
		this.numericGrade = numericGrade + curve;
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
		System.out.println("For assessment: " + assessmentName);
	}
        
}
