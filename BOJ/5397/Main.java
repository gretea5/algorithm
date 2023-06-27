import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            String input = br.readLine();
            ArrayDeque<Character> leftStack = new ArrayDeque<>();
            ArrayDeque<Character> rightStack = new ArrayDeque<>();
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '<') {
                    if (!leftStack.isEmpty()) {
                        rightStack.addFirst(leftStack.removeFirst());
                    }
                }
                else if (c == '>') {
                    if (!rightStack.isEmpty()) {
                        leftStack.addFirst(rightStack.removeFirst());
                    }
                }
                else if (c == '-') {
                    if (!leftStack.isEmpty()) {
                        leftStack.removeFirst();
                    }
                }
                else {
                    leftStack.addFirst(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!leftStack.isEmpty()) {
                rightStack.addFirst(leftStack.removeFirst());
            }
            while(!rightStack.isEmpty()) {
                sb.append(rightStack.removeFirst());
            }
            sb.append("\n");
            System.out.print(sb);
        }
        br.close();
    }
}
