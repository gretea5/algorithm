import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static int DPSIZE = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[DPSIZE];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            int coinLevel = Integer.parseInt(br.readLine());
            for(int j = coinLevel; j < DPSIZE; j++) {
                dp[j] = dp[j] + dp[j - coinLevel];
            }
        }
        System.out.print(dp[k]);
        br.close();
    }
}
