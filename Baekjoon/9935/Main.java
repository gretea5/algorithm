import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        String bomb = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            //일단 스택에 넣어봄
            stack.push(ch);
            
            //스택의 제일 끝 문자와 폭발 문자열의 끝 문자가 같고, 스택의 폭탄 문자열보다 더 많이 들어가 있다면,
            if (stack.peek() == bomb.charAt(bomb.length() - 1) && stack.size() >= bomb.length()) {
                //폭발 문자열 여부
                boolean flag = true;
                
                //stack에서의 시작 인덱스
                int startIdx = stack.size() - bomb.length();
                
                //폭발 문자열 크기 만큼 비교,
                for (int j = 0; j < bomb.length(); j++) {
                    if (bomb.charAt(j) != stack.get(j + startIdx)) {
                        flag = false;
                        break;
                    }
                }
                
                //폭발 문자열이라면, 폭발 문자열의 크기 만큼 뺀다.
                if (flag) {
                    int length = bomb.length();
                    
                    while (length > 0) {
                        stack.pop();
                        
                        length -= 1;
                    }
                }
            }
        }
        
        //스택이 비어 있다면,
        if (stack.isEmpty()) {
            System.out.print("FRULA");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        System.out.print(sb.reverse());
        
        br.close();
    }
}
