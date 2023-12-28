import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String input = br.readLine();
        int answer = 0;
        int value = 1;
        boolean flag = true;
        char before = ' ';
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '(') {
                stack.addFirst(c);
                value *= 2;
            }
            else if(c == '[') {
                stack.addFirst(c);
                value *= 3;
            }
            else if (c == ')') {
                if(stack.isEmpty() || stack.peekFirst() != '(') {
                    flag = false;
                    break;
                }
                if (before == '(') {
                    answer += value;
                }
                stack.removeFirst();
                value /= 2;
            }
            else if(c == ']') {
                if(stack.isEmpty() || stack.peekFirst() != '[') {
                    flag = false;
                    break;
                }
                if (before == '[') {
                    answer += value;
                }
                stack.removeFirst();
                value /= 3;
            }
            before = c;
        }
        if (!flag || !stack.isEmpty()) {
            System.out.print(0);
            return;
        }
        System.out.print(answer);
        br.close();
    }
}
