import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static int[] R, G, B;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        R = new int[N + 1];
        G = new int[N + 1];
        B = new int[N + 1];
        dp = new int[N + 1][3];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        dp[1][0] = R[1];
        dp[1][1] = G[1];
        dp[1][2] = B[1];
        for(int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B[i];
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            if(answer > dp[N][i]) {
                answer = dp[N][i];
            }
        }
        System.out.print(answer);
        br.close();
    }
}
