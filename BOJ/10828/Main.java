import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            if(command.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                stack.push(number);
            } else if(command.equals("pop")) {
                System.out.println((stack.isEmpty() ? -1 : stack.pop()));
            } else if(command.equals("size")) {
                System.out.println(stack.size());
            } else if(command.equals("empty")) {
                System.out.println((stack.isEmpty() ? 1 : 0));
            } else if(command.equals("top")) {
                System.out.println((stack.isEmpty() ? -1 : stack.peek()));
            }
        }
        br.close();
    }
}

