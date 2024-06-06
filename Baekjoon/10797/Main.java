import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int answer = 0;
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < 5; i++) {
            int v = Integer.parseInt(st.nextToken());
            
            if (n == v) {
                answer += 1;
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
