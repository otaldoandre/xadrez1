package Code;

public class Bispo extends Peca {

    public Bispo(int c, Jogador j) {
        super(c, j);
    }

    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {

        if (linhaD > 7 || colunaD > 7 || linhaD < 0 || colunaD < 0) {
            return false;
        }

        int diferencaColuna = Math.abs(colunaD - colunaO);
        int diferencaLinha = Math.abs(linhaD - linhaO);

        return (diferencaLinha == diferencaColuna);
    }

    public String caminho() {

        return "";

    }

    public String Desenho() {

        return "♝";
    }

}
