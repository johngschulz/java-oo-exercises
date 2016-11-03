package Blogz;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class User extends Entity {
	private String username;
	private String password;
	private static String hashPassword;
	private static ArrayList<User> userlist = new ArrayList<User>();

	
	public User(String username, String password){
		super(uid);
		this.username = username;
		this.password = password;
		hashPassword = this.password;
		userlist.add(this);
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public static String hashPassword(){
		return hashPassword;
	}
	public boolean isValidPassword(String password){
		return password == hashPassword;
	}
	public boolean isValidUsername(String username){
			boolean b = Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
			return b;
		}
	public static ArrayList<User> userList(){
		return userlist;
	}
	public String toString()
	//Display information as a String
	{
		return (username + " " + password);
	}

}
