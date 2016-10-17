import static org.junit.Assert.*;

import org.junit.Test;

public class ComputerTest {

	@Test
	public void testAddMemory() {
		Computer c = new Computer(4, 100, 100, "Lenovo");
		assertTrue("Problem setting the memory in the constructor",c.getMemory() == 4);
		c.addMemory(2);
		assertTrue("Problem updating memory in addMemory", c.getMemory() == 6);

	}
	@Test
	public void testAddMemoryMax() {
		Computer c = new Computer(16, 100, 100, "Lenovo");
		assertTrue("Problem setting the memory in the constructor",c.getMemory() == 16);
		c.addMemory(2);
		assertTrue("Problem updating memory in addMemory(), when we hit maximum allowed memory", c.getMemory() == 16);

	}
}
