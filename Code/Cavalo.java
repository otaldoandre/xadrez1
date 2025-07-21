package Code;

public class Cavalo extends Peca {

    public Cavalo(int c, Jogador j) {
        super(c, j);
    }

    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {

        if (linhaD > 7 || colunaD > 7 || linhaD < 0 || colunaD < 0) {
            return false;
        }

        int diferencaColuna = Math.abs(colunaD - colunaO);
        int diferencaLinha = Math.abs(linhaD - linhaO);

        if (diferencaLinha == 2 && diferencaColuna == 1 || diferencaLinha == 1 && diferencaColuna == 2) {
            return true;
        } else {
            return false;
        }
    }

    public String caminho() {

        return "";

    }

    public String Desenho() {

        return "♞";
    }
}
