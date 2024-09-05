// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;

import java.util.Stack;

public class BinaryTree {
	public TreeNode root;
	
	
	public void createTree(int expression) {
		if (root == null) {
			root = new TreeNode(expression);
		}
		TreeNode newnode = new TreeNode(expression);
		createTree(root, newnode);
	}
	
	private void createTree(TreeNode root, TreeNode newnode) {
		if (newnode.key > root.key) {
			if (root.getRight() == null) {root.setRight(newnode);}
			else {createTree(root.getRight(), newnode);}
		}
		else if (newnode.key < root.key) {
			if (root.getLeft() == null) {root.setLeft(newnode);}
			else {createTree(root.getLeft(), newnode);}
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
		System.out.println(root.getKey());
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}
	
	private void inOrder(TreeNode root) {
		inOrder(root.getLeft());
		System.out.println(root.getKey());
		inOrder(root.getRight());
	}
	
	private void postOrder(TreeNode root) {
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.println(root.getKey());
	}
	

		  /*public double calcular(String expressao, int[] variaveis) {
		      Stack valores = new Stack();

		      for (int i = 0; i < expressao.length(); i++) {
		          char c = expressao.charAt(i);
		        
		          if (isOperator(c)) {
		              valores.pop();
		              valores.pop();
		          } 
		      }
		      return valores.pop();
		  }*/
}
