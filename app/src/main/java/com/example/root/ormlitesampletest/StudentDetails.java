package com.example.root.ormlitesampletest;



import com.j256.ormlite.field.DatabaseField;


public class StudentDetails {

	/**
	 * Model class for student_details database table
	 */

	
	public static final String ID_FIELD = "student_id";

	
	// Primary key defined as an auto generated integer 
	// If the database table column name differs than the Model class variable name, the way to map to use columnName
	@DatabaseField(generatedId = true, columnName = ID_FIELD)
	public int studentId;

	// Define a String type field to hold student's name
	@DatabaseField(columnName = "student_name")
	public String studentName;

	@DatabaseField(columnName = "grade")
	public String grade;

	@DatabaseField(columnName = "roll_no")
	public String rollNo;

	

	// Default constructor is needed for the SQLite, so make sure you also have it
	public StudentDetails(){
		
	}
	
	//For our own purpose, so it's easier to create a StudentDetails object
	public StudentDetails(final String name, final String grade,final String rollNo){
		this.studentName = name;
		this.grade = grade;
		this.rollNo = rollNo;
	}

}
