package Code;

public class Caminho {

    private final Casa[] lista;

    public Caminho() {

        lista = new Casa[0];

    }

    public Caminho(Casa[] c) {

        lista = c;

    }

    public Caminho(Tabuleiro t) {

        lista = t.casasDoCaminho();

    }

    //

    public Casa casaInicial() {

        return lista[0];

    }

    public Casa casaFinal() {

        return lista[lista.length - 1];

    }

    public boolean estaLivre() {

        // processa
        return true; // apenas se todas as casas estiverem livre

    }

}
