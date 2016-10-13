import java.util.ArrayList;

public class Course {
	private String name;
	private int credits;
	private int seats;
	private ArrayList<Student> roster;
	
	public Course(String name, int credits, int seats){
		this.name = name;
		this.credits = credits;
		this.seats = seats;
		roster = new ArrayList<Student>();
	}
	public String getName()
	{
		return name;
	}
	public int getCredits()
	{
		return credits;
	}
	public int getRemainingSeats()
	{
		return seats;
	}
	public boolean addStudent(Student newStudent)
	{

		if (seats > 0)
		{
			roster.add(newStudent);
			seats = seats -1;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public double averageGPA()
	{
		double totalgpa = 0;
		for (Student i : roster)
		{
			totalgpa += i.getGPA();
		}
		double averagegpa = totalgpa / roster.size();
		averagegpa = Math.round(averagegpa * 1000);
		averagegpa = averagegpa/1000;
		return averagegpa;
	}
	
	public String toString()
	//Display information as a String
	{
		return "Course: " + name + " | " + " Course Credits:" + credits;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course c1 = new Course("math", 3, 4);
		Student s1 = new Student("john", "schulz", 111);
		c1.addStudent(s1);
	}

}
