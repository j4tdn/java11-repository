package ex01;

import java.text.DecimalFormat;

public class Student {
	private int id;
	private String name;
	private float theoryPoint;
	private float practicePoint;
	
	public Student() {
		this.id = 0;
		//this.name = "";
		this.theoryPoint = 0;
		this.practicePoint = 0;
	}

	public Student(int id, String name, float theoryPoint, float practicePoint) {
		this.id = id;
		this.name = name;
		this.theoryPoint = theoryPoint;
		this.practicePoint = practicePoint;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getTheoryPoint() {
		
		return theoryPoint;
	}

	public void setTheoryPoint(float theoryPoint) {
		this.theoryPoint = theoryPoint;
	}

	public float getPracticePoint() {
		return practicePoint;
	}

	public void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}
	
	public float GPA() {
		return (this.practicePoint + this.theoryPoint)/2;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.printf("%-10d%-15s%-10s%-10s%-10s\n", id, name, df.format(theoryPoint), df.format(practicePoint), df.format(this.GPA()));
		return "";
	}
	
	
	
}
