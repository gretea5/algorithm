import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][41];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 2; i <= 40; i++) {
            dp[0][i] = dp[0][i - 1] + dp[0][i - 2];
            dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[0][N]).append(" ").append(dp[1][N]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
