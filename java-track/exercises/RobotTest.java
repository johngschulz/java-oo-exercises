import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void testChangeSpeed() {
		Robot r = new Robot("Dave", 0, 0, 0, 0);
		assertTrue("Problem setting speed in the constructor", r.getSpeed() == 0);
		r.changeSpeed(5);
		assertTrue("Problem changing speed in changeSpeed()", r.getSpeed() == 5);
	}
	

	@Test
	public void testTurnRobot(){
		Robot t = new Robot("Dave", 0, 0, 0, 0);
		assertTrue("Problem setting orientation in the constructor", t.getOrientation() == 0);
		t.turnRobot(90);
		assertTrue("Problem changing the orientation in turnRobot()", t.getOrientation() == 90);
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
}
