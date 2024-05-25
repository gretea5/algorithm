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
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int[] arr = new int[7];
            
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int sum = 0;
            int min = Integer.MAX_VALUE;
            
            for(int n : arr) {
                if (n % 2 == 0) {
                    sum += n;
                    min = Math.min(min, n);
                }
            }
            
            sb.append(sum).append(" ").append(min + "\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
