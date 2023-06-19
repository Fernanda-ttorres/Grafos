package grafo;

import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO dado;
    private int peso;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;
    private int index;
    
//-------------------------------------------------------------------------------------
    public Vertice(TIPO valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }

    public Vertice(TIPO valor, int peso){
        if(peso < 0){
            peso = 0;
        }
        this.dado = valor;
        this.peso = peso;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }

    public Vertice(TIPO valor, int peso, int index){
        if(peso < 0){
            peso = 0;
        }
        this.dado = valor;
        this.peso = peso;
        this.index = index;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }
//-------------------------------------------------------------------------------------

    public TIPO getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = dado;
    }

//-------------------------------------------------------------------------------------

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

//-------------------------------------------------------------------------------------

    public void adicionarArestaEntrada(Aresta<TIPO> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Aresta<TIPO> aresta){
        this.arestasSaida.add(aresta);
    }

//-------------------------------------------------------------------------------------

    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void removerArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.remove(aresta);
    }

    public void removerArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.remove(aresta);
    }

//-------------------------------------------------------------------------------------
    
}