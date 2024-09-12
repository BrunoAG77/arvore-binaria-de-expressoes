// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;

public class TreeNodeOperand extends TreeNode {
	
	private float operand;
	
	public TreeNodeOperand(float operand) {
		super(operand, null);
		this.operand = operand;
	}
	
	public float visitarOperando() {
		return operand;
	}

}
