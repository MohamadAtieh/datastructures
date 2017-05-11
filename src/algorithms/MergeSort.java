package algorithms;

import java.util.Arrays;

/**
 * Created by matie on 2017-05-10.
 */
public class MergeSort {
    public static void main(String[] args){
        int[] list = {54,26,93,17,77,31,44,55,20};
        sort(list);
        print(list);
    }

    private static void print(int[] list){
        for(int num : list){
            System.out.println(num);
        }
    }

    private static void sort(int[] list){
        if(list.length > 1){
            int mid = list.length / 2;
            int[] leftHalf = Arrays.copyOfRange(list, 0, mid);
            int[] rightHalf = Arrays.copyOfRange(list, mid, list.length);

            sort(leftHalf);
            sort(rightHalf);

            int i = 0, j = 0, k = 0;
            while(i < leftHalf.length && j < rightHalf.length){
                if(leftHalf[i] < rightHalf[j]){
                    list[k] = leftHalf[i];
                    i++;
                }else{
                    list[k] = rightHalf[j];
                    j++;
                }
                k++;
            }

            while(i < leftHalf.length){
                list[k] = leftHalf[i];
                i++;
                k++;
            }

            while(j < rightHalf.length){
                list[k] = rightHalf[j];
                j++;
                k++;
            }
        }
    }

}
