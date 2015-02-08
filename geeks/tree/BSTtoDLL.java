package geeks.tree;

public class BSTtoDLL {
	
	public void convert(Node root){
		if(root == null)
			return;
		
		if(root.left != null){
			convert(root.left);
			Node node = root.left;
			while(node.right != null){
				node = node.right;
			};
			
			node.right = root;
			root.left = node;
		}
		
		if(root.right != null){
			convert(root.right);
			Node node = root.right;
			while(node.left != null){
				node = node.left;
			};

			root.right = node;
			node.left = root;
		}

	}
	
	public static void main(String args[]){
		BSTtoDLL obj = new BSTtoDLL();
		
		Node root = new Node("100");
		
		root.left = new Node("50");
		root.right = new Node("150");
		
		root.left.left = new Node("25");
		root.left.right = new Node("75");
		
		root.right.left = new Node("125");
		root.right.right = new Node("175");
		
		root.left.right.left = new Node("60");
		root.left.right.right = new Node("90");
		
		root.right.right.right = new Node("200");
		
		Node head = root.left.left;
		obj.convert(root);
		
		obj.traverseDLL(head);
		
		
		
	}
	
	public void traverseDLL(Node head){
		while(head != null){
			System.out.print(head.key + "<->");
			head = head.right;
		}
	}

}

