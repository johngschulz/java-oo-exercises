package Blogz;

public abstract class Entity {
	protected static int uid = 0;
	
	public Entity(int uid) {
		uid = uid+1;
	}
	
	public int getUID() {
		return uid;
	}
	
	
}
