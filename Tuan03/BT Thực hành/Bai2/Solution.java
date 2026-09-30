package Bai2;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {
    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static boolean isMatching(char open, char close){
        return (open == '{' && close == '}')
                || (open == '(' && close == ')')
                || (open == '[' && close == ']');

    }

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i == 0 || st.isEmpty()){
                st.push(c);
            }
            if(c == '{' || c == '(' || c == '['){
                st.push(c);
            }else {
                if(!isMatching(st.peek(),c)) {
                    return "NO";
                }else {
                    st.pop();
                }
            }
        }
        return (st.isEmpty()) ? "YES" : "NO";

    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();
                String result = Result.isBalanced(s);
                System.out.println(result);
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
