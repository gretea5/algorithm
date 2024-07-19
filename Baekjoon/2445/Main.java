import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= n - i; j++) {
                sb.append("*");
            }
            
            for (int j = 1; j <= 2 * i; j++) {
                sb.append(" ");
            }
            
            for (int j = 1; j <= n - i; j++) {
                sb.append("*");
            }
            
            sb.append("\n");
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                sb.append("*");
            }
            
            for (int j = 1; j <= 2 * i; j++) {
                sb.append(" ");
            }
            
            for (int j = 1; j <= n - i; j++) {
                sb.append("*");
            }
            
          
            sb.append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
