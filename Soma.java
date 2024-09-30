// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4
package apl1_ed2copy;

public class Soma extends TreeNodeOperator {
	public Soma() {
		super('+');
	}
	
	public float visitar() {
		float left = getLeft().visitar();
		float right = getRight().visitar();
		return left + right;
	}
}
