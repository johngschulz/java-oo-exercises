import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void testChangeSpeed() {
		Robot r = new Robot("Dave", 0, 0, 1, 0);
		assertTrue("Problem setting speed in the constructor", r.getSpeed() == 1);
		r.changeSpeed(5);
		assertTrue("Problem changing speed in changeSpeed()", r.getSpeed() == 5);
	}
	

	@Test
	public void testTurnRobot(){
		Robot t = new Robot("Dave", 0, 0, 0, 90);
		assertTrue("Problem setting orientation in the constructor", t.getOrientation() == 90);
		t.turnRobot(180);
		assertTrue("Problem changing the orientation in turnRobot()", t.getOrientation() == 180);
	}
	@Test
	public void testMoveRobot(){
		Robot m = new Robot("Dave", 0, 0, 10, 0);
		m.moveRobot();
		assertTrue("Problem moving robot with moveRobot() in y axis", m.getPositiony() == 10);
		m.turnRobot(90);
		m.moveRobot();
		assertTrue("Problem moving robot with moveRobot() in x axis", m.getPositionx() == 10);
	}
	@Test
	public void testDistanceFromRobot(){
		Robot a = new Robot("Andy", 0,0,0,0);
		Robot b = new Robot("Brian",10, 0, 0, 0);
		assertTrue("Problem getting distance using getDistanceFromSelf()", a.getDistanceFromSelf(b)  == 10.0);
	}
	@Test
	public void testMakeBaby(){
		MomBot a = new MomBot("Sharon", 0, 0, 0 , 0);
		Robot b = new Robot("Bill", 1, 1, 1, 90);
		Robot c = a.makeBaby(b);
		assertTrue("Problem creating setting new babyRobot name using makeBaby()", c.getName().contains("BabyBill0"));
		assertTrue("Problem setting new babyRobot speed using makeBaby()", c.getSpeed() == 1);
	}
	@Test
	public void testPush(){
		PushBot a = new PushBot("Sharon", 0, 0, 5, 0);
		Robot b = new Robot("Bill", 0, 0, 5, 90);
		a.push(b);
		assertTrue("Problem moving pushed Robot using push()", b.getPositiony() == 5);
		assertTrue("Problem resetting original Robot orientation using push()", b.getOrientation() == 90);
	}
}
