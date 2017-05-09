package implementations;

import java.util.Arrays;

/**
 * Created by matie on 2017-04-17.
 */
public class ArrayList<T> {
    private Object[] store;
    private int currentSize = 0;

    public ArrayList() {
        store = new Object[10];
    }

    public ArrayList(int size) {
        store = new Object[size];
    }

    public Object get(int index){
        if(index < currentSize){
            return store[index];
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(Object obj){
        if(store.length - currentSize <= 5){
            increaseStoreLength();
        }
        store[currentSize++] = obj;
    }

    public Object remove(int index){
        if(index >= currentSize) throw new ArrayIndexOutOfBoundsException();
        Object obj = store[index];
        store[index] = null; // remove
        for(int i = index; i < currentSize; i++){
            store[i] = store[i+1];
            store[i+1] = null; //ensure last item is moved one back and is null'ed
        }
        return obj;
    }

    private void increaseStoreLength() {
        store = Arrays.copyOf(store, store.length * 2);
        System.out.println("New Length - " + store.length);
    }

    private int size(){
        return currentSize;
    }
}
