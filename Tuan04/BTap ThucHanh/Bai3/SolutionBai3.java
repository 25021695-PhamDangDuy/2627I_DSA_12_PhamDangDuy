package Bai3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class SolutionBai3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);
        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void print(List<Integer> arr){
        System.out.println(arr.stream().map(String::valueOf).collect(Collectors.joining(" "))
        );
    }

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        Integer target = arr.get(n - 1);
        if(n == 1){
            System.out.println(target);
        }else{
            Integer p = n - 2;
            boolean istrue = true;
            while(p >= 0 & istrue){
                arr.set(p + 1, arr.get(p));
                if(arr.get(p) < target){
                    arr.set(p + 1,target);
                    print(arr);
                    break;
                }
                p--;
                print(arr);
            }
            if(p == -1){
                arr.set(0,target);
                print(arr);
            }

        }

    }

}
