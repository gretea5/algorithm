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
        
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 1; i <= n; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 1; j <= m; j++) {
                dp[i][j] = arr[j - 1] - '0';
            }
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                //1일때,
                if (dp[i][j] != 0) {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        
        int answer = Integer.MIN_VALUE;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        System.out.print(answer * answer);
        
        br.close();
    }
}
