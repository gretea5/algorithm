import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int k = 0; k < N; k++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(stack.size() == 0) {
                    stack.push(ch);
                } else if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            if(stack.size() == 0) {
                count += 1;
            }
        }
        System.out.print(count);
        br.close();
    }
}
