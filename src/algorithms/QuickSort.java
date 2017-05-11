package algorithms;

/**
 * Created by matie on 2017-05-10.
 */
public class QuickSort {
    public void sort(int[] list){
        quickSortHelper(list, 0, list.length - 1);
    }

    private void quickSortHelper(int[] list, int start, int end) {
        if(end < start){
            int splitPoint = partition(list, start, end);
            quickSortHelper(list, start, splitPoint-1);
            quickSortHelper(list, splitPoint+1, end);
        }
    }

    private int partition(int[] list, int start, int end){
        int pivotValue = list[start];
        int leftPointer = start + 1;
        int rightPointer = end;

        boolean done = false;
        while(!done){
            while(leftPointer <= rightPointer && list[leftPointer] <= pivotValue){
                leftPointer++;
            }

            while(rightPointer >= leftPointer && list[rightPointer] >= pivotValue){
                rightPointer--;
            }

            if(rightPointer < leftPointer){
                done = true;
            }else{
                int temp = list[leftPointer];
                list[leftPointer] = list[rightPointer];
                list[rightPointer] = temp;
            }
        }

        int temp = list[start];
        list[start] = list[rightPointer];
        list[rightPointer] = temp;

        return rightPointer;
    }
}
