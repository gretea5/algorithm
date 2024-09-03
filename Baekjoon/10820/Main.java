import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String s = br.readLine();
            
            if (s == null || s.isEmpty()) {
                break;
            }
            
            int lower = 0;
            int upper = 0;
            int number = 0;
            int blank = 0;
            
            char[] arr = s.toCharArray();
            
            for (char ch : arr) {
                if ('a' <= ch && ch <= 'z') {
                    lower += 1;
                }
                else if ('A' <= ch && ch <='Z') {
                    upper += 1;
                }
                else if ('0' <= ch && ch <= '9') {
                    number += 1;
                }
                else {
                    blank += 1;
                }
            }
            
            sb.append(lower).append(" ");
            sb.append(upper).append(" ");
            sb.append(number).append(" ");
            sb.append(blank).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
