import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
    public static int SIZE = 100_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[SIZE];
        int[] coin = {1, 2, 5, 7};
        Arrays.fill(dp, 987654321);
        dp[0] = 0;
        for(int k = 0; k < 4; k++) {
            for(int i = coin[k]; i < SIZE; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin[k]] + 1);
            }
        }
        System.out.print(dp[N]);
        br.close();
    }
}
