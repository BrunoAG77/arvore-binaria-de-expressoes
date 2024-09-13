// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;

public class TreeNode {
	protected String key; 
	protected TreeNode parent; 
	protected TreeNode left; 
	protected TreeNode right; 
	
	public TreeNode(String key) { 
		this(key, null);
	} 

	public TreeNode(String key, TreeNode parent) { 
		this.key = key; 
		this.parent = parent; 
		this.left = null; 
		this.right = null;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	public Object getKey() {
		return key;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public void getParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public TreeNode getRoot(TreeNode Parent) {
		return parent;
	}

	public boolean isRoot() { 
		return parent == null;
	} 

	public boolean isLeaf() { 
		return left == null && right == null; 
	} 

	public int getDegree() { 
		int degree = 0; 
		if (left != null) ++degree; 
		if (right != null) ++degree; 
		return degree;
	} 
	
	public int getLevel() {
		if (isRoot()) return 0;
		return parent.getLevel() + 1;
	} 
	
	public int getHeight() {
		if (isLeaf()) return 0;
		return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight());
	} 
	
	public float visitar() {
		return Float.NaN;
	}
}
