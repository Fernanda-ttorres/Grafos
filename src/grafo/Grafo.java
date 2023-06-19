package grafo;

public interface Grafo<TIPO>{

    void adicionarVertice(TIPO dado, int peso);
    void removerAresta(TIPO dadoInicio, TIPO dadoFim);
    void adicionarAresta(int peso, TIPO dadoInicio, TIPO dadoFim);
    Vertice<TIPO> getVertice(TIPO dado);
    boolean buscaAresta(TIPO inicio, TIPO fim);
    Aresta<TIPO> retornaAresta(Vertice<TIPO> inicio, Vertice<TIPO> fim);
    void buscaEmLargura();
    boolean checarAdjVertice(TIPO verticefilho, TIPO verticepai);
    boolean checarAdjAresta(Aresta<TIPO> aresta1, Aresta<TIPO> aresta2);
    void qtdVertices();
    void qtdArestas();
}
