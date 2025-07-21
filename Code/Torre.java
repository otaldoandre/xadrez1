package Code;

public class Torre extends Peca {

    public Torre(int c, Jogador j) {
        super(c, j);
    }

    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {
        if (linhaD > 7 || colunaD > 7 || linhaD < 0 || colunaD < 0) {
            return false;
        } else {
            return (linhaO == linhaD || colunaO == colunaD);
        }

    }

    public String caminho() {

        return "";

    }

    public String Desenho() {

        return "♜";
    }

    @Override
    public Peca clone() {
        return new Torre(this.cor, this.jogador);
    }

}
