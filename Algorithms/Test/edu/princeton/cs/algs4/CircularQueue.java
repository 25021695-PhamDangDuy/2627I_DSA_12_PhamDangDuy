package edu.princeton.cs.algs4;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CircularQueue {
    int[] queue;
    int N;
    int first;
    int last;

    public CircularQueue(){
        N = 0;
        queue = new int[4];
        first = 0;
        last = 0;
    }

    public void enqueue(int i){
        if(N == 0) {
            queue[0] = i;
            first = 0;
            last = 0;
            N++;
        }else {
            last++;
            int idx = last % queue.length;
            queue[idx] = i;
            N++;
        }

        if (N == queue.length) {
            resize(2);
        }
    }

    public int dequeue(){
        int idx = first % queue.length;
        int rs = queue[idx];
        queue[idx] = 0;
        first++;
        N--;
        if(N == 0){
            first = 0;
            last = 0;
        }

        if (N == queue.length / 4 && queue.length >= 8){
            resize(0.5);
        }
        return rs;
    }
    public void resize(double con){
        int newlength = (int) (queue.length * con);
        int[] newarr = new int[newlength];

        int idx = 0;
        for(int i = first; i <= last; i++){
            int oldIdx = i % queue.length;
            newarr[idx] = queue[oldIdx];
            idx++;
        }
        first = 0;
        last = N - 1;
        queue = newarr;
    }


    public boolean isEmpty(){
        return N == 0;
    }
}
//void main(String[] args) {
//    CircularQueue q = new CircularQueue();
//
//    while (!StdIn.isEmpty()) {
//        String op = StdIn.readString();
//
//        if (op.equals("+")) {
//            int x = StdIn.readInt();
//            q.enqueue(x);
//        } else if (op.equals("-")) {
//            if (!q.isEmpty())
//                StdOut.println("dequeue: " + q.dequeue());
//            else
//                StdOut.println("Queue empty");
//        }
//
//        StdOut.println(
//                "N = " + q.N +
//                        ", first = " + q.first +
//                        ", last = " + q.last
//        );
//
//
//        StdOut.print(Arrays.toString(q.queue));
//        StdOut.println();
//        StdOut.println();
//    }


//}