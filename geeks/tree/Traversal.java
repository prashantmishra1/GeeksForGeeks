package geeks.tree;

import geeks.tree.Node;
import java.util.*;

public class Traversal {
	
	public void recursiveInOrder(Node root){
		if(root == null)
			return;
	
		recursiveInOrder(root.left);
		System.out.print(root.key + " ");
		recursiveInOrder(root.right);
	}
	
	public void recursivePreOrder(Node root){
		if(root == null){
			return;
		}
		
		System.out.print(root.key + " ");
		recursivePreOrder(root.left);
		recursivePreOrder(root.right);
	}
	
	public void recursivePostOrder(Node root){
		if(root == null)
			return;
		
		recursivePostOrder(root.left);
		recursivePostOrder(root.right);
		System.out.print(root.key + " ");
	}
	
	public void iterativeInOrder(Node root){
		Stack<Node> st = new Stack<Node>();
		Node node;
		while(true){
			while(root != null){
				st.push(root);
				root = root.left;
			}
			
			if(st.empty()) break;
			
			node = st.pop();
			System.out.print(node.key + " ");

			root = node.right;	
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
		
		root.left.right = new Node();
		root.left.right.key = "E";
		
		root.right.left = new Node();
		root.right.left.key = "F";
		
		root.right.right = new Node();
		root.right.right.key = "G";
		
		root.right.left.left = new Node();
		root.right.left.left.key = "H";
		
		Traversal obj = new Traversal();
		System.out.println("In Order Traversal (recursive) -->");
		obj.recursiveInOrder(root);
		
		System.out.println("\nIn Order Traversal (iterative) -->");
		obj.iterativeInOrder(root);
		
		System.out.println("\nPre Order Traveral (recursive) -->");
		obj.recursivePreOrder(root);
		
		System.out.println("\nPost Order Traveral (recursive) -->");
		obj.recursivePostOrder(root);
		
	}
}

