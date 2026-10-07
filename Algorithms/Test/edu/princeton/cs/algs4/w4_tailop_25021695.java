package edu.princeton.cs.algs4;

import java.util.*;

public class w4_tailop_25021695 {
    static class Solution {
        public int solve(int n, int[] arr) {
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < n) {
                    n--;
                }
            }
            return n;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution solution = new Solution();

        System.out.println(solution.solve(n, arr));

        sc.close();
    }
}