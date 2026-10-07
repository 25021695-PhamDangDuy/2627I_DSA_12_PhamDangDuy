package edu.princeton.cs.algs4;

import java.util.Arrays;

public class InsertionSort {
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
        for(int i = 1; i < arr.length; i++){
            int p = i - 1;
//            if(i == 1){
//                if(isLess(arr[i],arr[p])){swap(arr,i,p);}
//            }
            while(p >= 0){
                if(isLess(arr[p + 1],arr[p])){
                    swap(arr,p + 1,p);
                }
                p--;
            }
        }
    }

    void main(){
        Integer[] a = {1, 3, 2, 4, 5, 2, 1, 12, 5, 1235, 2};
        sort(a);
        System.out.println(Arrays.toString(a));

        Integer[] b = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(b);
        System.out.println(Arrays.toString(b));

        Integer[] c = {5, 5, 5, 5, 5};
        sort(c);
        System.out.println(Arrays.toString(c));

        Integer[] d = {-5, 10, -2, 0, 7, -9, 3};
        sort(d);
        System.out.println(Arrays.toString(d));
    }
}
