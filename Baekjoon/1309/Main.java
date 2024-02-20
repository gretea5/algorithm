import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];

        dp[0] = 1;
        dp[1] = 3;

        for(int i = 2; i < 100001; i++) {
            dp[i] = ((dp[i - 1] * 2) + dp[i - 2]) % 9901;
        }

        System.out.print(dp[N]);

        br.close();
    }
}
