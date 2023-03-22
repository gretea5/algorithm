import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.math.BigInteger;

public class Main {
    public static int SIZE = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[SIZE];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        for(int i = 2; i < SIZE; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]).mod(new BigInteger("1000000007"));
        }
        System.out.print(dp[n]);
        br.close();
    }
}
