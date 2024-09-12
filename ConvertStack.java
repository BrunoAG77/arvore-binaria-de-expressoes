// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;

import java.util.Stack;

public class ConvertStack {
	public int precedence(char op) {
		if (op == '+' || op == '-') {
			return 1;
		}
		    
		if (op == '*' || op == '/') {
			return 2;
		}
		return 0;
	}
	
	  public String conversao(Stack<Object> expressao) {
		    StringBuilder posfix = new StringBuilder();
		    Stack<Character> pilha = new Stack<>();
		    for(int i = 0; i < expressao.size(); i++) {
		      Object token = expressao.get(i);
		      if (token instanceof Character) {
		    	  char c = (Character) token;
		    	  if (Character.isDigit(c)) {
		    		  posfix.append(c).append(' ');
		    	  }
		    	  else if(c == '+' || c == '-' || c == '*' || c == '/') {
		    		  while (!pilha.isEmpty() && precedence(pilha.peek()) >= precedence(c)){
		    			  posfix.append(pilha.pop());
		    		  }
		    		  pilha.push(c);
		    	  }
		    	  else if(c == '(') {
		    		  pilha.push(c);
		    	  }
		    	  else if(c == ')') {
		    		  while (!pilha.isEmpty() && pilha.peek() != '(') {
		    			  posfix.append(pilha.pop());
		    		  }
		    		  pilha.pop();
		      		}
		      }
		      else if (token instanceof Float) {
		    	  posfix.append(token.toString());
		      }
		    }
		    while (!pilha.isEmpty()) {
		      posfix.append(pilha.pop());
		    }

		    return posfix.toString();
		  }
}
