package grafo.dirigido;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSIterator<T> implements GrafoIterator<T> {

    private Queue<Vertice<T>> fila;
    private boolean[] visitado;
    private Grafo<T> grafo;

    public BFSIterator(Grafo<T> grafo, Vertice<T> verticeInicial) {
        this.grafo = grafo;
        this.fila = new LinkedList<>();
        this.visitado = new boolean[grafo.getVertices().size()];
        fila.add(verticeInicial);
        visitado[grafo.getVertices().indexOf(verticeInicial)] = true;
    }

    public boolean hasNext() {
        return !fila.isEmpty();
    }

    public Vertice<T> next() {
        Vertice<T> verticeAtual = fila.remove();
        int index = grafo.getVertices().indexOf(verticeAtual);
        for (Aresta<T> aresta : grafo.getArestas()) {
            if (aresta.getOrigem().equals(verticeAtual) && !visitado[grafo.getVertices().indexOf(aresta.getDestino())]) {
                visitado[grafo.getVertices().indexOf(aresta.getDestino())] = true;
                fila.add(aresta.getDestino());
            }
        }
        return verticeAtual;
    }
}
