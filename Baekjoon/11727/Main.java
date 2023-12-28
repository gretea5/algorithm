import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static int MAXSIZE = 1001;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[MAXSIZE];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        for(int i = 4; i < MAXSIZE; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
        }
        System.out.print(dp[n]);
        br.close();
    }
}
