import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Stack;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayDeque<Character> leftStack = new ArrayDeque<>();
        ArrayDeque<Character> rightStack = new ArrayDeque<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            leftStack.addFirst(c);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char[] c1 = st.nextToken().toCharArray();
            char command = c1[0];
            if (command == 'L') {
                if (!leftStack.isEmpty()) {
                    rightStack.addFirst(leftStack.removeFirst());
                }
            }
            else if (command == 'D') {
                if (!rightStack.isEmpty()) {
                    leftStack.addFirst(rightStack.removeFirst());
                }
            }
            else if (command == 'B') {
                if (!leftStack.isEmpty()) {
                    leftStack.removeFirst();
                }
            }
            else if (command == 'P') {
                char[] c2 = st.nextToken().toCharArray();
                char c = c2[0];
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
        System.out.print(sb);
        br.close();
    }
}
