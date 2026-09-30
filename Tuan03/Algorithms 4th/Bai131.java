import java.util.Arrays;

public class Bai131 {
    class FixedCapacityStackofStrings{
        String[] stack;
        int N;

        FixedCapacityStackofStrings(int size){
            N = 0;
            stack = new String[size];
        }

        void push(String s){
            if(N != stack.length){
                stack[N++] = s;

            }
        }

        String pop(){
            stack[--N] = null;
            return stack[N - 1];
        }

        String peek(){
            return stack[N - 1];
        }

        boolean isFull(){
            return (N == stack.length);
        }
    }

    void main(){
        FixedCapacityStackofStrings fx = new FixedCapacityStackofStrings(5);
        fx.push("a");
        System.out.println(Arrays.toString(fx.stack));
        fx.push("b");
        System.out.println(Arrays.toString(fx.stack));
        fx.push("c");
        System.out.println(Arrays.toString(fx.stack));
        fx.push("d");
        System.out.println(Arrays.toString(fx.stack));
        fx.push("e");
        System.out.println(Arrays.toString(fx.stack));
        System.out.println(fx.isFull());
        fx.pop();
        fx.pop();
        System.out.println(fx.peek());
        System.out.println(Arrays.toString(fx.stack));
        System.out.println(fx.isFull());
    }
}
