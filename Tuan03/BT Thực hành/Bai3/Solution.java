package Bai3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static class Queue2Stack<Item> {
        Stack<Item> store = new Stack<>();
        Stack<Item> temp = new Stack<>();

        public void enqueue(Item i){
            store.push(i);
        }

        public void changeData(){
            while(!store.isEmpty()){
                Item item = store.pop();
                temp.push(item);
            }
        }

        public Item dequeue(){
            if(temp.isEmpty()){
                changeData();
            }
            return temp.pop();
        }
        public Item print(){
            Item result = null;
            if(temp.isEmpty()){
                changeData();
            }
            return (temp.peek());
        }
    }
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstLine = reader.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) {
            return;
        }

        int q = Integer.parseInt(firstLine.trim());
        Queue2Stack<Integer> queue = new Queue2Stack<>();

        for (int i = 0; i < q; i++) {
            String line = reader.readLine();
            if (line == null) break;

            StringTokenizer tokenizer = new StringTokenizer(line);
            if (!tokenizer.hasMoreTokens()) continue;

            int type = Integer.parseInt(tokenizer.nextToken());

            switch (type) {
                case 1:
                    int val = Integer.parseInt(tokenizer.nextToken());
                    queue.enqueue(val);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    writer.write(String.valueOf(queue.print()));
                    writer.newLine();
                    break;
            }
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}