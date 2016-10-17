package studio2;

public class Rectangle {
	private Integer length;
	private Integer width;
	
	public Rectangle(Integer length, Integer width){
		this.length = length;
		this.width = width;
	}
	public Integer getLength(){
		return this.length;
	}
	public Integer getWidth(){
		return this.width;
	}
	public Integer getArea(){
		return (this.length * this.width);
	}
	public Integer getPerimeter(){
		return (this.length * 2 + this.width *2);
	}
	public boolean isSquare(){
		return (this.length == this.width);
	}
	public boolean isSmaller(Rectangle otherRectangle){
		return (this.getArea() < otherRectangle.getArea());
	}
	public String toString(){
		return "Length: " + this.length + " Width: " + this.width;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle myRectangle = new Rectangle(5,5);
		System.out.println(myRectangle);
		System.out.println(myRectangle.isSquare());
		System.out.println(myRectangle.getArea());
		System.out.println(myRectangle.getPerimeter());
		Rectangle yourRectangle = new Rectangle (5,5);
		System.out.println(myRectangle.isSmaller(yourRectangle));
		System.out.println(yourRectangle.isSquare());
	}

}
