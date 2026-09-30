import java.util.*;

public class Bai1310 {
    Map<Character,Integer> map;
    Bai1310(){
        map = new HashMap<>(Map.of(
                '+',1,
                '-',1,
                '*',2,
                '/',2
        ));
    }

    private boolean isOperator(char c){
        return (map.containsKey(c)) || c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}';
    }

    private boolean isMatching(char open, char close){
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }

    public String InfixToPostfix(Character[] s){
        Stack<Character> op = new Stack<>();
        StringBuffer rs = new StringBuffer();

        for(char c : s){
            //Ngoặc mở
            if(c == '(' || c == '{' || c == '['){
                op.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                while(!op.isEmpty() && !isMatching(op.peek(),c)){
                    rs.append(op.pop());
                }
                op.pop();
            } else if (map.containsKey(c)) {
                while(!op.isEmpty() && map.containsKey(op.peek()) && map.get(op.peek()) >= map.get(c)){
                    rs.append(op.pop());
                }
                op.push(c);
            }else {
                rs.append(c);
            }
        }

        while(!op.isEmpty()){
            rs.append(op.pop());
        }

        return rs.toString();
    }


    void main(String[] args) {
        String a = "( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )";

        List<Character> charList = new ArrayList<>();
        for (char c : a.toCharArray()) {
            if (c != ' ') { // Bỏ qua khoảng trắng
                charList.add(c);
            }
        }

        // Chuyển List<Character> sang mảng đối tượng Character[]
        Character[] tokens = charList.toArray(new Character[0]);

        // In kiểm tra
        System.out.println(Arrays.toString(tokens));

        Bai1310 bai = new Bai1310();
        System.out.println(bai.InfixToPostfix(tokens));;
    }
}


