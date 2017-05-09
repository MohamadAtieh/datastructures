package implementations;

import java.util.EmptyStackException;

/**
 * Created by matie on 2017-04-25.
 */
public class DoubleyLinkedList<T> {
    private Node<T> head;
    private int size;

    private DoubleyLinkedList(){}

    public void addFirst(T data){
        Node<T> node = createNode(data);
        if(isEmpty()){
            head = node;
        }else{
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    public void addLast(T data){
        Node<T> node = createNode(data);
        if(isEmpty()){
            head = node;
        }else{
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            node.previous = current;
            current.next = node;
        }
        size++;
    }

    public void add(int index, T data){
        if(index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        Node<T> node = createNode(data);
        if(index == 0){
            addFirst(data);
        }else {
            Node<T> current = head;
            int i = 0;
            while(i < size){
                if(i + 1 == index){
                    node.next = current.next;
                    node.previous = current;
                    current.next.previous = node;
                    current.next = node;
                    break;
                }
                current = current.next;
                i++;
            }
            size++;
        }
    }

    public void removeFirst(){
        if(isEmpty()) throw new EmptyStackException();
        head = head.next;
        head.previous = null; //used to be head
        size--;
    }

    public void removeLast(){
        if(isEmpty()) throw new EmptyStackException();
        Node<T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.previous.next = null;
        size--;
    }

    public void remove(int index){
        if(isEmpty()) throw new EmptyStackException();
        if(index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();

        if(index == 0){
            removeFirst();
        }else{
            Node<T> current = head;
            int i = 0;
            while(i < size){
                if(i == index){
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    break;
                }
                current = current.next;
                i++;
            }
            size--;
        }

    }

    public Node<T> createNode(T data){
        return new Node<>(data);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private class Node<D>{
        D data;
        Node<D> next;
        Node<D> previous;

        Node(D data){
            this.data = data;
        }
    }
}
