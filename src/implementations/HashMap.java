package implementations;

import java.util.Map;
import java.util.Objects;


/**
 * Created by matie on 2017-04-17.
 */
public class HashMap<I, D> {

    private int capacity = 10;
    private Node<I, D>[] bucket;


    public HashMap() {
        //noinspection unchecked
        this.bucket = (Node<I,D>[])new Node[capacity];
    }

    public void put(I key, D value){
        if(key == null) return;
        int hash = hash(key);
        Node<I,D> node = new Node<>(hash, key, value, null);

        if(bucket[hash] == null){
            bucket[hash] = node;
        }else{
            Node<I, D> current = bucket[hash];
            Node<I, D> previous = null;
            while(current != null){
                if(current.key.equals(key)){
                    if(previous == null){ //first node
                        node.next = current.next; //replace existing
                        bucket[hash] = node;
                        return;
                    }else{
                        node.next = current.next;
                        previous.next = node;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }

            if(previous != null) {
                previous.next = node;
            }
        }
    }


    public D get(I key){
        int hash = hash(key);
        Node<I, D> node = getNode(hash, key);
        return (node == null) ? null : node.value;
    }

    private int hash(I key){
        return key == null ? 0 : Math.abs(key.hashCode()) % capacity;
    }

    private Node<I, D> getNode(int hash, I key) {
        return null;
    }


    private class Node<K, V>{
        final int hashcode;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hashcode, K key, V value, Node<K, V> next) {
            this.hashcode = hashcode;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " = " + value + "}";
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object o) {
            if(o == this) return true;
            if(o instanceof Node){
                Node<K, V> e = (Node<K,V>)o;
                if(Objects.equals(key, e.key) && Objects.equals(value, e.value)) return true;
            }
            return false;
        }
    }
}
