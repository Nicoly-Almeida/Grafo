package grafo.dirigido;

public interface GrafoIterator<T> {

    boolean hasNext();

    Vertice<T> next();

}