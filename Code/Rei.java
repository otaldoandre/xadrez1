package Code;

public class Rei  extends Peca {

    public Rei(int c, Jogador j) {
        super(c, j);
    }

    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {

        if (linhaD > 7 || colunaD > 7 || linhaD < 0 || colunaD < 0) {
            return false;
        }

        int diferencaColuna = Math.abs(colunaD - colunaO);
        int diferencaLinha = Math.abs(linhaD - linhaO);

        return diferencaLinha <= 1 && diferencaColuna <= 1 && (diferencaLinha + diferencaColuna != 0);
    }


    public String caminho() {
        return "";
    }

    public String Desenho() {

        return "♚";
    }
}
