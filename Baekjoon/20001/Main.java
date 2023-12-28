import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        while(true) {
            String str = br.readLine();
            if(str.equals("고무오리 디버깅 끝")) {
                break;
            }
            if(str.equals("문제")) {
                stack.push(str);
            }
            else if(str.equals("고무오리")) {
                if(stack.isEmpty()) {
                    stack.push("문제");
                    stack.push("문제");
                }
                else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) {
            System.out.print("힝구");
        }
        else {
            System.out.print("고무오리야 사랑해");
        }
        br.close();
    }
}
