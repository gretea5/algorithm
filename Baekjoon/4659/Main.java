import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashSet<Character> set = new HashSet<>();
        
        set.add('a'); 
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String s = br.readLine();
            
            if (s.equals("end")) {
                break;
            }
            
            boolean flag = false;
            
            char[] arr = s.toCharArray();
            
            for(char ch : arr) {
                if (set.contains(ch)) {
                    flag = true;
                    break;
                }
            }
            
            for(int i = 0; i <= arr.length - 3;  i++) {
                char c1 = arr[i];
                char c2 = arr[i + 1];
                char c3 = arr[i + 2];
                
                if (set.contains(c1) && set.contains(c2) && set.contains(c3)) {
                    flag = false;
                    break;
                }
                
                if (!set.contains(c1) && !set.contains(c2) && !set.contains(c3)) {
                    flag = false;
                    break;
                }
            }
            
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == 'e' || ch == 'o') {
                    continue;
                }
                
                StringBuilder builder = new StringBuilder();
                
                for(int i = 0; i < 2; i++) {
                    builder.append(ch);
                }
                
                if (s.contains(builder.toString())) {
                    flag = false;
                    break;
                }
            }
            
            sb.append("<").append(s).append(">");
            
            if (flag) {
                sb.append(" is acceptable.").append("\n");
            }
            else {
                sb.append(" is not acceptable.").append("\n");
            }
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
