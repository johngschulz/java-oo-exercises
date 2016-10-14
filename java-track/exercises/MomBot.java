
public class MomBot extends Robot {
	int babiesMade;
	public MomBot(String name, int positionx,int positiony, int speed, int orientation)
	{
		super(name, positionx, positiony, speed, orientation);
		this.babiesMade = 0;
	}
	public Robot makeBaby(Robot r1)
	{
		Robot baby = new Robot("Baby"+r1.getName()+babiesMade,this.getPositionx()-10, this.getPositiony()+10, 1, this.getOrientation()+180);
		babiesMade = babiesMade + 1;
		return baby;
	}
	
	public static void main(String args[])
	{
		Robot r1 = new Robot("Roberto", 7, 7, 3, 180);
		MomBot mb1 = new MomBot("Roberta", 6, 6, 3, 180);
		Robot nb = mb1.makeBaby(r1);
		System.out.println(r1);
		System.out.println(mb1);
		System.out.println(nb.getName());
		MomBot a = new MomBot("Sharon", 0, 0, 0 , 0);
		Robot b = new Robot("Bill", 1, 1, 1, 1);
		Robot c = a.makeBaby(b);
		System.out.println(c.getName());
		
	}
}
