import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

static class Prefix {
    StringBuffer output;
    Stack<Character> process;

    Map<Character, Integer> operator = new HashMap<>();

    public Prefix() {
        output = new StringBuffer();
        process = new Stack<>();

        operator.put('+', 3);
        operator.put('-', 3);
        operator.put('*', 4);
        operator.put('/', 4);
    }

    public void process(char c) {

        if (Character.isDigit(c)) {
            output.append(c);
            return;
        }

        if (c == '(') {
            process.push(c);
            return;
        }

        if (c == ')') {
            while (process.peek() != '(') {
                output.append(process.pop());
            }

            process.pop();
            return;
        }

        if (operator.containsKey(c)) {

            while (!process.isEmpty()
                    && process.peek() != '('
                    && operator.get(process.peek()) >= operator.get(c)) {

                output.append(process.pop());
            }

            process.push(c);
        }
    }

    public void finish() {
        while (!process.isEmpty()) {
            output.append(process.pop());
        }
    }
}

static void main(String[] args) {
    Prefix pf = new Prefix();

    while (!StdIn.isEmpty()) {
        String expression = StdIn.readString();

        for (int i = 0; i < expression.length(); i++) {
            pf.process(expression.charAt(i));
        }

        pf.finish();

        StdOut.println(pf.output);
    }
}