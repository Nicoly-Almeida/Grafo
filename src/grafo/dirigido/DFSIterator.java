package grafo.dirigido;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSIterator<T> implements GrafoIterator<T> {

    private Stack<Vertice<T>> pilha;
    private boolean[] visitado;
    private Grafo<T> grafo;

    public DFSIterator(Grafo<T> grafo, Vertice<T> verticeInicial) {
        this.grafo = grafo;
        this.pilha = new Stack<>();
        this.visitado = new boolean[grafo.getVertices().size()];
        pilha.push(verticeInicial);
        System.out.println(verticeInicial);
        System.out.println(grafo.getVertices());
        visitado[grafo.getVertices().indexOf(verticeInicial)] = true;
    }

    public boolean hasNext() {
        return !pilha.isEmpty();
    }

    public Vertice<T> next() {
        Vertice<T> verticeAtual = pilha.pop();
        int index = grafo.getVertices().indexOf(verticeAtual);
        for (Aresta<T> aresta : grafo.getArestas()) {
            if (aresta.getOrigem().equals(verticeAtual) && !visitado[grafo.getVertices().indexOf(aresta.getDestino())]) {
                visitado[grafo.getVertices().indexOf(aresta.getDestino())] = true;
                pilha.push(aresta.getDestino());
            }
        }
        return verticeAtual;
    }
}