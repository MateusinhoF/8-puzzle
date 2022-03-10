package puzzle;

import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TabuleiroTest extends TestCase{
    
    private Tabuleiro tabuleiro;
    private String[] n = {"1","2","3","4","5","6","7","8","*"};
    private String[][] matriz;
    
    public TabuleiroTest(){
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        tabuleiro = new Tabuleiro();
        matriz = new String[3][3];
        int x = 0;
        for (int i = 0; i < 3; i++){
            for (int t = 0; t < 3; t++){
                matriz[i][t] = n[x];
                x++;
            }
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of verificarOrdenacao method, of class Tabuleiro.
     */
    @Test
    public void testVerificarOrdenacao() {
        assertEquals(true, tabuleiro.verificarOrdenacao(matriz));
        
    }

    /**
     * Test of pegaPosicoes method, of class Tabuleiro.
     */
    @Test
    public void testPegaPosicoes() {
        assertArrayEquals(new int[] {1,1}, tabuleiro.pegaPosicoes(matriz, "5"));
    }

    /**
     * Test of verificaNumerosParaMover method, of class Tabuleiro.
     */
    @Test
    public void testVerificaNumerosParaMover() {
        assertEquals("** 6 8 **", tabuleiro.verificaNumerosParaMover(matriz));
    }
    
}
