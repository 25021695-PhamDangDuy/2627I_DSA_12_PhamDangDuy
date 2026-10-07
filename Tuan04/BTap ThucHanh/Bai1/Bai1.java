package Bai1;

import edu.princeton.cs.algs4.*;

public class Bai1 {
    public static Integer[] change(int[] a){
        Integer[] rs = new Integer[a.length];
        for(int i = 0 ; i < a.length ; i++){
            rs[i] = a[i];
        }
        return rs;
    }

    public static long stopwatch(String path){
        In in = new In(path); // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a

        Integer[] arr = change(a);

        long start = System.currentTimeMillis();
        // xử lý dữ liệu trong mảng a
        Insertion.sort(arr);
        long end = System.currentTimeMillis();  // thời gian chạy bằng end - start
//        StdArrayIO.print(a); // in mảng ra màn hình
        return end - start;
    }

    public static void test8K(){
        StdOut.println("================[Tập dữ liệu 8K ints]====================");
        StdOut.println("=====================================Dãy sắp xếp xuôi======================================");
        long time_a_1 = stopwatch("Bai1\\data\\ascending_8Kints.txt");
        long time_a_2 = stopwatch("Bai1\\data\\ascending_8Kints.txt");
        long time_a_3 = stopwatch("Bai1\\data\\ascending_8Kints.txt");
        StdOut.println("Time 1: " + time_a_1 + "ms");
        StdOut.println("Time 2: " + time_a_2 + "ms");
        StdOut.println("Time 3: " + time_a_3 + "ms");
        StdOut.println("Time average: " + (time_a_1 + time_a_2 + time_a_3) / 3 + "ms");

        StdOut.println("=====================================Dãy sắp xếp ngược======================================");
        long time_d_1 = stopwatch("Bai1\\data\\descending_8Kints.txt");
        long time_d_2 = stopwatch("Bai1\\data\\descending_8Kints.txt");
        long time_d_3 = stopwatch("Bai1\\data\\descending_8Kints.txt");
        StdOut.println("Time 1: " + time_d_1 + "ms");
        StdOut.println("Time 2: " + time_d_2 + "ms");
        StdOut.println("Time 3: " + time_d_3 + "ms");
        StdOut.println("Time average: " + (time_d_1 + time_d_2 + time_d_3) / 3 + "ms");


        StdOut.println("======================================Dãy bằng nhau sẵn======================================");
        long time_e = stopwatch("Bai1\\data\\equal_8Kints.txt");
        StdOut.println("Time" + time_e + "ms");



        StdOut.println("======================================Dãy ngẫu nhiên======================================");
        long time_t_1 = stopwatch("Bai1\\data\\random_8Kints.txt");
        long time_t_2 = stopwatch("Bai1\\data\\random_8Kints.txt");
        long time_t_3 = stopwatch("Bai1\\data\\random_8Kints.txt");
        long time_t_4 = stopwatch("Bai1\\data\\random_8Kints.txt");
        long time_t_5 = stopwatch("Bai1\\data\\random_8Kints.txt");

        StdOut.println("Time 1" + time_t_1 + "ms");
        StdOut.println("Time 2" + time_t_2 + "ms");
        StdOut.println("Time 3" + time_t_3 + "ms");
        StdOut.println("Time 4" + time_t_4 + "ms");
        StdOut.println("Time 5" + time_t_5 + "ms");
        StdOut.println("Time average: " + (time_t_1 + time_t_3 + time_t_4 + time_t_2 + time_t_5) / 5 + "ms");
    }

    public static void main(String[] args) {
        /*
        Kích thước cố định ban đầu 4Kints
         */
        StdOut.println("================[Tập dữ liệu 4K ints]====================");
        StdOut.println("=====================================Dãy sắp xếp xuôi======================================");
        long time_a_1 = stopwatch("Bai1\\data\\ascending_4Kints.txt");
        long time_a_2 = stopwatch("Bai1\\data\\ascending_4Kints.txt");
        long time_a_3 = stopwatch("Bai1\\data\\ascending_4Kints.txt");
        StdOut.println("Time 1: " + time_a_1 + "ms");
        StdOut.println("Time 2: " + time_a_2 + "ms");
        StdOut.println("Time 3: " + time_a_3 + "ms");
        StdOut.println("Time average: " + (time_a_1 + time_a_2 + time_a_3) / 3 + "ms");

        StdOut.println("=====================================Dãy sắp xếp ngược======================================");
        long time_d_1 = stopwatch("Bai1\\data\\descending_4Kints.txt");
        long time_d_2 = stopwatch("Bai1\\data\\descending_4Kints.txt");
        long time_d_3 = stopwatch("Bai1\\data\\descending_4Kints.txt");
        StdOut.println("Time 1: " + time_d_1 + "ms");
        StdOut.println("Time 2: " + time_d_2 + "ms");
        StdOut.println("Time 3: " + time_d_3 + "ms");
        StdOut.println("Time average: " + (time_d_1 + time_d_2 + time_d_3) / 3 + "ms");


        StdOut.println("======================================Dãy bằng nhau sẵn======================================");
        long time_e = stopwatch("Bai1\\data\\equal_4Kints.txt");
        StdOut.println("Time" + time_e + "ms");



        StdOut.println("======================================Dãy ngẫu nhiên======================================");
        long time_t_1 = stopwatch("Bai1\\data\\test_4Kints.txt");
        long time_t_2 = stopwatch("Bai1\\data\\test_4Kints.txt");
        long time_t_3 = stopwatch("Bai1\\data\\test_4Kints.txt");
        long time_t_4 = stopwatch("Bai1\\data\\test_4Kints.txt");
        long time_t_5 = stopwatch("Bai1\\data\\test_4Kints.txt");

        StdOut.println("Time 1" + time_t_1 + "ms");
        StdOut.println("Time 2" + time_t_2 + "ms");
        StdOut.println("Time 3" + time_t_3 + "ms");
        StdOut.println("Time 4" + time_t_4 + "ms");
        StdOut.println("Time 5" + time_t_5 + "ms");
        StdOut.println("Time average: " + (time_t_1 + time_t_3 + time_t_4 + time_t_2 + time_t_5) / 5 + "ms");



        test8K();


        StdOut.println("Ta thấy rằng như sau: 1. Với tập dữ liệu đã sắp xếp 1 phần, thì thuật toán này có tốc độ rất nhanh. Nhưng nếu là tập dữ liệu ngược thì chậm. Với việc tăng lên 8K ints thì tốc độ của các mẫu vẫn có điểm như đã nói trên");
    }

}
