import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");    
            
            int m = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            
            if (m == 0 && f == 0) {
                break;
            }
            
            sb.append(m + f).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
