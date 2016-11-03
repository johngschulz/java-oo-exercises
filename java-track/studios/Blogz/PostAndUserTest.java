package Blogz;
import static org.junit.Assert.*;
import org.junit.Test;

public class PostAndUserTest {

	//User testing
	
	@Test
	public void testIsValidPassword() {
		User u1 = new User("James", "password");
		assertTrue("Problem setting hashPassword to password",u1.isValidPassword(u1.getPassword())==true);
	}
	@Test
	public void testIsValidUsername(){
		User u1 = new User("James123", "password");
		assertTrue("Problem validating a correct username", u1.isValidUsername(u1.getUsername()) == true);
		User u2 = new User("J_A_M+E-S", "pass");
		assertTrue("Problem validating an incorrect username(special characters)", u2.isValidUsername(u2.getUsername()) == false);
		User u3 = new User("123456789111315", "pass");
		assertTrue("Problem validating an incorrect username(too long)", u3.isValidUsername(u3.getUsername()) == false);
		User u4 = new User("12", "pass");
		assertTrue("Problem validating an incorrect username(too short)", u4.isValidUsername(u4.getUsername()) == false);
		
	}
	
	//Post test
	@Test
	public void testModifyPost(){
		
	}
}
