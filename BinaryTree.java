package apl1_ed2copy;

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
			if (!posfix.isEmpty()) {
				root = createNode(posfix);
	  	  	}
		 }
		
		private TreeNode createNode(Stack<String> posfix) {
			String value = posfix.pop();
			if (isOperator(value)) {
				TreeNodeOperator opnode = null;
				if (value == "+") {
					opnode = new Soma();
				}
				if (value == "-") {
					opnode = new Subtrai();
				}
				if (value == "*") {
					opnode = new Multiplica();
				}
				if (value == "/") {
					opnode = new Divide();
				}
				opnode.setRight(createNode(posfix));
				opnode.setLeft(createNode(posfix));
				return opnode;
			}
			else {
				TreeNodeOperand numnode = new TreeNodeOperand(Float.parseFloat(value));
				return numnode;
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
		
		public void calcular() {
			System.out.print(root.visitar());
		}
	}
