package implementations.graph;

/**
 * Created by matie on 2017-04-25.
 */
public class Edge<E, D>{
    private E weight;
    private Node<E, D> destination;

    public Edge(E weight, Node<E, D> destination) {
        this.weight = weight;
        this.destination = destination;
    }

    public E getWeight() {
        return weight;
    }

    public Node<E, D> getDestination() {
        return destination;
    }
}
