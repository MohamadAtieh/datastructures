package implementations;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds a single tree node which is the root
 *
 * Created by matie on 2017-04-25.
 */
public class Tree<D> {
    private Node<D> root;

    // TODO: 2017-04-25 Add methods related to trees


    /**
     * Class representing a tree node
     *
     * @param <T>
     */
    private class Node<T> {
        private List<Node<T>> children = new ArrayList<>();
        private Node<T> parent;
        private T data;

        private Node(T data){
            this.data = data;
        }

        private Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
        }

        private List<Node<T>> getChildren() {
            return children;
        }

        private void setChildren(List<Node<T>> children) {
            this.children = children;
        }

        private Node<T> getParent() {
            return parent;
        }

        private void setParent(Node<T> parent) {
            this.parent = parent;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private void addChild(T data){
            Node<T> childNode = new Node<>(data);
            addChild(childNode);
        }

        private void addChild(Node<T> childNode){
            childNode.setParent(this);
            this.children.add(childNode);
        }

        private boolean isRoot(){
            return this.parent == null;
        }

        private boolean isLeaf(){
            return this.children.size() == 0;
        }

        private void removeParent(){
            setParent(null);
        }

    }
}
