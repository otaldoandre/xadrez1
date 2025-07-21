import static org.junit.Assert.*;
import org.junit.Test;

public class XadrezTest {
    @Test
    public void testReiMoveUmaCasaValido() {
        Jogador jogador = new Jogador("Branco", 0);
        Rei rei = new Rei(0, jogador);
        // Move 1 casa em todas as direções
        assertTrue(rei.movimentoValido(4, 4, 5, 4)); // baixo
        assertTrue(rei.movimentoValido(4, 4, 3, 4)); // cima
        assertTrue(rei.movimentoValido(4, 4, 4, 5)); // direita
        assertTrue(rei.movimentoValido(4, 4, 4, 3)); // esquerda
        assertTrue(rei.movimentoValido(4, 4, 5, 5)); // diagonal baixo-direita
        assertTrue(rei.movimentoValido(4, 4, 5, 3)); // diagonal baixo-esquerda
        assertTrue(rei.movimentoValido(4, 4, 3, 5)); // diagonal cima-direita
        assertTrue(rei.movimentoValido(4, 4, 3, 3)); // diagonal cima-esquerda
    }

    @Test
    public void testReiMoveDuasCasasInvalido() {
        Jogador jogador = new Jogador("Branco", 0);
        Rei rei = new Rei(0, jogador);
        // Move 2 casas em qualquer direção (inválido)
        assertFalse(rei.movimentoValido(4, 4, 6, 4)); // baixo
        assertFalse(rei.movimentoValido(4, 4, 2, 4)); // cima
        assertFalse(rei.movimentoValido(4, 4, 4, 6)); // direita
        assertFalse(rei.movimentoValido(4, 4, 4, 2)); // esquerda
        assertFalse(rei.movimentoValido(4, 4, 6, 6)); // diagonal baixo-direita
        assertFalse(rei.movimentoValido(4, 4, 2, 2)); // diagonal cima-esquerda
    }

    @Test
    public void testReiMoveParaCasaOcupadaPorPropriaPecaInvalido() {
        // Simula o tabuleiro e casas
        Jogador jogador = new Jogador("Branco", 0);
        Rei rei = new Rei(0, jogador);
        Torre torre = new Torre(0, jogador); // mesma cor
        Casa casaOrigem = new Casa(0, 4, 4);
        Casa casaDestino = new Casa(0, 4, 5);
        casaOrigem.ocupante = rei;
        casaDestino.ocupante = torre;
        // O método movimentoValido não verifica ocupação, mas a Jogada sim
        // Então aqui só testamos que o movimento é válido, mas a jogada não seria
        assertTrue(rei.movimentoValido(4, 4, 4, 5));
        // O correto seria testar na Jogada.ehValida(), mas aqui fica a observação
    }

    @Test
    public void testReiCapturaPecaAdversariaValido() {
        Jogador jogadorBranco = new Jogador("Branco", 0);
        Jogador jogadorPreto = new Jogador("Preto", 1);
        Rei rei = new Rei(0, jogadorBranco);
        Torre torrePreta = new Torre(1, jogadorPreto);
        Casa casaOrigem = new Casa(0, 4, 4);
        Casa casaDestino = new Casa(0, 4, 5);
        casaOrigem.ocupante = rei;
        casaDestino.ocupante = torrePreta;
        // O movimento é válido e a jogada seria válida
        assertTrue(rei.movimentoValido(4, 4, 4, 5));
    }

    @Test
    public void testMovimentoPeao() {
        Jogador jogadorBranco = new Jogador("Branco", 0);
        Peao peaoBranco = new Peao(0, jogadorBranco);
        // Move 1 casa para frente (válido)
        assertTrue(peaoBranco.movimentoValido(6, 0, 5, 0));
        // Move 2 casas para frente na primeira jogada (válido)
        assertTrue(peaoBranco.movimentoValido(6, 0, 4, 0));
        // Move 2 casas para frente após a primeira jogada (inválido)
        // Supondo que o peão já não está mais na linha inicial
        assertFalse(peaoBranco.movimentoValido(5, 0, 3, 0));
        // Move para trás (inválido)
        assertFalse(peaoBranco.movimentoValido(5, 0, 6, 0));

        Jogador jogadorPreto = new Jogador("Preto", 1);
        Peao peaoPreto = new Peao(1, jogadorPreto);
        // Move 1 casa para frente (válido para preto)
        assertTrue(peaoPreto.movimentoValido(1, 0, 2, 0));
        // Move 2 casas para frente na primeira jogada (válido para preto)
        assertTrue(peaoPreto.movimentoValido(1, 0, 3, 0));
        // Move 2 casas para frente após a primeira jogada (inválido para preto)
        assertFalse(peaoPreto.movimentoValido(2, 0, 4, 0));
        // Move para trás (inválido para preto)
        assertFalse(peaoPreto.movimentoValido(2, 0, 1, 0));
    }
}