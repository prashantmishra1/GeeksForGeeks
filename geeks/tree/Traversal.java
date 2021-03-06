package geeks.tree;

import geeks.tree.Node;
import java.util.*;

public class Traversal {
	
	private static int min_span, max_span;
	
	public Traversal(){
		min_span = max_span = 0;
	}
	
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
	
	public void iterativePreOrder(Node root){
		Stack<Node> st = new Stack<Node>();
		Node node;
		while(true){
			while(root != null){
				System.out.print(root.key + " ");
				st.push(root);
				root = root.left;
			}
			
			if(st.empty()) break;
			
			node = st.pop();
			root = node.right;
			
		}
	}
	
	public void iterativePostOrder(Node root){
		Stack<Node> st = new Stack<Node>();
		Node node;
		while(true){
			while(root != null){
				st.push(root);
				root = root.left;
			}
			node = st.peek();
			if(node.right == null){
				System.out.print(node.key + " ");
				st.pop();
			}
			
			root = st.peek().right;
			
			
			if(st.empty()) break;
			
			
			
		}
	}
	
	private void findSpan(Node root, int dist){
		if(root == null)
			return;
		
		findSpan(root.left, dist-1);
		min_span = (dist < min_span) ? dist:min_span;
		findSpan(root.right, dist+1);
		max_span = (dist > max_span)? dist:max_span;
	}
	
	private void printVertical(Node root, int current_dist, int line_no){
		if(root == null)
			return;
		
		if(current_dist == line_no)
			System.out.print(root.key + " ");
		
		printVertical(root.left, current_dist-1, line_no);
		printVertical(root.right, current_dist+1, line_no);
	}
	 
	public void verticalTraversal(Node root){
		int i = 0;
		findSpan(root, 0);
		
		for (i = min_span; i <= max_span; i++){
			printVertical(root, 0, i);
		}
		
		min_span = max_span = 0;
	}
	
	public int heightOfTree(Node root){
		if(root == null){
			return 0;
		}
		
		int lDepth = heightOfTree(root.left);
		int rDepth = heightOfTree(root.right);
		
		return (lDepth > rDepth) ? lDepth+1:rDepth+1;
	}
	
	public void levelOrderTraversal(Node root){
		int height = heightOfTree(root);
		System.out.println("Height of Tree: " + height);
		for(int i = 0; i<=height; i++)
			printLevelOrder(root, 0, i);
	}
	
	private void printLevelOrder(Node root, int start, int level){
		if(root == null)
			return;
		if(start == level){
			System.out.print(root.key + " ");
		}
		
		printLevelOrder(root.left, start + 1, level);
		printLevelOrder(root.right, start + 1, level);
	}

		public void zigzagTraversal(Node root){
		int turn = 0;
		int height = heightOfTree(root);
		for(int a=0; a<height; a++){
			printZigZag(root, a, turn);
			turn = 1-turn;
			
		}
	}
	
	private void printZigZag(Node root, int level, int x){
		if(root == null)
			return;
		if(level == 0){
			System.out.print(root.key + " ");
			return;
		}
		else if(x == 0){
			printZigZag(root.left, level-1, x);
			printZigZag(root.right,level-1, x);
		}else{
			printZigZag(root.right, level-1, x);
			printZigZag(root.left, level-1, x);
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
		
		root.right.left.left.left = new Node();
		root.right.left.left.left.key = "I";
		
		root.right.left.left.left.left = new Node();
		root.right.left.left.left.left.key = "J";
		
		Traversal obj = new Traversal();
		
		System.out.println("\nIn Order Traversal (recursive) -->");
		obj.recursiveInOrder(root);
		
		System.out.println("\nIn Order Traversal (iterative) -->");
		obj.iterativeInOrder(root);
		
		System.out.println("\nPre Order Traveral (recursive) -->");
		obj.recursivePreOrder(root);
		
		System.out.println("\nPre Order Traveral (iterative) -->");
		obj.iterativePreOrder(root);
		
		System.out.println("\nPost Order Traveral (recursive) -->");
		obj.recursivePostOrder(root);
		
		//System.out.println("\nPost Order Traversal (iterative) -->");
		//obj.iterativePostOrder(root);
		
		System.out.println("\nVertical Traversal (recursive) -->");
		obj.verticalTraversal(root);
		
		System.out.println("\nLevel Order Traversal (recursive) -->");
		obj.levelOrderTraversal(root);

		System.out.println("\nZigZag Traversal (recursive) -->");
		obj.zigzagTraversal(root);
		
	}
}
