import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String t = br.readLine();
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
            
            //스택에 폭탄만큼의 문자 이상의 갯수가 들어있다면, 
            if (st.size() >= t.length()) {
                boolean flag = true;
                
                for(int j = 0; j < t.length(); j++) {
                    int idx = st.size() - t.length() + j;
                    
                    //stack에서 get(idx) 연산으로 접근하면서 비교,
                    if (st.get(idx) != t.charAt(j)) {
                        //idx번째 부터 문자가 서로 다르면, 다른거 
                        flag = false;
                        break;
                    }
                }
                
                //문자가 같다면 t의 길이만큼 뺀다.
                if (flag) {
                    int len = t.length();
                    
                    while (len > 0) {
                        st.pop();
                        
                        len -= 1;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        String answer = sb.reverse().toString();
        
        if (answer.isEmpty()) {
            System.out.print("FRULA");
            return;
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
