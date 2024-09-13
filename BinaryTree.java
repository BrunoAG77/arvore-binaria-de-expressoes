// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;

import java.util.Stack;

public class BinaryTree {
	private TreeNode root;
	private TreeNode left;
	private TreeNode right;
	
	public BinaryTree() {
		left = right = null;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean isOperator(String op) {
		return (op == "+" || op == "-" || op == "*" || op == "/") ? true : false;
	}
	
	public void createTree(Stack<String> posfix) {
	  TreeNode root = new TreeNode(posfix.pop());
  	  setRoot(root);
  	  while (!posfix.isEmpty()) {
  		  createNode(posfix.pop());
  	  }
	}
	
	public void createNode(String value) {
		if (root == null) {
			if (isOperator(value)) {
				root = new TreeNodeOperator(value.charAt(0));
			}
			else {
				root = new TreeNodeOperand(Float.parseFloat(value));
			}
		}
		else {
			createNode(root, value);
		}
	}
	
	private void createNode(TreeNode root, String value) {
			if (root.getLeft() == null) {
				root.setLeft(new TreeNode(value));
			}
			else if (root.getRight() == null) {
				root.setRight(new TreeNode(value));
			}
			else {
				createNode(root.getLeft(), value);
			}
		}
	
	public void preOrder() {
		preOrder(root);
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.getKey() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	
	private void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getKey() + " ");
			inOrder(root.getRight());
		}
	}
	
	private void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getKey() + " ");
		}
	}
}
