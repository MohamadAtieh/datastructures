package algorithms;

import java.util.*;

/**
 * Created by matie on 2017-05-11.
 */
public class Dijkstra {
    public static Graph calculateShortestPath(Graph graph, Node source){
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>(); // todo this should be a priority queue

        unsettledNodes.add(source);

        // BFS - visit all neighbors and do the same for each neighbor visited after they are evaluated
        while(unsettledNodes.size() != 0){
            // todo with PQ, delMin would be sufficient
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for(Map.Entry<Node, Integer> entry : currentNode.adjacentNodes.entrySet()){
                Node neighbor = entry.getKey();
                Integer weight = entry.getValue();
                if(!settledNodes.contains(neighbor)){
                    calculateShortestPath(neighbor, weight, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for(Node node: unsettledNodes){
            int nodeDistance = node.getDistance();
            if(nodeDistance < lowestDistance){
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateShortestPath(Node neighbor, Integer weight, Node currentNode) {
        Integer sourceDistance = currentNode.getDistance();
        if(sourceDistance + weight < neighbor.getDistance()){
            neighbor.setDistance(sourceDistance + weight);
            LinkedList<Node> shortestPath = new LinkedList<>(currentNode.getShortestPath());
            shortestPath.add(currentNode);
            neighbor.setShortestPath(shortestPath);
        }
    }


    private class Graph{
        private Set<Node> nodes = new HashSet<>();
        public void addNode(Node node){
            nodes.add(node);
        }
        public Set<Node> getNodes() {
            return nodes;
        }
    }

    private class Node{
        private String name;
        //list of shortest path of nodes from the starting node
        private List<Node> shortestPath = new LinkedList<>();
        //distance to THIS node from the starting node, initialized as infinity
        private Integer distance = Integer.MAX_VALUE;
        //list of neighbors and the weight on the edge between source and destination
        Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addDestination(Node destination, int distance){
            adjacentNodes.put(destination, distance);
        }

        public Node(String name){
            this.name = name;
        }

        public List<Node> getShortestPath() {
            return shortestPath;
        }

        public void setShortestPath(List<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }
    }
}
