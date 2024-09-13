// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;

import java.util.Stack;

public class ConvertStack {
	public int precedence(String op) {
		if (op == "+" || op == "-") {
			return 1;
		}
		    
		if (op == "*" || op == "/") {
			return 2;
		}
		return 0;
	}
	
	public void conversao(Stack<String> expressao, Stack<String> posfix) {
	    Stack<String> pilha = new Stack<>();

	    for(int i = 0; i < expressao.size(); i++) {
	      String c = expressao.get(i);
	      if (Character.isDigit(c.charAt(0))) {
	    	  posfix.push(c);
	      }
	      else if(c == "+" || c == "-" || c == "*" || c == "/") {
	        while (!pilha.isEmpty() && precedence(pilha.peek()) >= precedence(c)){
	          posfix.push(pilha.pop());
	        }
	        pilha.push(c);
	      }
	      else if(c == "(") {
	        pilha.push(c);
	      }
	      else if(c == ")") {
	        while (!pilha.isEmpty() && pilha.peek() != "(") {
	          posfix.push(pilha.pop());
	        }
	        pilha.pop();
	      }
	    }
	    while (!pilha.isEmpty()) {
	      posfix.push(pilha.pop());
	    }
	}
}
