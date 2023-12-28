import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0) { stack.push(num);}
            else { stack.pop();}
        }
        if(stack.isEmpty()) {
            System.out.print("0");
            return;
        }
        else {
            int sum = 0;
            while(!stack.isEmpty()) {
                sum += stack.pop();
            }
            System.out.print(sum);
        }
        br.close();
    }
}
