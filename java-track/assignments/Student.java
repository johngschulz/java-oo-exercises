// work to do:
//Round GPA
//Make sure Legacy BB name is set right


public class Student
{
	private String firstname;
	private String lastname;
	private int studentid;
	private int credits;
	private double gpa;
	
	public Student(String firstname, String lastname, int studentid)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.studentid = studentid;
		this.credits = 0;
		this.gpa = 0.0;
		
	}
	
	public String getName()
	{
		return (firstname+ " " + lastname);
	}
	
	public int getStudentID()
	{
		return studentid;
	}
	
	public double getGPA()
	{
		return gpa;
	}
	
	public int getCredits()
	{
		return credits;
	}
	
	public String getClassStanding()
	{
		if (credits < 30)
		{
			return "Freshman";
		}
		else if (credits < 60)
		{
			return "Sophomore";
		}
		else if (credits < 90)
		{
			return "Junior";
		}
		else
		{
			return "Senior";
		}
	}
	public void submitGrade(double grade, int courseCredits)
	{
	 double qualityscore = grade*courseCredits;
	 double totalscore = qualityscore + gpa * credits;
	 credits = credits + courseCredits;
	 gpa = Math.round((totalscore / credits) * 1000);
	 gpa = gpa/1000;

 
	}
	public Student createLegacy(Student p1, Student p2)
	{
		Integer maxcred;
		String first = p1.firstname;
		String last = p2.lastname;
		Integer id = p1.getStudentID() + p2.getStudentID();
		double avgpa = (p1.getGPA() + p2.getGPA()) / 2;
		if (p1.getCredits() > p2.getCredits()){
			maxcred = this.getCredits();
		}
		else{
			maxcred = p2.getCredits();
		}
		Student legacy = new Student(first, last, id);
		legacy.credits = maxcred;
		legacy.gpa = avgpa;
		return legacy;
	}
	public double computeTuition()
	{	
		double tuition;
		double studenttuition;
		if (credits < 15)
		{
			tuition = Math.round(20000.0/15.0 * 100);
			tuition = tuition/100;
			studenttuition = tuition * credits;
		}
		else if (credits == 15)
		{
			studenttuition = 20000.0;
		}
		else
		{
			tuition = Math.round(20000.0/15.0 * 100);
			tuition = tuition/100;
			studenttuition = 20000.0 + (tuition * (credits-15));
		}
		return studenttuition;
	}
	
	public String toString()
	//Display information as a String
	{
		return "Name: " + this.getName() + " | " + " Student ID:" + studentid;
	}
	public static void main(String args[])
	{
	Student s1 = new Student("john", "schulz", 111);
	System.out.println(s1.getGPA());
	s1.submitGrade(4.0, 5);
	System.out.println(s1.getGPA());
	s1.submitGrade(3.0, 3);
	s1.submitGrade(3.0, 3);
	System.out.println(s1.getGPA());
	Student s2 = new Student("katie", "monsky", 123);
	Student bb = s2.createLegacy(s2, s1);
	System.out.println(bb.getName());
	System.out.println(bb.getGPA());
	System.out.println(s1.getGPA());


	}
}