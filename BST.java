import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class BST {
	public class Node{
		public int data;
		public Node left, right;
		public Node(int item){
			data = item;
			left = null;
			right = null;
		}
	}
	public Node root;
	BST(){
		root = null;
	}
	public void insert(int key){
		root = insertRec(root, key);
	}
	public Node insertRec(Node root, int key){
		if(root == null){
			root = new Node(key);
			return root;
		}
		if(key > root.data)
			root.right = insertRec(root.right, key);
		if(key < root.data)
			root.left = insertRec(root.left, key);
		return root;
	}
	//recursive prints!!
	public void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	public void preOrder(Node root){
		if(root != null){
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public void postOrder(Node root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	//iterative prints!!
	public void preOrder_iterative(Node root){
		if(root == null)
			return;
		Stack<Node> eStack = new Stack<Node>();
		while(true){
			while(root != null){
				//print here for PreOrder
				System.out.print(root.data + " ");
				eStack.push(root);
				root = root.left;
			}
			if(eStack.isEmpty()) break;
			root = eStack.pop();
			//print here for Inorder
			//System.out.print(root.data + " ");
			root = root.right;
		}
	}
	//little different from other two,interviewers favorite.
	//visit every node twice
	public void postOrder_iterative(Node root){
		
	}
	//search
	public boolean searchKey(int key){
		Node temp = search(root, key);
		if(temp == null) 
			return false;
		else 			 
			return true;
	}
	public Node search(Node root, int key){
		if(root == null || root.data == key)
			return root;
		if(key< root.data)
			return search(root.left, key);
		return search(root.right, key);
	}
	//delete - 3 possibilities, leaf, one child, two child
	public void deleteKey(int key){
		root = delete(root, key);
	}
	public Node delete(Node root, int key){
		//base case
		if(root == null) return null;
		//find key
		if(key<root.data)
			root.left = delete(root.left, key);
		else if(key>root.data)
			root.right = delete(root.right, key);
		else{
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			//both nodes present
			root.data = getInSuccValue(root.right);
			root.right = delete(root.right, root.data);
		}
		return root;
	}
	public int getInSuccValue(Node root){
		int minVal = root.data;
		while(root.left != null){
			minVal = root.left.data;
			root = root.left;
		}
		return minVal;
	}
	//height of tree
	public int getTreeHeight(Node root){
		//base 
		if(root == null) return 0;
		int leftH = getTreeHeight(root.left);
		int rightH = getTreeHeight(root.right);
		return Math.max(leftH, rightH) +1;
	}
	//level wise & count
	public void levePrint(Node root){
		int count = 0;
		//base case
		if(root == null) return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			root = queue.remove();
			count++;
			System.out.print(root.data + " ");
			if(root.left != null)
				queue.add(root.left);
			if(root.right != null)
				queue.add(root.right);
		}
		System.out.println("\nCount :" + count);
	}
	//level wise with marker
	public void leveWiseMarker(Node root){
		//base case
		if(root == null) return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		//added a marker
		queue.add(null);
		while(!queue.isEmpty()){
			root = queue.remove();
			if(root == null){
				System.out.println();
				if(!queue.isEmpty())
					queue.add(null);
			}
			else{
				System.out.print(root.data + " ");
				if(root.left != null)
					queue.add(root.left);
				if(root.right != null)
					queue.add(root.right);
			}
		}
	}
	public int getLCACaller(int item1, int item2){
		Node temp = getLCA(root, item1, item2);
		if(temp == null)
			return -1;
		else
			return temp.data;
	}
	//lease common ancestor
	public Node getLCA(Node root, int item1, int item2){
		if(root == null)
		return null;
	
		if(item1 < root.data && item2 < root.data)
			return getLCA(root.left, item1, item2);
		else if(item1 > root.data && item2 > root.data)
			return getLCA(root.right, item1, item2);
		
			return root;
	}
	
	public void leveWiseZigZag(Node root){
		//base case
		if(root == null) return;
		Stack<Node> stack1 = new Stack<BST.Node>();
		Stack<Node> stack2 = new Stack<BST.Node>();
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			while(!stack1.isEmpty()){
				Node temp = stack1.pop();
				if(temp == null){
					System.out.println();
					if(!stack2.isEmpty())
						stack2.add(null);
				}
				else{
					System.out.print(temp.data + " ");
					//left then right
					if(temp.left != null)
						stack2.push(temp.left);
					if(temp.right != null)
						stack2.push(temp.right);
				}
			}
			while(!stack2.isEmpty()){
				Node temp1 = stack2.pop();
				if(temp1 == null){
					System.out.println();
					if(!stack1.isEmpty())
						stack1.add(null);
				}
				else{
					System.out.print(temp1.data + " ");
					//right then left
					if(temp1.right != null)
						stack1.push(temp1.right);
					if(temp1.left != null)
						stack1.push(temp1.left);
				}
			}
		}
	}
	
	//Populating Next right pointers in tree I and II
	public void connect(Node root) {
        
    }
	
	//isBST
	public boolean isBST(Node root){
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isBSTUtil(Node root, int min, int max){
		if(root == null)
			return true;
		if(root.data< min || root.data > max)
			return false;		
		return (isBSTUtil(root.left, min, root.data-1) && 
				isBSTUtil(root.right, root.data+1, max));
	}
	
}

//Iterator for BST

//public BSTIterator(TreeNode root) {
//	stack = new Stack<TreeNode>();
//	while (root != null) {
//		stack.push(root);
//		root = root.left;
//	}
//}
//
//public boolean hasNext() {
//	return !stack.isEmpty();
//}
//
//public int next() {
//	TreeNode node = stack.pop();
//	int result = node.val;
//	if (node.right != null) {
//		node = node.right;
//		while (node != null) {
//			stack.push(node);
//			node = node.left;
//		}
//	}
//	return result;
//}
