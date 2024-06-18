import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int ans = 0;
        
        int test = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int student = Integer.parseInt(st.nextToken());
            int apple = Integer.parseInt(st.nextToken());
            
            ans += (apple % student);
        }
        
        System.out.print(ans);
        
        br.close();
    }
}
