import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= N; i++) {
                dp[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 2; i <= N; i++) {
                dp[i] = Math.max(dp[i], dp[i] + dp[i - 1]);
            }
            int answer = Integer.MIN_VALUE;
            for(int i = 1; i <= N; i++) {
                answer = Math.max(answer, dp[i]);
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
