package Code;

public abstract class Peca {

    public final int cor; // 0 = branco, 1 = preto
    public final Jogador jogador;

    public Peca(int c, Jogador j) {

        cor = c;
        jogador = j;

    }

    //

    // casa variante dessa classe deve retornar o caractere
    // referente ao tipo da peca, de acordo com o arquivo pecas.txt
    public abstract String Desenho();

    // considerar que se esse metodo foi chamado, as casas inicial e final da jogada
    // ja foram validadas pela classe tabuleiro.
    // os parametros sao, respectivamente:
    // linhaDeOrigem, colunaDeOrigem, linhaDeDestino, colunaDeDestino;
    // (deve ser implementado para cada variante da classe)
    public abstract boolean movimentoValido(int oy, int ox, int dy, int dx);

    // lista de casas pelas quais a peça vai passar caso a jogada seja valida.
    // (deve ser implementado para cada variante da classe)
    public abstract String caminho();

}
