import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine(); 
        
        StringBuilder sb = new StringBuilder();
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (char ch : s.toCharArray()) {
            if ('A' <= ch && ch <= 'Z') {
                sb.append(ch);
            }
            else if (ch == '(') {
                stack.addFirst(ch);
            }
            else if (ch == ')') {
                //'('이 나올때까지 연산자를 뺀다.
                while (stack.peekFirst() != '(') {
                    sb.append(stack.removeFirst());
                }
                
                //마지막으로 '('를 뺀다.
                stack.removeFirst();
            }
            //연산자 일 경우,
            else {
                //현재 문자보다 스택에 있는 연산자의 우선순위가 더 클 경우 다 빼서 붙임
                while(!stack.isEmpty() && getPriority(stack.peekFirst()) >= getPriority(ch)) {
                    //바로 붙임
                    sb.append(stack.removeFirst());
                }
                
                stack.addFirst(ch);
            }
        }
        
        //연산자 스택이 남아 있을 경우, 전부 뺀다.
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static int getPriority(char ch) {
        if (ch == '*' || ch == '/') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return 0;
    }
}
