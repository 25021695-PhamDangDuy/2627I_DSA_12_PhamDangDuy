package Bai4;

import java.io.*;
import java.util.*;
class Student implements Comparable<Student>{
    public int ID;
    public String name;
    public double gpa;

    public Student(int id, String name, double gpa){
        this.ID = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student b){
        if(gpa == b.gpa){
            if(name.compareTo(b.name) == 0){
                return (ID < b.ID) ? 1 : -1;
            }else{
                return -name.compareTo(b.name);
            }
        }else{
            return (gpa > b.gpa) ? 1 : -1;
        }
    }


}
class InsertionSort{
    public static boolean isStronger(Comparable a, Comparable b){
        if(a.compareTo(b) > 0){
            return true;
        }
        return false;
    }

    public static void swap(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(Comparable[] arr){
        for(int i = 1; i < arr.length; i++){
            int p = i - 1;
            while(p >= 0){
                if(!isStronger(arr[p],arr[p + 1])){swap(arr, p + 1, p);}
                p--;
            }
        }
    }
}
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();
            Student student = new Student(id, name, cgpa);

            arr[i] = student;
        }

        InsertionSort.sort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i].name);
        }

    }
}