package puzzle;

import java.util.Random;

public class Tabuleiro {
    
    private static String[] n = {"1","2","3","4","5","6","7","8","*"};
    
    public Tabuleiro(){
        
    }
    
    //vai movimentar os numeros dentro da matriz
    protected void moverNumeros(String numeroMover, String[][] matriz){
        int[] posNumero = null;
        int[] posNull = null;
        
        posNumero = pegaPosicoes(matriz, numeroMover);
        posNull = pegaPosicoes(matriz, "*");
        
        matriz[posNumero[0]][posNumero[1]] = "*";
        matriz[posNull[0]][posNull[1]] = numeroMover;
    }
    
    //retorna valores aleatorios para a matriz no inicio do jogo
    protected static void criaAleatorio(String[][] matriz){
        //String[] n = {"1","2","3","4","5","6","7","8","*"};
        Random random = new Random();
        int nr;
        
        //preeche a matriz
        for (int i = 0; i < 3; i++){
            for (int t = 0; t < 3; t++){
                nr = random.nextInt(n.length);
                //verifica se o valor no vetor é valido 
                while("99".equals(n[nr])){
                    nr++;
                    //faz essa validacao para nao estourar o valor total de posicoes do array e posiciona para o proximo
                    if (nr >= n.length){
                        nr = nr % n.length;
                    }
                }
                
                matriz[i][t] = n[nr];
                n[nr] = "99";
            }
        }
    }
    
    //verifica se os valores da matriz estao em ordem para encerrar o jogo
    protected static boolean verificarOrdenacao(String[][] matriz){
        //String[] n = {"1","2","3","4","5","6","7","8","*"};
        int j = 0;
        for (int i = 0; i < 3; i++){
            for (int t = 0; t < 3; t++){
                if (!n[j].equals(matriz[i][t])){
                    return false;
                }
                j++;
            }
        }
        
        return true;
    }
    
    //pega a posicao dos valores necessarios
    protected static int[] pegaPosicoes(String[][] matriz, String valor){
        int[] pos = {0,0};
        aa:
        for (int i = 0; i < 3; i++){
            for (int t = 0; t < 3; t++){
                if(matriz[i][t].equals(valor)){
                    pos[0] = i;
                    pos[1] = t;
                    break aa;
                }
            }
        }
        return pos;
    }
    
    //verifica quais numero podem ser movidos
    protected static String verificaNumerosParaMover(String[][] matriz){
        int[] pos = null;
        String numeros = "**";
        
        //pega a posicao em que esta o *
        pos = pegaPosicoes(matriz, "*");
        
        //pegando valor em cima
        if (pos[0]-1 >= 0){
            numeros = numeros+" "+matriz[pos[0]-1][pos[1]];
        }
        //pegando valor na mesma linha posicao anterior
        if (pos[1]-1 >= 0){
            numeros = numeros+" "+matriz[pos[0]][pos[1]-1];
        }
        //pegando valor na mesma linha posicao posterior
        if (pos[1]+1 <= 2){
            numeros = numeros+" "+matriz[pos[0]][pos[1]+1];
        }
        //pegando valor em baixo
        if (pos[0]+1 <= 2){
            numeros = numeros+" "+matriz[pos[0]+1][pos[1]];
        }
        numeros = numeros+" **";
        
        
        return numeros;
    }
    

}
