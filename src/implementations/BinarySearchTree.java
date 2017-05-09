package implementations;

import java.util.Comparator;

/**
 * Created by matie on 2017-04-26.
 */
public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node createNode(int data){
        return new Node(data);
    }

    public void add(int data){
        Node node = createNode(data);
        if(isEmpty()){
            root = node;
        }else{
            add(root, node);
        }
    }

    public void add(Node parent, Node node) {
        if(parent == null || node == null) return;
        if(node.compareTo(parent) < 0){ //smaller
            if(parent.left != null){
                add(parent.left, node);
            }else{
                parent.left = node;
            }
        }else{                          //equal or greater
            if(parent.right != null){
                add(parent.right, node);
            }else{
                parent.right = node;
            }
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean isLeaf(Node node){
        return (node != null && node.left == null && node.right == null);
    }

    private class Node implements Comparable{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public int compareTo(Object o) {
            if(o instanceof Node){
                Node node = (Node)o;
                return (node.data < this.data) ? -1 : 1;
            }else{
                throw new ClassCastException();
            }
        }
    }
}
