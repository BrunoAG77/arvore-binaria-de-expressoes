package apl1_ed2;

public class TreeNodeOperand extends TreeNode {
	
	private float operand;
	
	public TreeNodeOperand(int key, TreeNode parent, float operand) {
		super(key, parent);
		this.operand = operand;
	}
	
	public float visitar() {
		return operand;
	}

}
