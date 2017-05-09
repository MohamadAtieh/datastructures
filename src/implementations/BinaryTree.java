package implementations;

/**
 * Created by matie on 2017-04-26.
 */
public class BinaryTree<T> {
    private Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public Node<T> createNode(T data){
        return new Node<>(data);
    }

    private class Node<D>{
        D data;
        Node<D> left;
        Node<D> right;

        public Node(D data) {
            this.data = data;
        }
    }
}
