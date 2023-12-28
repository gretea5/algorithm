import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isTag = false;
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '<') {
                while(true) {
                    if(stack.isEmpty()) {
                        break;
                    }
                    sb.append(stack.pop());
                }
                isTag = true;
            } else if (ch == '>') {
                sb.append(ch);
                isTag = false;
                continue;
            }
            if (isTag) {
                sb.append(ch);
            } else {
                //태그가 아닌데 공백일 경우
                if(ch == ' ') {
                    //문자열을 반대로
                    while(true) {
                        if(stack.isEmpty()) {
                            break;
                        }
                        sb.append(stack.pop());
                    }
                    //공백을 넣는다.
                    //왜 이 코드가 되냐고? 문제에서 양 옆에 공백은 없다고 주어졌으니까,
                    sb.append(' ');
                    continue;
                } else {
                    stack.push(ch);
                }
            }
        }
        while(true) {
            if (stack.isEmpty()) {
                break;
            }
            sb.append(stack.pop());
        }
        System.out.print(sb.toString());
        br.close();
    }
}
