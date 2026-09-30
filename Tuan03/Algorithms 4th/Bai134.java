

import java.io.*;
import java.util.Stack;
import java.util.stream.IntStream;

public class Bai134 {
    static class Parenthenses{
        Stack<Character> st = new Stack<>();
        private boolean isMatching(char open, char close){
            return (open == '(' && close == ')')
                    ||(open == '{' && close == '}')
                    ||(open == '[' && close == ']');
        }

        public boolean isTrue(String s){
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);

                if(i == 0 || st.isEmpty() || c == '(' || c == '{' || c == '['){
                    st.push(c);
                }else {
                    if(!isMatching(st.peek(),c)){
                        return false;
                    }
                    st.pop();
                }
            }
            return st.isEmpty();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String s = bufferedReader.readLine();
            Parenthenses pt = new Parenthenses();
            bufferedWriter.write((pt.isTrue(s) ? "true" : "false"));
            bufferedWriter.newLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
