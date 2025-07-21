package Code;

public class Jogada {

    public final Jogador autor;
    public final Casa casaInicial, casaFinal;
    public Caminho caminho;

    public Jogada() {

        autor = new Jogador();
        casaInicial = new Casa(0);
        casaFinal = new Casa(0);

    }

    public Jogada(Jogador a, Casa i, Casa f) {

        autor = a;
        casaInicial = i;
        casaFinal = f;

    }

    //

    public boolean ehValida(Tabuleiro t) {

        try {

            if (casaInicial.ocupante.jogador != autor)
                return false;

            if (casaFinal.ocupante.jogador == autor)
                return false;

        } catch (Exception e) {

            return false;

        }

        caminho = t.geraCaminho(casaInicial.ocupante.caminho());

        if (!caminho.estaLivre())
            return false;

        return true;

    }

    public boolean ehXeque() {

        return false;

    }

    public boolean ehXequeMate() {

        return false;

    }

}
