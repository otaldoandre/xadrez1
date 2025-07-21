package Code;

import java.util.ArrayList;

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
        Casa casaRei = t.encontrarReiDoJogador(adversario.cor, t);
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

    public boolean ehXequeMate(Tabuleiro t, Jogador adversario) {
        if (!ehXeque(t, adversario)) {
            return false;
        }
        for (Peca peca : adversario.minhasPecas) {
            Casa c = t.encontrarCasaDaPecaPorTipoCor(peca.getClass(), peca.cor, t);
            if (c == null) continue;
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    Casa casaDestino = t.casas[y][x];
                    if (peca.movimentoValido(c.y, c.x, y, x)) {
                        Tabuleiro copia = t.copia();
                        Casa cCopia = copia.encontrarCasaDaPecaPorTipoCor(peca.getClass(), peca.cor, copia);
                        if (cCopia == null) continue;
                        copia.casas[y][x].ocupante = cCopia.ocupante;
                        cCopia.ocupante = null;
                        // Atualize a lista de peças do adversário na cópia
                        Jogador adversarioCopia = new Jogador(adversario.nome, adversario.cor);
                        adversarioCopia.minhasPecas = new ArrayList<>();
                        for (int yy = 0; yy < 8; yy++) {
                            for (int xx = 0; xx < 8; xx++) {
                                Peca p = copia.casas[yy][xx].ocupante;
                                if (p != null && p.jogador.cor == adversario.cor) {
                                    adversarioCopia.minhasPecas.add(p);
                                }
                            }
                        }
                        // Se a peça for o rei, não permita mover para casa atacada
                        if (peca instanceof Rei) {
                            // Verifique se a casa de destino está sob ataque
                            Jogador oponenteCopia = new Jogador("oponente", 1 - adversario.cor);
                            oponenteCopia.minhasPecas = new ArrayList<>();
                            for (int yy = 0; yy < 8; yy++) {
                                for (int xx = 0; xx < 8; xx++) {
                                    Peca p = copia.casas[yy][xx].ocupante;
                                    if (p != null && p.jogador.cor != adversario.cor) {
                                        oponenteCopia.minhasPecas.add(p);
                                    }
                                }
                            }
                            Casa novaCasaRei = copia.casas[y][x];
                            boolean sobAtaque = false;
                            for (Peca p : oponenteCopia.minhasPecas) {
                                Casa cP = copia.encontrarCasaDaPecaPorTipoCor(p.getClass(), p.cor, copia);
                                if (cP == null) continue;
                                if (p.movimentoValido(cP.y, cP.x, novaCasaRei.y, novaCasaRei.x)) {
                                    if (p instanceof Cavalo || copia.caminhoEstaLivre(cP, novaCasaRei)) {
                                        sobAtaque = true;
                                        break;
                                    }
                                }
                            }
                            if (sobAtaque) continue; // casa está sob ataque, não pode mover
                        }
                        if (!ehXeque(copia, adversarioCopia)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
