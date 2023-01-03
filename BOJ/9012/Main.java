import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            String input = br.readLine();
            int len = input.length();
            if(len % 2 != 0) {
                sb.append("NO").append("\n");
                continue;
            }
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < len; i++) {
                char ch = input.charAt(i);
                if(ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if(!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }
            if(stack.size() == 0) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
