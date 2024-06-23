import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = 0;
        
        int answer = Integer.MIN_VALUE;
        
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            
            num -= out;
            num += in;
            
            answer = Math.max(answer, num);
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
