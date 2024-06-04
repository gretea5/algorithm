import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int test = 1; test <= t; test++) {
            int s = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                
                int q = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                
                s += (q * p);
            }
            
            sb.append(s).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
