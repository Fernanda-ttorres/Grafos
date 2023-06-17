import grafo.GrafoImpl;

public class App {
    public static void main(String[] args) throws Exception {

        GrafoImpl<String> grafo = new GrafoImpl<String>(100);
        grafo.adicionarVertice("João", 1);
        grafo.adicionarVertice("Lorenzo", 1);
        grafo.adicionarVertice("Creuza", 1);
        grafo.adicionarVertice("Créber", 1);
        grafo.adicionarVertice("Cráudio", 1);
        
        grafo.adicionarAresta(2, "João", "Lorenzo");
        grafo.adicionarAresta(3, "Lorenzo", "Créber");
        grafo.adicionarAresta(1, "Créber", "Creuza");
        grafo.adicionarAresta(1, "João", "Creuza");
        grafo.adicionarAresta(3, "Cráudio", "João");
        grafo.adicionarAresta(2, "Cráudio", "Lorenzo");
        
        grafo.buscaEmLargura();
        System.out.println(grafo.checarAdjVertice("Lorenzo", "Créber"));

        grafo.qtdVertices();
        grafo.qtdArestas();


        System.out.println( grafo.buscaAresta("João" , "Lorenzo"));
        
       
        
        // grafo.checarAdjAresta();
    }
}
