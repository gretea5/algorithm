import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if(input.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if(ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if(ch == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        stack.push(ch);
                    } else {
                        stack.pop();
                    }
                } else if(ch == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        stack.push(ch);
                    } else {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty())  sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
