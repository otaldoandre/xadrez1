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

    public boolean ehXeque(Tabuleiro t, Jogador adversario) {
        Casa casaRei = t.encontrarCasaDaPecaPorTipoCor(Rei.class, adversario.cor, t);
        if (casaRei == null) {
            return false;
        }
        for (Peca p : this.autor.minhasPecas) {
            Casa c = t.encontrarCasaDaPecaPorTipoCor(p.getClass(), p.cor, t);
            if (c == null) continue;
            if (p.movimentoValido(c.y, c.x, casaRei.y, casaRei.x)) {
                if (p instanceof Cavalo || t.caminhoEstaLivre(c, casaRei)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ehXequeMate() {

        return false;

    }

}
