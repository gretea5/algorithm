import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            
            long dist = y - x;
            
            long k = 1;
            
            while (true) {
                if (k * (k + 1) >= dist) {
                    break;
                }
                
                k += 1;
            }
            
            long answer = -1;
            
            if (dist > (k * k)) {
                answer = 2 * k;
            }
            else {
                answer = (2 * k) - 1;
            }
            
            sb.append(answer).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
