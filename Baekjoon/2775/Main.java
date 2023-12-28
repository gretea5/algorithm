import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];
        for(int i = 1; i <= 14; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= 14; i++) {
            for(int j = 1; j <= 14; j++) {
                for(int h = 1; h <= j; h++) {
                    dp[i][j] += dp[i - 1][h];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n]).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
