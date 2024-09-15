// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;
import java.util.Scanner;
import java.util.List;
import java.util.Stack;
import java.util.EmptyStackException;
import java.lang.NullPointerException;
import java.lang.NumberFormatException;

public class Main {
  public static void menu() {
    Scanner scan = new Scanner(System.in);
    String infix = "";
    BinaryTree tree = new BinaryTree();
    List<String> tokens = null;
    Stack<String> expression = new Stack<>();
    Stack<String> posfix = new Stack<>();
    ConvertStack inpos = new ConvertStack();
    
    do {
      System.out.println("\n---Árvore binária de expressão aritmética---\n1. Entrada da expressão aritmética na notação infixa.\n2. Criação da árvore binária de expressão aritmética.\n3. Exibição da árvore binária de expressão aritmética.\n4. Cálculo da expressão (realizando o percurso da árvore).\n5. Encerramento do programa.");
      String opcao = scan.nextLine();
      if (opcao.equals("1")) {
        System.out.println("Digite a expressão na notação infixa: ");
        infix = scan.nextLine();
        Tokenizer token = new Tokenizer(infix);
        tokens = token.tokenize();
      }
      
      else if (opcao.equals("2")) {
    	try {
    		if (infix.isEmpty()) {
    	          System.out.println("Erro. Não há expressão na memória. Volte à Opção 1.");
    	        }
    	        else {
    	          for (int i = 0; i < tokens.size(); i++) {
    	        	  String token = tokens.get(i);
    	        	  expression.push(token);
    	          }
    	          System.out.println("Pilha: " + expression);
    	          inpos.conversao(expression, posfix);
    	          System.out.println("Pilha posfixa: " + posfix);
    	          tree.createTree(posfix);
    	          System.out.println("Árvore binária criada.");
    	        }
    	}
    	catch (NullPointerException e){
    		System.out.println("Erro. Não há expressão na memória. Volte à Opção 1.");
    		infix = "";
    	}
    	catch (EmptyStackException e){
    		System.out.println("Erro. Falta um operando para uma operação. Volte à Opção 1.");
    		infix = "";
    	}
    	catch (NumberFormatException e){
    		System.out.println("Erro. Não há parênteses correspondentes. Volte à Opção 1.");
    		infix = "";
    	}
      }
      
      else if (opcao.equals("3")) {
        if (infix.isEmpty()) {
          System.out.println("Erro: Não há expressão na memória. Volte à Opção 1.");
        }
        else {
          System.out.println("Árvore binária percorrida em pré-ordem:");
          tree.preOrder();
          System.out.println("\nÁrvore binária percorrida em em-ordem:");
          tree.inOrder();
          System.out.println("\nÁrvore binária percorrida em pós-ordem:");
          tree.postOrder();
        }
      }
      
        /*else if (opcao.equals("4")) {
            if (infix.isEmpty()) {
                System.out.println("Erro: Não há expressão na memória. Volte à Opção 1.");
            }
            else {
                double res = inpos.calcularposfix(infix, variaveis);
                System.out.println("Resultado do cálculo: " + res);
                System.out.println("Expressão: " + inpos.conversao(infix));
                System.out.println("Valores das variáveis utilizadas na expressão:");
            }
        }*/

      else if (opcao.equals("5")){
        System.out.println("Programa encerrado.");
        break; 
      }
      
      else{
        System.out.println("Opção inválida. Tente novamente.");
      }
      
    } while(true);
    scan.close();
  }


  public static void main(String[] args) {
	  menu();
  }
}
