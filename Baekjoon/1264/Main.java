import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashSet<Character> set = new HashSet<>();
        
        set.add('A');
        set.add('a');
    
        set.add('E');
        set.add('e');
        
        set.add('I');
        set.add('i');
        
        set.add('O');
        set.add('o');
        
        set.add('U');
        set.add('u');
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String s = br.readLine();
            
            if (s.equals("#")) {
                break;
            }
            
            int cnt = 0;
            
            for(char ch : s.toCharArray()) {
                if (set.contains(ch)) {
                    cnt += 1;
                }
            }
            
            sb.append(cnt).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
