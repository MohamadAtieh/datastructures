package implementations;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * First In First Out
 * Created by matie on 2017-04-17.
 */
public class Queue<T> {
    private Node<T> front, rear;

    public Queue(){}

    public T dequeue(){
        if(isEmpty()) throw new NoSuchElementException();

        Node<T> node = front;
        front = front.next;
        if(front == null){
            rear = null;
        }
        return node.data;
    }

    public void enqueue(T data){
        Node<T> node = new Node<>(data);
        if(isEmpty()){
            front = node;
            rear = node;
        }else{
            rear.next = node;
            rear = node;
        }
    }

    public T peek(){
        if(isEmpty()) throw new EmptyStackException();
        return front.data;
    }

    public boolean isEmpty(){
        return front == null & rear == null;
    }

    private class Node<D>{
        Node<D> next;
        D data;
        private Node(D data){
            this.data = data;
        }
    }

}
