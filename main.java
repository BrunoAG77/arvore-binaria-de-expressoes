// Bruno Antico Galin 10417318
// Ismael de Sousa e Silva 10410870
// Referência: https://www.youtube.com/watch?v=Etpc_-br5rI
// Referência: https://www.youtube.com/watch?v=b_NjndniOqY
// Referência: https://www.youtube.com/watch?v=Gt2yBZAhsGM
// Referência: https://www.youtube.com/watch?v=wL7JOLxbMI4

package apl1_ed2;
import java.util.Scanner;

public class Main {
  public static void menu() {
    Scanner scan = new Scanner(System.in);
    String infix = "";
    String posfix = "";
    int[] variaveis = new int[26];
    do {
      System.out.println("---Árvore binária de expressão aritmética---\n1. Entrada da expressão aritmética na notação infixa.\n2. Criação da árvore binária de expressão aritmética.\n3. Exibição da árvore binária de expressão aritmética.\n4. Cálculo da expressão (realizando o percurso da árvore) .\n5. Encerramento do programa.");
      String opcao = scan.nextLine();
      if (opcao.equals("1")) {
        System.out.println("Digite a expressão na notação infixa: ");
        infix = scan.nextLine();
      }
      else if (opcao.equals("2")) {
        if (infix.isEmpty()) {
          System.out.println("Erro. Não há expressão na memória. Volte à Opção 1.");
        }
        else {
          //System.out.println("Digite os valores númericos associados às variáveis da expressão digitada (separe-os por espaço): ");
          //String vnum = scan.nextLine();
          //String[] numspace = vnum.split(" ");
          /*try {
            for (int i = 0; i < numspace.length; i++) {
              variaveis[i] = Integer.parseInt(numspace[i]);
            }
          }
          catch (NumberFormatException e) {
            System.out.println("Erro: Caractere inválido. Tente novamente. ");
            infix = "";
          }*/
        }
      }
      else if (opcao.equals("3")) {
        if (infix.isEmpty()) {
          System.out.println("Erro: Não há expressão na memória. Volte à Opção 1.");
        }
        else {
          posfix = inpos.conversao(infix);
          System.out.println("Expressão convertida para posfixa: \n" + posfix);
        }
      }
        else if (opcao.equals("4")) {
            if (infix.isEmpty()) {
                System.out.println("Erro: Não há expressão na memória. Volte à Opção 1.");
            }
            else {
                double res = inpos.calcularposfix(infix, variaveis);
                System.out.println("Resultado do cálculo: " + res);
                System.out.println("Expressão: " + inpos.conversao(infix));
                System.out.println("Valores das variáveis utilizadas na expressão:");
                for (int i = 0; i < infix.length(); i++) {
                    char c = infix.charAt(i);
                    if (Character.isLetter(c)) {
                    	c = Character.toUpperCase(c);
                        int iVar = c - 'A';
                        if (iVar >= 0 && iVar < variaveis.length) {
                            System.out.println(c + " = " + variaveis[iVar]);
                        }
                    }
                }
            }
        }

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
