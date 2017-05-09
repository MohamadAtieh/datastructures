package implementations;

import java.util.Collections;
import java.util.List;

/**
 * Created by matie on 2017-05-09.
 */
public class MaxHeap {
    private int currentSize;
    private List<Integer> heapList;

    public MaxHeap() {
        this.heapList = Collections.singletonList(0);
        this.currentSize = 0;
    }

    public void insert(int value){
        heapList.add(value);
        currentSize++;
        percUp(currentSize);
    }

    private void percUp(int position) {
        while(position / 2 > 0){
            if(heapList.get(position) > heapList.get(position / 2)){
                //swap
                int temp = heapList.get(position / 2);
                heapList.set(position / 2, heapList.get(position));
                heapList.set(position, temp);
            }
            position /= 2;
        }
    }

    public int delMax() {
        int retVal = heapList.get(1);
        heapList.set(1, heapList.get(currentSize));
        heapList.remove(currentSize--);
        percDown(1);
        return retVal;
    }

    private void percDown(int position) {
        while(position * 2 <= currentSize){
            int maxChildIndex = getMaxChildIndex(position);
            if(heapList.get(position) < heapList.get(maxChildIndex)){
                int temp = heapList.get(position);
                heapList.set(position, heapList.get(maxChildIndex));
                heapList.set(maxChildIndex, temp);
            }
            position = maxChildIndex;
        }
    }

    private int getMaxChildIndex(int position) {
        if(position * 2 > currentSize){
            return position * 2;
        }else{
            if(heapList.get(position * 2) > heapList.get(position * 2 + 1)){
                return position * 2;
            }else{
                return position * 2 + 1;
            }
        }
    }
}
