import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static int count1 = 0, count2 = 0;
    public static int[] dp = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo(n);
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            count2 += 1;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.print(count1 + " " + count2);
        br.close();
    }
    public static int fibo(int n) {
        if (n == 1 || n == 2) {
            count1 += 1;
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}
