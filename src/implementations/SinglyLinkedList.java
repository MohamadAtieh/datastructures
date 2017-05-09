package implementations;

import java.util.EmptyStackException;

/**
 *
 *
 * Created by matie on 2017-04-25.
 */
public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList(){}

    public void addLast(T data){
        Node<T> node = createNode(data);
        if(isEmpty()){
            head = node;
        }else{
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public void addFirst(T data){
        Node<T> node = createNode(data);
        if(isEmpty()){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public void add(int index, T data){
        if(index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        Node<T> node = createNode(data);

        if(index == 0){
            addFirst(data);
        }else{
            Node<T> current = head;
            for(int i = 0; i < size; i++){
                if(i + 1 == index){
                    node.next = current.next;
                    current.next = node;
                    break;
                }
                current = current.next;
            }
        }

        size++;
    }

    public void removeFirst(){
        if(isEmpty()) throw new EmptyStackException();
        head = head.next;
        size--;
    }

    public void removeLast(){
        if(isEmpty()) throw new EmptyStackException();
        Node<T> current = head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
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
                if(i + 1 == index){
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
                i++;
            }
            size--;
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private Node<T> createNode(T data) {
        return new Node<>(data);
    }

    public int getSize(){
        return size;
    }


    private class Node<D>{
        D data;
        Node<D> next;

        Node(D data){
            this.data = data;
        }
    }
}
