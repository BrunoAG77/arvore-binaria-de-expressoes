package apl1_ed2;

public class TreeNodeOperator extends TreeNode {
	
	private char operator;

	public TreeNodeOperator(int key, TreeNode parent, char operator) {
		super(key, parent);
		this.operator = operator;
	}
	
	public static boolean isOperator(char op) {
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
    	if (operator == '+'){
    		return getRight().getKey() + getLeft().getKey();
        }
        if (operator == '-'){
        	return getRight().getKey() - getLeft().getKey();
        }
        if (operator == '*'){
        	return getRight().getKey() * getLeft().getKey();
        }
        if (operator == '/'){
        	try{
        		return getRight().getKey() / getLeft().getKey();
            }
            catch(ArithmeticException e){
            	System.out.println("Erro: Divisão por zero.");
            }
        }
        else{
        	throw new IllegalArgumentException("Operador inválido: " + operator);
        }
        return 1;
    }

}
