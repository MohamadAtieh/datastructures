package implementations.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matie on 2017-04-25.
 */
public class Node<E, D>{
    private D data;
    private List<Edge<E, D>> neighbors = new ArrayList<>();

    public Node(D data) {
        this.data = data;
    }

    public void addEdge(E weight, Node<E, D> destination){
        neighbors.add(new Edge<>(weight, destination));
    }

    public D getData() {
        return data;
    }

    public List<Edge<E, D>> getNeighbors() {
        return neighbors;
    }
}

