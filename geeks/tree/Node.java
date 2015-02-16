package geeks.tree;

public class Node {
	public int intKey;
	public String key;
	public Node left, right;
	public Node extra;
	
	public Node(){
		key = "default";
		this.left = this.right = this.extra = null;
	}

	public Node(String key){
		this();
		this.key = key;
	}
	
	public Node(int intKey){
		this.intKey = intKey;
		this.left = this.right = this.extra = null;
		
	}
}

