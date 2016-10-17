
public class Laptop extends Computer {
	
	private boolean isClosed;
	
	public Laptop(int memory, double size, double processor, String brand){
		super(memory, size, processor, brand);
		this.isClosed = true;
	}
	public void close(){
		isClosed = true;
	}
	public void open(){
		isClosed = false;
	}
	public static void main(String args[]){
		Laptop l1 = new Laptop(1,1,1,"Lenovo");
		l1.open();
		l1.addMemory(5);
		System.out.print(l1.isClosed);
	}
}
