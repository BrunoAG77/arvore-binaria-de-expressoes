// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;

public class TreeNodeOperator extends TreeNode {
	
	private char operator;

	public TreeNodeOperator(char operator) {
		super(String.valueOf(operator));
		this.operator = operator;
	}
	
	public boolean isOperator(char op) {
		return (op == '+' || op == '-' || op == '*' || op == '/') ? true : false;
	}

	public int precedence(char op) {
		if (op == '+' || op == '-') {
			return 1;
		}
		    
		if (op == '*' || op == '/') {
			return 2;
		}
		return 0;
	}
	
    public float visitar() {
    	if (isOperator(operator)) {
    		float left = getLeft().visitar();
    		float right = getRight().visitar();
    		if (operator == '+'){
    			Soma add = new Soma();
    			return add.somar(left, right);
    		}
    		if (operator == '-'){
    			Subtrai less = new Subtrai();
    			return less.subtrair(left, right);
    		}
    		if (operator == '*'){
    			Multiplica mult = new Multiplica();
    			return mult.multiplicar(left, right);
    		}
    		if (operator == '/'){
    			Divide div = new Divide();
    			return div.dividir(left, right);
    		}
    		else{
    			throw new IllegalArgumentException("Operador inválido: " + operator);
    		}
    	}
        return 1;
    }

}
