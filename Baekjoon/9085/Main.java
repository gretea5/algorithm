import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int sum = 0;
            
            for(int i = 0; i < n; i++) {
                sum += Integer.parseInt(st.nextToken());
            }
            
            sb.append(sum).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
