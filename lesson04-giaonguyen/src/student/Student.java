package student;

import java.util.Scanner;

public class Student {
	private String name;
	private int id;
	private float theoreticalScore;
	private float practiceScore;
	
	public Student() {
		this.name = "";
		this.id = 0;
		this.practiceScore = 0.00f;
		this.practiceScore = 0.00f;
	}

	public Student(String name, int id, float theoreticalScore, float practiceScore) {
		super();
		this.name = name;
		this.id = id;
		this.theoreticalScore = theoreticalScore;
		this.practiceScore = practiceScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTheoreticalScore() {
		return theoreticalScore;
	}

	public void setTheoreticalScore(float theoreticalScore) {
		this.theoreticalScore = theoreticalScore;
	}

	public float getPracticeScore() {
		return practiceScore;
	}

	public void setPracticeScore(float practiceScore) {
		this.practiceScore = practiceScore;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", theoreticalScore=" + theoreticalScore + ", practiceScore="
				+ practiceScore + "]";
	}
	
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Name: ");
		setName(sc.nextLine());
		
		System.out.println("ID: ");
		setId(sc.nextInt());
		
		System.out.println("Theoretical score: ");
		setTheoreticalScore(sc.nextFloat());
		
		System.out.println("Practice score: ");
		setPracticeScore(sc.nextFloat());
	
	}
	
	public float exportScore() {
		float scoreAvg = 0.00f;
		
		scoreAvg = (this.getTheoreticalScore() + this.getPracticeScore()) / 2;
		
		return scoreAvg;
	}
}
