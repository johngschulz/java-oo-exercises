package Blogz;
import java.util.Date;

public class Post {
	private String body;
	private String title;
	private String author;
	private final Date created;
	private Date modified;
	

	public Post(String body, String title, String author){
		this.body = body;
		this.title = title;
		this.author = author;
		this.created = new Date();
	}
	public String getBody(){
		return body;
	}
	public String getTitle(){
		return title;
	}
	public String getAuthor(){
		return author;
	}
	public void modifyTitle(String newTitle){
		title = newTitle;
		modified = new Date();
	}
	public void modifyBody(String newBody){
		body = newBody;
		modified = new Date();
	}
	public String toString(){
		return this.title + " " + this.body + " " + this.author + " " + this.created;
	}
	public static void main(String args[]){
		Post first = new Post("This is my first post", "First", "John");
		System.out.println(first);
		first.modifyBody("I could do better for a first post");
		first.modifyTitle("Skipping to 2nd");
		System.out.println(first);
		System.out.println(first.modified);

	}
}
