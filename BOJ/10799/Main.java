import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String input = br.readLine();
        char before = ' ';
        int answer = 0;
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.addFirst('(');
            }
            else {
                if (before == '(') {
                    stack.removeFirst();
                    answer += stack.size();
                }
                else {
                    stack.removeFirst();
                    answer += 1;
                }
            }
            before = ch;
        }
        System.out.print(answer);
        br.close();
    }
}
