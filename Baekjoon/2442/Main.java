import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            //공백을 출력하기
            for(int j = 1; j <= n - i; j++) {
                sb.append(" ");
            }
            
            //별을 출력하기
            for(int k = 1; k <= (2 * i) - 1; k++) {
                sb.append("*");
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
