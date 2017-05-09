package implementations;

import java.util.EmptyStackException;

/**
 * Last In First Out
 * Created by matie on 2017-04-17.
 */
public class Stack<T> {
    private Node<T> head;

    public Stack(){}

    public Node peek(){
        if(isEmpty()) throw new EmptyStackException();
        return head;
    }

    public Node pop(){
        if(isEmpty()) throw new EmptyStackException();

        Node node = head;
        head = head.next;
        return node;
    }

    public void push(Node<T> node){
        if(isEmpty()){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    private class Node<D>{
        D data;
        Node<D> next;
        private Node(D data){
            this.data = data;
        }
    }
}
