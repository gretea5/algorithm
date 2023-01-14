import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        stack.push(input.charAt(0));
        for(int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    stack.push(c);
                }
                else {
                    stack.pop();
                }
            }
        }
        System.out.print(stack.size());
        br.close();
    }
}
