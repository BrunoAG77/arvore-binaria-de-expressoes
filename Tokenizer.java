// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
	private char[] expression;
	private int i;
	
	public Tokenizer(String infix) {
		expression = infix.toCharArray();
		i = 0;
	}
	
	private char getNextChar() {
		if (i >= expression.length) {
			return '\0';
		}
		return expression[i++];
	}
	
	public List<Object> tokenize(){
		List<Object> tokens = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		char aux = getNextChar();
		boolean tokenizing = true;
		do {
			while (Character.isWhitespace(aux)) {
				aux = getNextChar();
			} 
			if (Character.isDigit(aux)) {
				sb.setLength(0);
				do {
					sb.append(aux);
					aux = getNextChar();
					if (aux == '.') {
						sb.append(aux);
						aux = getNextChar();
					}
				} while (Character.isDigit(aux));
				tokens.add(Float.parseFloat(sb.toString()));
			}
			else if (aux == '+' || aux == '-' || aux == '*' || aux == '/') {
				tokens.add(aux);
				aux = getNextChar();
			}
			else if (aux == '(' || aux == ')') {
				tokens.add(aux);
				aux = getNextChar();
			}
			else if (aux == '\0') {
				tokenizing = false;
			}
			else {
				System.out.println("Token não reconhecido: " + aux);
				tokenizing = false;
			}
		} while (tokenizing);
		return tokens;
	}
}
