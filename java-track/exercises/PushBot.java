
public class PushBot extends Robot {
	
	public PushBot(String name, int positionx,int positiony, int speed, int orientation)
	{
		super (name, positionx, positiony, speed, orientation);
	}
	public void push(Robot r2)
	{
		double d = this.getDistanceFromSelf(r2);
		if (d < 5)
		{
			int oldspeed = r2.getSpeed();
			r2.changeSpeed(this.getSpeed());
			int oldori = r2.getOrientation();
			r2.turnRobot(this.getOrientation());
			r2.moveRobot();
			r2.turnRobot(oldori);
			r2.changeSpeed(oldspeed);
		}
	}
	public static void main(String args[])
	{
		PushBot pb1 = new PushBot("Pusher", 5, 5, 5, 90);
		Robot r1 = new Robot("Roberto", 7, 7, 3, 180);
		System.out.println(pb1.getDistanceFromSelf(r1));
		System.out.println(pb1);
		System.out.println(r1);
		pb1.push(r1);
		System.out.println(pb1);
		System.out.println(r1);
	}
}
