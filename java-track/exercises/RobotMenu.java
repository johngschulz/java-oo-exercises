import java.util.Scanner;
import java.util.ArrayList;

public class RobotMenu {
	private ArrayList<Robot> robots;
	private Scanner s;
	
	public static void main(String[] args){
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.startMenu();
			rm.processInput(x);
		}while (x != 6);
	}
		public RobotMenu()
		{
			s = new Scanner(System.in);
			robots = new ArrayList<Robot>();
		}
		public int startMenu()
		{
			System.out.println("Welcome to the Robot menu!");
			System.out.println("1. Create a Robot!");
			System.out.println("2. Display available Robots!");
			System.out.println("3. Move a Robot!");
			System.out.println("4. Rotate a Robot!");
			System.out.println("5. Find the distance between Robots!");
			System.out.println("6. Exit the Robot menu!");
			int selection = s.nextInt();
			while(selection <0 || selection >6)
			{
				System.out.println("Invalid selection, try again: ");
				selection = s.nextInt();
			}
			return selection;
		}
		public void processInput(int selection)
		{
			if (selection == 1)
			{
				createRobot();
			}
			else if (selection == 2)
			{
				displayRobots();
			}
			else if (selection == 3)
			{
				displayRobots();
				Robot r = selectRobot();
				r.moveRobot();
				System.out.println("Here is the status of your robot after moving: ");
				System.out.println(r);
			}
			else if (selection == 4)
			{
				displayRobots();
				Robot r = selectRobot();
				System.out.println("Please enter the desired turn direction: Right=1, Left=2");
				int direction = s.nextInt();
				while(direction <0 || direction >3)
				{
					System.out.println("Invalid selection, try again: ");
					direction = s.nextInt();
				}
				if (direction == 1){
					r.turnRobot(90);
				}
				else{
					r.turnRobot(-90);
				}
			}
			else if (selection == 5)
			{
				displayRobots();
				Robot r1 = selectRobot();
				Robot r2 = selectRobot();
				double d = r1.getDistanceFromSelf(r2);
				System.out.println("The distance between the selected Robots is: " + d);
			}
		}
		private void displayRobots()
		{
			for(int i = 0; i < robots.size(); i++)
			{
				System.out.println((i+1) + ".)" + robots.get(i));
			}
		}
		private Robot selectRobot()
		{
			System.out.println("Please select a Robot: ");
			int selection = s.nextInt();
			while (selection < 0 || selection > robots.size()){
				System.out.println("Invalid selection please try again: ");
				selection = s.nextInt();
				}
			return robots.get(selection-1);
		}
		private void createRobot()
		{
			System.out.println("Please enter the Robot name: ");
			String name = s.next();
			
			System.out.println("Please enter Robot position x: ");
			int posx = s.nextInt();
			
			System.out.println("Please enter Robot position y: ");
			int posy = s.nextInt();

			System.out.println("Please enter the Robot speed: ");
			int speed = s.nextInt();

			System.out.println("Please enter the Robot Orientation: 1 = North, 2 = East, 3 = South, 4 = West: ");
			int dir = s.nextInt();
			int ori = 0;
			while (dir < 1 || dir > 4){
				System.out.print("Invalid input, try again");
				dir = s.nextInt();
			}
			if (dir == 1){
				ori = 0;
			}
			else if (dir == 2){
				ori = 90;
			}
			else if (dir == 3){
				ori =180;
			}
			else if(dir == 4){
				ori = 270;
			}
			robots.add(new Robot(name, posx, posy, speed, ori));
		}
}



