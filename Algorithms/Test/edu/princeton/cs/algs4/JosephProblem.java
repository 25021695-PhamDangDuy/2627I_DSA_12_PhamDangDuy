
/*
Sử dụng cài đặt mảng vòng để duyệt bài toán
 */
public static class JosephProblem {
    //Mỗi lần add vào là mọc thêm đuôi
    Node first;
    Node last;
    int N;

    static class Node{
        int value;
        Node next;

        Node(int i, Node c){
            value = i;
            next = c;
        }

    }

    public JosephProblem(int N){
        this.N = N;

        for(int i = N - 1; i >= 0; i--){
            if(i == N - 1){
                first = new Node(i,null);
                last = first;
            }else {
                last = new Node(i,last);
            }
        }

        first.next = last;
    }

    public int solve(int k){
        int step = 1;
        Node pointer = last;
        int stepNeeded = (k > N) ? k % (N): k;
        while(true){
            System.out.println("Step: " + step);
            System.out.println("StepNeeded: " + stepNeeded);

            if(N == 1){
                return first.value;
            }
            if(stepNeeded == 0){
                stepNeeded = stepNeeded + N - 1;
            }
            if(stepNeeded == 1){
                stepNeeded = stepNeeded + N;
            }
            if(step == stepNeeded - 1){

                Node father = pointer.next;
                if(pointer == father.next){
                    return pointer.value;
                }
                pointer.next = father.next;
                father.next = null;

                System.out.println("Loại: " + father.value);
                step = 0;
                N--;
                stepNeeded = (k > N ) ? k % (N): k;

            }

            System.out.println("value old: "+pointer.value);
            pointer = pointer.next;
            step++;
            System.out.println("value new: "+pointer.value);

        }
    }

}

void main(){
    JosephProblem js = new JosephProblem(8);
    System.out.println(js.solve(13));
}


