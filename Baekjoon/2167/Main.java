import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n + 1][m + 1];
        
        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int sum = 0;
            
            for(int j = 1; j < m + 1; j++) {
                int v = Integer.parseInt(st.nextToken());
                
                sum += v;
                
                arr[i][j] = sum;
            }
        }
        
        int k = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while(k > 0) {
            int sum = 0;
            
            st = new StringTokenizer(br.readLine(), " ");
            
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for(int a = i; a <= x; a++) {
                sum += (arr[a][y] - arr[a][j - 1]);
            }
            
            sb.append(sum).append("\n");
            
            k -= 1;
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
