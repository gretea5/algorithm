import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[][] dp = new int[2][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[0][i] = 1;
            dp[1][i] = 1;
        }
        for(int i = 2; i <= N; i++) {
            if (arr[i] >= arr[i - 1]) {
                dp[0][i] = dp[0][i - 1] + 1;
            }
            if (arr[i] <= arr[i - 1]){
                dp[1][i] = dp[1][i - 1] + 1;
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < 2; i++) {
            for(int j = 1; j <= N; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.print(answer);
        br.close();
    }
}
