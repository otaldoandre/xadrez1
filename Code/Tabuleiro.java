package Code;

public class Tabuleiro {

    // contantes de cor. p = peça, c = casa
    private static final String P_PRETO = "\033[38;5;16m";
    private static final String P_BRANCO = "\033[38;5;255m";
    private static final String C_PRETO = "\033[48;5;237m";
    private static final String C_BRANCO = "\033[48;5;243m";
    private static final String RESET = "\033[0m";

    public final Casa[][] casas;

    public Tabuleiro() {

        casas = new Casa[8][8];

        int c = 1;
        for (int y = 0; y < 8; y++) {

            for (int x = 0; x < 8; x++) {

                casas[y][x] = new Casa(c);
                c = (c == 1) ? 0 : 1;

            }

            c = (c == 1) ? 0 : 1;

        }

        //desenho();

    }

    //

    public Caminho geraCaminho(String c) {

        Casa[] cs = new Casa[c.length() / 2];

        for (int i = 0; i < c.length(); i += 2) {

            cs[i] = casas[Jogo.validyx(c.charAt(i))][Jogo.validyx(c.charAt(i + 1))];

            Jogo.debugl(Jogo.validyx(c.charAt(i)) + " " + Jogo.validyx(c.charAt(i + 1)));

        }

        return new Caminho(cs);

    }

    public void setCasa(int y, int x, Peca p) {

        casas[y][x].ocupante = p;

    }

    public Casa getCasa(int y, int x) {

        // retorna peca na casa na posicao xy do tabuleiro, se houver
        return casas[y - 1][x - 1];

    }

    public Peca getPeca(int y, int x) {

        // retorna peca na casa na posicao xy do tabuleiro, se houver
        return casas[y - 1][x - 1].ocupante;

    }

    // aparentemente, isso nao sera usado
    public Casa[] casasDoCaminho() {

        return new Casa[1];

    }

    // saida na versao nao grafica
    public String desenho() {

        for (int y = 7; y >= 0; y--) {

            for (int x = 0; x < 8; x++) {

                Jogo.print(((casas[y][x].cor == 1) ? C_PRETO : C_BRANCO));
                if (casas[y][x].ocupante != null)
                    Jogo.print(((casas[y][x].ocupante.cor == 1) ? P_PRETO : P_BRANCO) + casas[y][x].ocupante.Desenho());
                else
                    Jogo.print(" ");

            }

            Jogo.printl("");

        }

        Jogo.print(RESET);

        return "";

    }

}
