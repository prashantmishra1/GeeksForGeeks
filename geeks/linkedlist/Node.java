package geeks.linkedlist;

public class Node {
	public String key;
	public Node next;
	public Node previous;
	
	public Node(){
		key = "default";
		next = previous = null;
	}
	
	public Node(String key){
		this.key = key;
		next = previous = null;
	}

}

