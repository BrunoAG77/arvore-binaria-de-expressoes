// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;

public class BinaryTree {
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

		  public double calcular(String expressao, int[] variaveis) {
		      pilhadouble valores = new pilhadouble(expressao.length());

		      for (int i = 0; i < expressao.length(); i++) {
		          char c = expressao.charAt(i);
		        
		          if (isOperator(c)) {
		              double n2 = valores.pop();
		              double n1 = valores.pop();
		              double res = doOperation(n1, n2, c);
		              valores.push(res);
		          } 
		            
		          else if (Character.isLetter(c)) {
		              int iVar = Character.toUpperCase(c) - 'A';
		              if (iVar >= 0 && iVar < variaveis.length) {
		                  valores.push((double) variaveis[iVar]);
		              } 
		              else {
		                  throw new IllegalArgumentException("Variável fora do intervalo: " + c);
		              }
		          } 
		          else if (Character.isDigit(c)) {
		              StringBuilder numBuilder = new StringBuilder();
		              while (i < expressao.length() && (Character.isDigit(expressao.charAt(i)) || expressao.charAt(i) == '.')) {
		                  numBuilder.append(expressao.charAt(i));
		                  i++;
		              }
		              i--;
		              valores.push(Double.parseDouble(numBuilder.toString()));
		          }
		      }
		      return valores.pop();

		    public double doOperation(double n1, double n2, char op) {
		            if (op == '+'){
		                return n1 + n2;
		            }
		            if (op == '-'){
		                return n1 - n2;
		            }
		            if (op == '*'){
		                return n1 * n2;
		            }
		            if (op == '/'){
		                try{
		                  return n1 / n2;
		                }
		                catch(ArithmeticException e){
		                  System.out.println("Erro: Divisão por zero.");
		              }
		            }
		            if (op == '^'){
		                return Math.pow(n1, n2);
		            }
		            else{
		                throw new IllegalArgumentException("Operador inválido: " + op);
		            }
		    }
}
