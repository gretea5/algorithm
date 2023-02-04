import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String sang = "SK";
    public static String chang = "CY";
    public static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1 || N == 3) {
            System.out.print(sang);
            return;
        }
        else if (N == 2) {
            System.out.print(chang);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for(int i = 4; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }
        if (dp[N] % 2 == 0) {
            System.out.print(chang);
        }
        else {
            System.out.print(sang);
        }
        br.close();
    }
}

