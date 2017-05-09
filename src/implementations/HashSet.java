package implementations;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by matie on 2017-04-26.
 */
public class HashSet<T> {
    private Map<T, Object> map = new HashMap<>();
    private static final Object VALUE = new Object();

    public void add(T data){
        map.put(data, VALUE);
    }

    public void remove(T data){
        if(data != null && map.containsKey(data)){
            map.remove(data);
        }
    }

    public boolean contains(T data){
        return map.containsKey(data);
    }

    public int size(){
        return map.size();
    }
}
