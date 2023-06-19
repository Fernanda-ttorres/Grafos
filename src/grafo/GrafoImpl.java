package grafo;

import java.util.ArrayList;

public class GrafoImpl<TIPO> implements Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;
    private int numVertices = 0;
    private int maxVertice;
    private int[][] adjMatrix;

    // -------------------------------------------------------------------------------------

    public GrafoImpl(int tamanho) {
        this.maxVertice = tamanho;
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    // -------------------------------------------------------------------------------------

    @Override
    public void adicionarVertice(TIPO dado, int peso) {
        if (numVertices < maxVertice) {
            Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado, peso);
            this.vertices.add(novoVertice);
            numVertices++;
        }
    }

    // -------------------------------------------------------------------------------------

    @Override
    public void adicionarAresta(int peso, TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    // -------------------------------------------------------------------------------------

    @Override
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

    @Override
    public boolean buscaAresta(TIPO inicio, TIPO fim) {
        for (int i = 0; i < this.arestas.size(); i++) {
            if(this.arestas.get(i).getInicio().equals(inicio) && this.arestas.get(i).getFim().equals(fim)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Aresta<TIPO> retornaAresta(Vertice<TIPO> inicio, Vertice<TIPO> fim) {
        for (Aresta<TIPO> aresta : this.arestas) {
            if (aresta.getInicio().equals(inicio) && aresta.getFim().equals(fim)) {
                return aresta;
            }
        }
        return null;
    }

    // -------------------------------------------------------------------------------------

    @Override
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


    @Override
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

    @Override
    public boolean checarAdjAresta(Aresta<TIPO> aresta1, Aresta<TIPO> aresta2) {
        if((aresta1.getInicio() ==  aresta2.getInicio() ) || (aresta1.getFim() == aresta2.getFim()) || (aresta1.getInicio() ==  aresta2.getFim() ) || (aresta1.getFim() == aresta2.getInicio())) {
            System.out.println("As arestas são adjascentes");
            return true;
        }
        return false;
    }

    // -------------------------------------------------------------------------------------

    @Override
    public void qtdVertices() {
        int quantidadeVertices = this.vertices.size();
    
        System.out.println("Quantidade de vértices: " + quantidadeVertices);
    }

    @Override
    public void qtdArestas() {
        int quantidadeArestas = this.arestas.size();
    
        System.out.println("Quantidade de arestas: " + quantidadeArestas);
    }

    // -------------------------------------------------------------------------------------

    @Override
    public void removerAresta( TIPO dadoInicio, TIPO dadoFim){
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);

        Aresta<TIPO> aresta = retornaAresta(inicio, fim);

        if (aresta != null) {
            inicio.removerArestaSaida(aresta);
            fim.removerArestaEntrada(aresta);
            this.arestas.remove(aresta);

            int v1 = inicio.getIndex();
            int v2 = fim.getIndex();

            if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
                adjMatrix[v1][v2] = 0;
                adjMatrix[v2][v1] = 0;
            }
        }


    }

    public int[][] matrizAdjacencia(GrafoImpl<TIPO> grafo) {
        int numVertices = grafo.numVertices;
        int[][] adjMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
               if (grafo.checarAdjAresta(grafo.arestas.get(i), grafo.arestas.get(j))){
                   adjMatrix[i][j] = 1;
               }
               else{
                   adjMatrix[i][j] = 0;
               }
            }
        }

        return adjMatrix;
    }

    public void printAdjMatrix(int[][] adjMatrix) {
        int numVertices = adjMatrix.length;

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}