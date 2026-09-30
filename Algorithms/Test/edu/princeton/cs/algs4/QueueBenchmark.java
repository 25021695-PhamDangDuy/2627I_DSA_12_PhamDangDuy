package edu.princeton.cs.algs4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class QueueBenchmark {

    static final int ROUNDS = 100_000;
    static final int BATCH = 100;

    static long memory(int[] queue) {
        return (long) queue.length * Integer.BYTES;
    }

    public static void main(String[] args) {

        Stopwatch timer;

        CircularQueue circular = new CircularQueue();

        timer = new Stopwatch();

        for (int r = 0; r < ROUNDS; r++) {
            for (int i = 0; i < BATCH; i++)
                circular.enqueue(i);

            for (int i = 0; i < BATCH - 1; i++)
                circular.dequeue();
        }

        double circularTime = timer.elapsedTime();

        StdOut.println("=== Circular Queue ===");
        StdOut.printf("Time     : %.6f s%n", circularTime);
        StdOut.printf("N        : %d%n", circular.N);
        StdOut.printf("Capacity : %d%n", circular.queue.length);
        StdOut.printf("Memory   : %d bytes (%.2f KB)%n",
                memory(circular.queue),
                memory(circular.queue) / 1024.0);


        ResizingQueue resizing = new ResizingQueue();

        timer = new Stopwatch();

        for (int r = 0; r < ROUNDS; r++) {
            for (int i = 0; i < BATCH; i++)
                resizing.enqueue(i);

            for (int i = 0; i < BATCH - 1; i++)
                resizing.dequeue();
        }

        double resizingTime = timer.elapsedTime();

        StdOut.println();
        StdOut.println("=== Resizing Queue ===");
        StdOut.printf("Time     : %.6f s%n", resizingTime);
        StdOut.printf("N        : %d%n", resizing.N);
        StdOut.printf("Capacity : %d%n", resizing.queue.length);
        StdOut.printf("Memory   : %d bytes (%.2f KB)%n",
                memory(resizing.queue),
                memory(resizing.queue) / 1024.0);
    }
}