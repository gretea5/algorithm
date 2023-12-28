import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
    public static int[] dp = new int[5001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 3 || N == 5) {
            System.out.print(1);
            return;
        }
        else if (N == 4) {
            System.out.print(-1);
            return;
        }
        Arrays.fill(dp, 5000);
        dp[3] = 1;
        dp[5] = 1;
        for(int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }
        if(dp[N] >= 5000) {
            System.out.print(-1);
            return;
        }
        System.out.print(dp[N]);
        br.close();
    }
}
