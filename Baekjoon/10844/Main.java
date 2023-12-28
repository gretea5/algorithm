import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[101][10];
        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for(int i = 2; i < 101; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for(int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }
        long answer = 0;
        for(int i = 0; i <= 9; i++) {
            answer += dp[N][i];
        }
        System.out.print(answer % 1000000000);
        br.close();
    }
}
