
package puzzle;

import java.util.Scanner;

public class Jogar {
    String[][] matriz;
    Tabuleiro tabuleiro;
    
    public Jogar(){
        matriz = new String[3][3];
        tabuleiro = new Tabuleiro();
    }
    
    public void run(){
        
        String numeroMover;
        
        System.out.println("------------------------------------------------------");
        System.out.println("|***            Bem vindo ao 8-puzzle             ***|");
        System.out.println("|Para mover um numero para o espaço preenchido por * |");
        System.out.println("|Basta digitar o numero e ele sera movido            |");
        System.out.println("------------------------------------------------------\n");
        
        //funcao que ira retornar os valores aleatorios para a matriz
        tabuleiro.criaAleatorio(matriz);
        
        while(tabuleiro.verificarOrdenacao(matriz) == false){
            
            //imprime os valores no console
            System.out.println("   *-----------*");
            for (int i = 0; i < 3; i++){
                System.out.print("   |  ");
                for (int t = 0; t < 3; t++){
                    System.out.print(matriz[i][t]+"  ");
                }
                System.out.print("|\n");
            }
            System.out.println("   *-----------*\n");
            
            System.out.println("Você pode mover os numeros "+tabuleiro.verificaNumerosParaMover(matriz));
            System.out.println("Digite o valor a ser movido");
            numeroMover = recebeNumero(tabuleiro.verificaNumerosParaMover(matriz));
            
            //System.out.println(numeroMover);
            
            tabuleiro.moverNumeros(numeroMover, matriz);
            

        }
        
        System.out.println("   *-----------*");
            for (int i = 0; i < 3; i++){
                System.out.print("   |  ");
                for (int t = 0; t < 3; t++){
                    System.out.print(matriz[i][t]+"  ");
                }
                System.out.print("|\n");
            }
        System.out.println("   *-----------*\n");
        
        System.out.println("Você venceu!!! Parabéns");
        
    }
    
    //recebe o numero a ser movido e faz a validacao
    private static String recebeNumero(String numerosValidos) {
        Scanner scn = new Scanner(System.in);
        String n;
        while (true) {
            System.out.print("Insira um numero ");
            n = scn.nextLine();

            if (numerosValidos.contains(n) && !n.isEmpty()){
                return n;
            }
        }
    }
}
