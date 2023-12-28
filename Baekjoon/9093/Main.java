import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            String str = br.readLine();
            String tokens[] = str.split(" ");
            for(int j = 0; j < tokens.length; j++) {
                Stack<Character> stack = new Stack<>();
                for(int i = 0; i < tokens[j].length(); i++){
                    stack.push(tokens[j].charAt(i));
                }
                while(!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
