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
	
	public void createTree(float value) {
		if (root == null) {
			root = new TreeNode(value);
		}
		else {
			createTree(root, value);
		}
	}
	
	private void createTree(TreeNode root, float value) {
		if (root.getKey() < value) {
			if (root.getLeft() == null) {
				root.setLeft(new TreeNode(value));
			}
			else {
				createTree(root.getLeft(), value);
			}
		}
		else if (root.getKey() > value) {
			if (root.getRight() == null) {
				root.setRight(new TreeNode(value));
			}
			else {
				createTree(root.getRight(), value);
			}
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
			System.out.println(root.getKey() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	
	private void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.println(root.getKey() + " ");
			inOrder(root.getRight());
		}
	}
	
	private void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.println(root.getKey() + " ");
		}
	}
	

		 /* public double calcular(String expressao, int[] variaveis) {
		      Stack valores = new Stack();

		      for (int i = 0; i < expressao.length(); i++) {
		          char c = expressao.charAt(i);
		        
		          if (c == '+' || c == '-' || c == '*' || c == '/') {
		              valores.pop();
		          } 
		         
		          else if (Character.isDigit(c)) {
		              StringBuilder numBuilder = new StringBuilder();
		              while (i < expressao.length() && (Character.isDigit(expressao.charAt(i)) || expressao.charAt(i) == '.')) {
		                  numBuilder.append(expressao.charAt(i));
		                  i++;
		              }
		              i--;
		          }
		      }
		      return valores.pop();
		  }*/
}
