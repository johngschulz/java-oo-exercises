
public class Robot {
	//Fields: The robot has 5 fields
	private String name;
	protected int positionx;
	protected int positiony;
	protected int speed;
	protected int orientation;
	
	//Methods/ Behaviors:
	//Create a robot (constructor)
	public Robot(String name, int positionx,int positiony, int speed, int orientation)
	{
		this.name = name;
		this.positionx = positionx; //need to figure out how to use 2 coords x,y
		this.positiony = positiony;
		this.speed = speed;
		this.orientation = orientation;
	}
	

	
	public String getName()
	{
		return this.name;
	}
	public int getPositionx()
	{
		return this.positionx;
	}
	public int getPositiony()
	{
		return this.positiony;
	}
	public int getSpeed()
	{
		return this.speed;
	}
	public int getOrientation()
	{
		return this.orientation;
	}

	//Change speed
	public void changeSpeed(int newSpeed)
	{
		this.speed = newSpeed;
	}
	//Rotate orientation by +-90 degrees
	public void turnRobot(int newOrientation)
	{
		if(newOrientation % 90 == 0)
		{
			this.orientation = (newOrientation) % 360;
		}
		else
		{
			return;
		}
	}
	public void moveRobot()
	{
		if(this.orientation == 0)
			{
			this.positiony = this.positiony + this.speed;
			}
		else if(this.orientation == 90)
			{
			this.positionx = this.positionx + this.speed;
			}
		else if(this.orientation == 180)
			{
			this.positiony = this.positiony - this.speed;
			}
		else
			{
			this.positionx = this.positionx - this.speed;
			}
	}

//Must pass robot object in parameters
	public static double getDistance(Robot robot1, Robot robot2)
	//Get distance between Robots
	{
		int x1 = robot1.getPositionx();
		int y1 = robot1.getPositiony();
		int x2 = robot2.getPositionx();
		int y2 = robot2.getPositiony();
		double distance = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
		return distance;		
	}
	public double getDistanceFromSelf(Robot otherRobot)
	//Get distance from current Robot
	{
		int x1 = this.positionx;
		int y1 = this.positiony;
		int x2 = otherRobot.getPositionx();
		int y2 = otherRobot.getPositiony();
		
		double distance = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
		return distance;
	}

	
	public String toString()
	//Display information as a String
	{
		return " name: " + this.name + " | " + " position: (" + this.positionx + " , " + this.positiony + ") " +" | " + " speed: " + this.speed + "  | " +" orientation: " + this.orientation;
	}
	public static void main(String args[])
	{
		Robot myRobot = new Robot("Dave", 0, 0, 5, 0);
		System.out.println(myRobot);
		Robot yourRobot = new Robot("Michael", 5, 5, 10, 90);
		System.out.println(yourRobot);
		myRobot.moveRobot();
		System.out.println(myRobot);
		yourRobot.turnRobot(360);
		System.out.println(yourRobot);
		System.out.println(getDistance(myRobot,yourRobot));
		System.out.println(myRobot.getDistanceFromSelf(yourRobot));
	}
}

