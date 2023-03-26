import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static int DPSIZE = 100_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[DPSIZE];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            int coin = Integer.parseInt(br.readLine());
            for(int j = coin; j < DPSIZE; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        if(dp[k] == 987654321) {
            System.out.print(-1);
            return;
        }
        System.out.print(dp[k]);
        br.close();
    }
}
