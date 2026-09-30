import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Bai1311 {
    private boolean isOperator(char c){
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    public int caculate(int first, int last, char op){
        if(op == '+'){
            return first + last;
        } else if (op == '-') {
            return first - last;
        } else if (op == '*') {
            return first * last;
        } else  {
            return first / last;
        }

    }
    public int EvaluatePostfix(char[] s){
        Stack<Integer> rs = new Stack<>();

        for(char c : s){
            if(isOperator(c)){
                int last = rs.pop();
                int first = rs.pop();
                rs.push(caculate(first,last,c));
            }else {
                rs.push(Integer.parseInt(String.valueOf(c)));
            }
        }

        return rs.pop();
    }

//    void main(){
//        String a = "( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )";
//
//        List<Character> charList = new ArrayList<>();
//        for (char c : a.toCharArray()) {
//            if (c != ' ') { // Bỏ qua khoảng trắng
//                charList.add(c);
//            }
//        }
//
//        // Chuyển List<Character> sang mảng đối tượng Character[]
//        Character[] tokens = charList.toArray(new Character[0]);
//
//        // In kiểm tra
//        System.out.println(Arrays.toString(tokens));
//
//        Bai1310 bai = new Bai1310();
//        String rs = bai.InfixToPostfix(tokens);
//        System.out.println(rs);;
//
//        char[] testcase = rs.toCharArray();
//
//        Bai1311 bai1311 = new Bai1311();
//        System.out.println(bai1311.EvaluatePostfix(testcase));
//
//    }
}

class Main {
    public static void main(String[] args) {
        Bai1310 bai10 = new Bai1310();
        Bai1311 bai11 = new Bai1311();

        // 1. Biểu thức mẫu
        String a1 = "( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )";
        String post1 = bai10.InfixToPostfix(getTokens(a1));
        System.out.println(post1 + " -> " + bai11.EvaluatePostfix(post1.toCharArray()) + " (Kỳ vọng: 12+34-56-** -> 3)");

        // 2. Nhân chia trước, cộng trừ sau
        String a2 = "1 + 2 * 3";
        String post2 = bai10.InfixToPostfix(getTokens(a2));
        System.out.println(post2 + " -> " + bai11.EvaluatePostfix(post2.toCharArray()) + " (Kỳ vọng: 123*+ -> 7)");

        // 3. Ngoặc tròn đổi độ ưu tiên
        String a3 = "( 1 + 2 ) * 3";
        String post3 = bai10.InfixToPostfix(getTokens(a3));
        System.out.println(post3 + " -> " + bai11.EvaluatePostfix(post3.toCharArray()) + " (Kỳ vọng: 12+3* -> 9)");

        // 4. Bẫy kết hợp trái phép trừ
        String a4 = "8 - 4 - 2";
        String post4 = bai10.InfixToPostfix(getTokens(a4));
        System.out.println(post4 + " -> " + bai11.EvaluatePostfix(post4.toCharArray()) + " (Kỳ vọng: 84-2- -> 2)");

        // 5. Bẫy kết hợp trái phép chia
        String a5 = "8 / 4 / 2";
        String post5 = bai10.InfixToPostfix(getTokens(a5));
        System.out.println(post5 + " -> " + bai11.EvaluatePostfix(post5.toCharArray()) + " (Kỳ vọng: 84/2/ -> 1)");

        // 6. Ngoặc vuông và nhọn lồng nhau
        String a6 = "[ 1 + { 2 * ( 3 + 4 ) } ]";
        String post6 = bai10.InfixToPostfix(getTokens(a6));
        System.out.println(post6 + " -> " + bai11.EvaluatePostfix(post6.toCharArray()) + " (Kỳ vọng: 1234+*+ -> 15)");

        // 7. Hỗn hợp không ngoặc
        String a7 = "9 - 2 * 3 + 4 / 2";
        String post7 = bai10.InfixToPostfix(getTokens(a7));
        System.out.println(post7 + " -> " + bai11.EvaluatePostfix(post7.toCharArray()) + " (Kỳ vọng: 923*-42/+ -> 5)");
    }

    private static Character[] getTokens(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') list.add(c);
        }
        return list.toArray(new Character[0]);
    }
}


