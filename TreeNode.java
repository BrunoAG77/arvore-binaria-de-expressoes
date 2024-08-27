// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;

public class TreeNode {
	private String key; 
	private TreeNode parent; 
	private TreeNode left; 
	private TreeNode right; 
	
	public TreeNode(String key) { 
		this(key, null);
	} 

	public TreeNode(String key, TreeNode parent) { 
		this.key = key; 
		this.parent = parent; 
		this.left = null; 
		this.right = null;
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
}
