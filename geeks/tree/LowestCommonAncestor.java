package geeks.tree;

import geeks.tree.Node;

public class LowestCommonAncestor {
	public Node findLCA(Node root, Node n1, Node n2){
		if(root == null)
			return root;
		
		if(root.key == n1.key || root.key == n2.key){
			return root;
		}
		
		Node left_LCA = findLCA(root.left, n1, n2);
		Node right_LCA = findLCA(root.right, n1, n2);
		
		if(left_LCA != null && right_LCA != null)
			return root;
		else if(left_LCA != null)
			return left_LCA;
		else
			return right_LCA;
		
	}
	
	public static void main(String args[]){
		LowestCommonAncestor obj = new LowestCommonAncestor();
		
		Node root = new Node();
		root.key = "A";
		
		root.left = new Node();
		root.left.key = "B";
		
		root.right = new Node();
		root.right.key = "C";
		
		root.left.left = new Node();
		root.left.left.key = "D";
		
		root.left.right = new Node();
		root.left.right.key = "E";
		
		root.right.left = new Node();
		root.right.left.key = "F";
		
		root.right.right = new Node();
		root.right.right.key = "G";
		
		root.right.left.left = new Node();
		root.right.left.left.key = "H";
		
		System.out.println(obj.findLCA(root, root.right.left, root.right.left.left).key);
	}

}

