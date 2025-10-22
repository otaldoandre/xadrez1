package Code;

public class Peao extends Peca {

    public Peao(int c, Jogador j) {
        super(c, j);
    }

    public boolean movimentoValido(int linhaO, int colunaO, int linhaD, int colunaD) {
        // Assumindo que as peças estão inicialmente posicionadas corretamente

        int direcao;

        if (linhaD > 7 || colunaD > 7 || linhaD < 0 || colunaD < 0) {
            return false;
        }

        if (this.cor == 0) {
            direcao = 1;
        } else {
            direcao = -1;
        }

        int diferencaColuna = colunaD - colunaO;
        int diferencaLinha = linhaD - linhaO;

        if (diferencaColuna == 0) {

            // 1 - Avança 2 casas da posição inicial
            if (diferencaLinha == 2 * direcao) {
                // int linhaIntermediaria = linhaO + direcao;
                boolean posInicial = (this.cor == 0 && linhaO == 6) || (this.cor == 1 && linhaO == 1);
                if (posInicial) {
                    return true;
                }
            }

        } else if (Math.abs(diferencaColuna) == 1) {

            // 2 - Avança 1 casa para frente
            if (diferencaLinha == direcao)
                return true;

        }

        return false;

    }

    public String caminho() {

        return "";

    }

    public String Desenho() {

        return "♟";
    }

    @Override
    public Peca clone() {
        return new Peao(this.cor, this.jogador);
    }

}
