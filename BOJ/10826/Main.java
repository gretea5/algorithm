import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger dp[] = new BigInteger[10001];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        for(int i = 2; i <= 10000; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        System.out.print(dp[n]);
        br.close();
    }
}
