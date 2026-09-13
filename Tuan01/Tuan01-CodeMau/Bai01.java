import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * {@code Bai1-Testcase.errorQuickFind} thuật toán mô phỏng trong bài tập 1 - tuần 01
 */
public class errorQuickFind {
    public int[] leader;
    private int count;

    public errorQuickFind(int n){
        leader = new int[n];
        for(int i = 0; i < n; i++){
            leader[i] = i;
        }
        count = n;
    }

    public int find(int p) throws IllegalArgumentException{
        if(p < 0 || p >= leader.length){
            throw  new IllegalArgumentException();
        }
        return leader[p];
    }

    public void union(int p, int q){
        for (int i = 0; i < leader.length ; i++){
            if(leader[i] == leader[p]){
                leader[i] = leader[q];
            }
        }
    }

}

public void main(String[] args) {
    int n = StdIn.readInt();
    errorQuickFind uf = new errorQuickFind(n);
    for(int i = 0; i < uf.leader.length; i++){
        StdOut.printf(uf.leader[i] + " ");
    }
    StdOut.println();
    while (!StdIn.isEmpty()) {
        int p = StdIn.readInt();
        int q = StdIn.readInt();
        if (uf.find(p) == uf.find(q)) continue;
        uf.union(p, q);
    }

    for(int i = 0 ; i < uf.leader.length ; i++){
        StdOut.println("=====CHECK====");
        StdOut.println("find check " + i + " " + "5" + " -> " + (uf.find(i) == uf.find(5)));
    }

}
