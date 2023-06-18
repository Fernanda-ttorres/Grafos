package grafo;

public class Aresta<TIPO> {
    private int peso;
    private Vertice<TIPO> inicio;
    private Vertice<TIPO> fim;
    private int lineIndex;
    private int columnIndex;
    
    public Aresta(int peso, Vertice<TIPO> inicio, Vertice<TIPO> fim){
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Aresta(int peso, Vertice<TIPO> inicio, Vertice<TIPO> fim, int lineIndex, int columnIndex) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
        this.lineIndex = lineIndex;
        this.columnIndex = columnIndex;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vertice<TIPO> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<TIPO> inicio) {
        this.inicio = inicio;
    }

    public Vertice<TIPO> getFim() {
        return fim;
    }

    public void setFim(Vertice<TIPO> fim) {
        this.fim = fim;
    }


    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getLineIndex() {
        return lineIndex;
    }

    public void setLineIndex(int lineIndex) {
        this.lineIndex = lineIndex;
    }
}
