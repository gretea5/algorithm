import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int left;
    private static int right;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        left = 1;
        right = m;
        
        int answer = 0;
        
        int k = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < k; i++) {
            int f = Integer.parseInt(br.readLine());
            
            if (f < left) {
                int dist = left - f;
                
                left -= dist;
                right -= dist;
                
                answer += dist;
            }
            else if (right < f) {
                int dist = f - right;
                
                left += dist;
                right += dist;
                
                answer += dist;
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
