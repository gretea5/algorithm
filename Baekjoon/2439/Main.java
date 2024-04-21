import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            //공백
            for(int j = n - i; j > 0; j--) {
                sb.append(" ");
            }
            
            for(int k = 1; k <= i; k++) {
                sb.append("*");
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
