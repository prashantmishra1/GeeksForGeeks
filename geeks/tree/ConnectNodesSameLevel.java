package geeksforgeeks.tree;

public class ConnectNodesSameLevel {
	static Node node;
	public ConnectNodesSameLevel(){
		node = new Node();
	}
	public int heightOfTree(Node root){
		if(root == null){
			return 0;
		}
		
		int lDepth = heightOfTree(root.left);
		int rDepth = heightOfTree(root.right);
		
		return (lDepth > rDepth) ? lDepth+1:rDepth+1;
	}
	/*
	 * 				A
	 *           B     C'
	 *         D   E  G' H'
	 *       F       I'
	 *                J'
	 */
	public void connect(Node root, int level){
		if(root == null)
			return;
		if(level == 0){
			node.extra = root;
			node = root;
			return;
		}
		
		connect(root.left, level-1);
		connect(root.right, level-1);
	}
	
	public boolean printLevel(Node root, int level){
		if(root == null)
			return false;
		if(level == 0){
			while(root != null){
				System.out.print(root.key + " ");
				root = root.extra;
			}
			System.out.println();
			
			return true;
		}else{
			if(!printLevel(root.left, level-1))
				return(printLevel(root.right, level-1));
			else
				return true;
		}
		
		
	}
	
	public static void main(String args[]){
		Node root = new Node();
		root.key = "A";
		
		root.left = new Node();
		root.left.key = "B";
		
		root.right = new Node();
		root.right.key = "C";
		
		root.left.left = new Node();
		root.left.left.key = "D";
		
		root.left.right = new Node("E");
		
		root.left.left.left = new Node("F");
		
		root.right.left = new Node("G");
		
		root.right.right = new Node();
		root.right.right.key = "H";
		
		root.right.left.left = new Node();
		root.right.left.left.key = "I";
		
		root.right.left.left.right = new Node("J");
		
		ConnectNodesSameLevel obj = new ConnectNodesSameLevel();
		int height = obj.heightOfTree(root);
		
		for(int i=height-1; i>=0; i--){
			node.key = null;
			node.left = node.right = null;
			obj.connect(root, i);
			obj.printLevel(root, i);
		}
	}

}

