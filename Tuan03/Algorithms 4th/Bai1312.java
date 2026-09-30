import java.util.Iterator;
import java.util.Stack;

public class Bai1312 {
    Stack<String> st = new Stack<>();

    Stack<String> copy(Stack<String> ref){
        Iterator<String> iterator = ref.iterator();
        Stack<String> result = new Stack<>();
        while(iterator.hasNext()){
            result.push(iterator.next());
        }

        return result;
    }


    void main(){
        Stack<String> ref = new Stack<>();
        ref.push("ad");
        ref.push("ad");
        ref.push("ad");
        ref.push("ad");
        ref.push("ad");
        System.out.println("Ref stack sau push: " + ref);

        Stack<String> copy = copy(ref);
        System.out.println("Copy Stack sau copy: " + copy);

        System.out.println("Xóa thử");
        copy.pop();
        System.out.println("Copy Stack sau xóa: " + copy);
        System.out.println("Ref Stack sau xóa: " + ref);
//        DeepCopy
    }
}
