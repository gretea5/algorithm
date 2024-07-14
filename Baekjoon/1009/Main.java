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
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int answer = 1;
            
            for(int i = 0; i < b; i++) {
                answer = (answer * a) % 10;
            }
            
            if (answer == 0) {
                answer = 10;
            }
            
            sb.append(answer).append("\n"); 
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
