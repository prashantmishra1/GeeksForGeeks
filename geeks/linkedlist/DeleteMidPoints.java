package geeks.linkedlist;

import geeks.linkedlist.Coordinates;

public class DeleteMidPoints {
		
	public void delete(Coordinates start){
		if(start == null)
			return;
		if(start.next == null || start.next.next == null)
			return;
			
		if((start.x == start.next.x) && (start.x == start.next.next.x)){
			start.next = start.next.next;
			delete(start);
		} else if((start.y == start.next.y) && (start.y == start.next.next.y)){
			start.next = start.next.next;
			delete(start);
		} else
			delete(start.next);
		
	}
	
	public static void main(String args[]){
		DeleteMidPoints obj = new DeleteMidPoints();
		
		Coordinates start = new Coordinates(0, 10);
		start.next = new Coordinates(1, 10);
		start.next.next = new Coordinates(5, 10);
		start.next.next.next = new Coordinates(7, 10);
		start.next.next.next.next = new Coordinates(7, 5);
		start.next.next.next.next.next = new Coordinates(20, 5);
		start.next.next.next.next.next.next = new Coordinates(40, 5);
		
		System.out.println("Original Coordinates -->");
		obj.printList(start);
		obj.delete(start);
		System.out.println("\nProcessed Coordinates -->");
		obj.printList(start);
	}
	
	private void printList(Coordinates start){
		while(start != null){
			System.out.print("(" + start.x + "," + start.y + ") ");
			start = start.next;
		}
	}
}
