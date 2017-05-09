package implementations.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class supports either directional or undirectional graphs
 *
 * Created by matie on 2017-04-25.
 */
public class Graph<E, D> {
    private List<Node<E, D>> nodes = new ArrayList<>();
    private Map<D, Node<E, D>> nodeChecker = new HashMap<>();
    private boolean isDirected;

    /**
     * Constructs the class and indicates whether the graph is directed or undirected.
     *
     * @param isDirected flag indicating the type of graph
     */
    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    /**
     * Adds an edge with weight between source node and destination node. Do nothing
     * if source or destination do not exist. If the graph is undirected {isDirected == false}
     * the method proceeds to add an edge from destination to source as well.
     *
     * @param source Source Node
     * @param destination Destination Node
     * @param weight Weight on the edge between source and destination
     */
    public void addEdge(Node<E, D> source, Node<E, D> destination, E weight){
        if(source != null && destination != null && weight != null
                && nodeChecker.containsKey(source.getData())
                && nodeChecker.containsKey(destination.getData())){
            source.addEdge(weight, destination);
            if(!isDirected){
                destination.addEdge(weight, source);
            }
        }
    }

    /**
     * Creates a source node and a destination node, and then adds an edge between them
     *
     * @param source
     * @param destination
     * @param weight
     */
    public void addEdge(D source, D destination, E weight){
        Node<E, D> sourceNode = addNode(source);
        Node<E, D> destinationNode = addNode(destination);
        addEdge(sourceNode, destinationNode, weight);
    }

    /**
     * Adds a new node to the graph
     *
     * @param data
     * @return null if the node already exists in the graph
     */
    public Node<E, D> addNode(D data){
        if(!nodeChecker.containsKey(data)){
            Node<E, D> node = new Node<>(data);
            nodeChecker.put(data, node);
            addNode(node);
        }
        return nodeChecker.get(data);
    }

    /**
     * Adds a node to the list of nodes
     *
     * @param node
     */
    private void addNode(Node<E, D> node){
        nodes.add(node);
    }

    public List<Node<E, D>> getNodes() {
        return nodes;
    }

    public boolean isDirected() {
        return isDirected;
    }
}
