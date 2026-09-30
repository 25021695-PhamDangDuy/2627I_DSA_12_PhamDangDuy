package edu.princeton.cs.algs4;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingQueue {
    int[] queue;
    int N;
    int first;
    int last;

    public ResizingQueue(){
        queue = new int[4];
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void enqueue(int i){
        if(N == 0) {
            queue[0] = i;
            first = 0;
            last = 0;
            N++;
        }else {
            queue[++last] = i;
            N++;

        }

        if (N == queue.length || last == queue.length - 1) {
            resize();
        }
    }

    public int dequeue(){
        int rs = queue[first];
        queue[first] = 0;
        first++;
        N--;
        if(N == 0){
            first = 0;
            last = 0;
        }
        return rs;
    }

    public void resize(){
        int[] newarr = new int[queue.length * 2];

        int idx = 0;
        for(int i = first; i <= last; i++){
            newarr[idx] = queue[i];
            idx++;
        }
        first = 0;
        last = N - 1;
        queue = newarr;
    }
}
//
//static void main(String[] args) {
//    ResizingQueue q = new ResizingQueue();
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