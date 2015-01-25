package geeks.linkedlist;

public class Coordinates {
	
	public double x, y;
	public Coordinates next;
	
	public Coordinates(){
		x = y = 0;
		next = null;
	}
	
	public Coordinates(double x, double y){
		this.x = x;
		this.y = y;
		
		this.next = null;
	}
}

