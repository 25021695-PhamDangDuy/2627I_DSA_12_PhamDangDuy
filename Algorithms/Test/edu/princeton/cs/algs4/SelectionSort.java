package edu.princeton.cs.algs4;

import java.util.Arrays;

public class SelectionSort {

    private static boolean isLess(Comparable a, Comparable b) {
        if (a.compareTo(b) >= 0) {
            return false;
        }
        return true;
    }

    private static void swap(Comparable[] arr, int a, int b){
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void sort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j ++){
                if(isLess(arr[j],arr[min])){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
    }

    void main(){
        Integer[] a = {1,3,2,4,5,2,1,12,5,1235,2};
        sort(a);
    }
}
