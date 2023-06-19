package matriz;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GrafoMatriz<T> implements Grafo<T> {
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;
    private int numVertices = 0;
    private int maxVertice;
    private int[][] adjMatrix;

    // -------------------------------------------------------------------------------------

    public GrafoMatriz(int tamanho) {
        this.maxVertice = tamanho;
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.adjMatrix = new int[tamanho][tamanho];
    }

    @Override
    public void adicionarVertice(T dado, int peso) {
        if (numVertices < maxVertice){
            Vertice<T> novoVertice = new Vertice<>(dado, peso, this.vertices.size() + 1);
            this.vertices.add(novoVertice);
            numVertices++;
        }
        else
            System.out.println("Grafo cheio");
    }

    @Override
    public void adicionarAresta(int peso, T dadoInicio, T dadoFim) {
        Vertice<T> inicio = this.getVertice(dadoInicio);
        Vertice<T> fim = this.getVertice(dadoFim);
        Aresta<T> aresta = new Aresta<>(peso, inicio, fim, inicio.getIndex(), fim.getIndex());
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);

        int v1 = inicio.getIndex();
        int v2 = fim.getIndex();

        if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
    }

    @Override
    public Vertice<T> getVertice(T dado) {
        return vertices
                .stream()
                .filter(d -> d.getDado().equals(dado))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean retornaArestas(T inicio, T fim) {
        return false;
    }

    @Override
    public void buscaEmLargura() {
        //TODO - busca em largura numa matriz de adjacencia?
    }

    @Override
    public boolean checarAdjVertice(T verticefilho, T verticepai) {
        int v1 = this.getVertice(verticefilho).getIndex();
        int v2 = this.getVertice(verticepai).getIndex();

        return adjMatrix[v1][v2] == 1 && adjMatrix[v2][v1] == 1;
    }

    @Override
    public boolean checarAdjAresta(Aresta<T> aresta1, Aresta<T> aresta2) {
        int lineIndex1 = aresta1.getLineIndex();
        int columnIndex1 = aresta1.getColumnIndex();
        int lineIndex2 = aresta2.getLineIndex();
        int columnIndex2 = aresta2.getColumnIndex();

        if (lineIndex1 >= 0 && lineIndex1 < numVertices && columnIndex1 >= 0 && columnIndex1 < numVertices &&
                lineIndex2 >= 0 && lineIndex2 < numVertices && columnIndex2 >= 0 && columnIndex2 < numVertices) {

            return adjMatrix[lineIndex1][columnIndex1] == 1 && adjMatrix[lineIndex2][columnIndex2] == 1;
        }

        return false;
    }

    @Override
    public void qtdVertices() {
        System.out.println(this.numVertices);
    }

    @Override
    public void qtdArestas() {
        System.out.println(this.arestas.size());
    }
}