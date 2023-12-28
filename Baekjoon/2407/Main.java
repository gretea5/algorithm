import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static int MAXSIZE = 101;
    public static BigInteger[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new BigInteger[MAXSIZE][MAXSIZE];
        for(int i = 1; i < MAXSIZE; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0 || i == j) {
                    dp[i][j] = BigInteger.ONE;
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
            }
        }
        System.out.print(dp[n][m]);
        br.close();
    }
}
