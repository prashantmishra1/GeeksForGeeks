package geeks.tree;

public class ChildrenSum {
	
	public boolean childrenSum(Node root){
		if(root == null)
			return true;
		
		boolean chk1 = childrenSum(root.left);
		boolean chk2 = childrenSum(root.right);
		
		if(chk1 == false || chk2==false)
			return false;
		
		int sum = sum(root.left, root.right);
		
		if(sum == 0)
			return true;
		else if(sum == root.intKey)
			return true;
		else
			return false;
		
		
	}
	
	public int sum(Node n1, Node n2){
		if(n1 != null && n2 != null)
			return n1.intKey + n2.intKey;
		else if(n1 != null)
			return n1.intKey;
		else if(n2 != null)
			return n2.intKey;
		
		return 0;
		
	}
	
	public static void main(String args[]){
		ChildrenSum obj = new ChildrenSum();
		
		Node root = new Node(100);
		
		root.left = new Node(25);
		
		root.right = new Node(75);
		
		root.left.left = new Node(10);
		
		root.left.right = new Node(15);
		
		root.right.left = new Node(25);
		
		root.right.right = new Node(50);
	
		root.right.left.left = new Node(25);
		
		root.right.left.left.left = new Node(25);
		
		root.right.left.left.left.left = new Node(25);
		
		System.out.println(obj.childrenSum(root));
	}
}

