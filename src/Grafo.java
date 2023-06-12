import java.util.ArrayList;

public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;
    private int nmrvertice = 0;
    private int maxvertice;

    // -------------------------------------------------------------------------------------

    public Grafo(int tamanho) {
        this.maxvertice = tamanho;
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    // -------------------------------------------------------------------------------------

    public void adicionarVertice(TIPO dado, int peso) {
        if (nmrvertice < maxvertice) {
            Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado, peso);
            this.vertices.add(novoVertice);
            nmrvertice++;
        }
    }

    // -------------------------------------------------------------------------------------

    public void adicionarAresta(int peso, TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    // -------------------------------------------------------------------------------------

    public Vertice<TIPO> getVertice(TIPO dado) {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getDado().equals(dado)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    // -------------------------------------------------------------------------------------

    public boolean buscaAresta(TIPO inicio , TIPO fim) {
        for (int i = 0; i < this.arestas.size(); i++) {
            if(this.arestas.get(i).getInicio().equals(inicio) && this.arestas.get(i).getFim().equals(fim)) {
                return true;
            }
        }
        return false;
            
    }

    // -------------------------------------------------------------------------------------

    public void buscaEmLargura() {
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        Vertice<TIPO> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while (fila.size() > 0) {
            Vertice<TIPO> visitado = fila.get(0);
            for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcados.contains(proximo)) { // se o vértice ainda não foi marcado
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

    // -------------------------------------------------------------------------------------

    public boolean checarAdjVertice(TIPO verticefilho, TIPO verticepai) {
        Vertice<TIPO> verticeini = this.getVertice(verticefilho);
        Vertice<TIPO> verticefim = this.getVertice(verticepai);

        ArrayList<Aresta<TIPO>> verticeiniadj = verticeini.getArestasSaida();
        for (int i = 0; i < verticeiniadj.size(); i++) {
            if (verticeiniadj.get(i).getFim().equals(verticefim)) {
                System.out.println("Deu certo poha");
                return true;
            }
        }

        return false;
    }

    // -------------------------------------------------------------------------------------

    public boolean checarAdjAresta(Aresta<TIPO> aresta1, Aresta<TIPO> aresta2) {
        if((aresta1.getInicio() ==  aresta2.getInicio() ) || (aresta1.getFim() == aresta2.getFim()) || (aresta1.getInicio() ==  aresta2.getFim() ) || (aresta1.getFim() == aresta2.getInicio())) {
            System.out.println("As arestas são adjascentes");
            return true;
        }
        return false;
    }

    // -------------------------------------------------------------------------------------

    public void qtdVertices() {
        int quantidadeVertices = this.vertices.size();
    
        System.out.println("Quantidade de vértices: " + quantidadeVertices);
    }

    public void qtdArestas() {
        int quantidadeArestas = this.arestas.size();
    
        System.out.println("Quantidade de arestas: " + quantidadeArestas);
    }

    // -------------------------------------------------------------------------------------

}