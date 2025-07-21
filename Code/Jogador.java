package Code;

public class Jogador {

    public final String nome;
    public final int cor; // 0 = branco, 1 = preto

    private Peca[] pecas;

    public Jogador() {

        nome = "jogador";
        cor = 0;

    }

    public Jogador(String n, int c) {

        nome = n;
        cor = c;

    }

    public void setPecas(Peca[] ps){

        pecas = ps;

    }

    public String informaJogada() {

        Jogo.debugl(nome + ", informe sua jogada:");

        // se modoGraficoInterativo, recebe e retorna string gerada na classe de
        // interface grafica.

        // se nao, recebe input basico e retorna
        return Jogo.input.next();

    }

    public String pecasCapturadas() {

        return "b p p";

    }

}
