import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int n = Integer.parseInt(br.readLine());
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            
            max = Math.max(max, v);
            min = Math.min(min, v);
        }
        
        System.out.print(max - min);
        
        br.close();
    }
}
