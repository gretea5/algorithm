import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] dp = new double[N + 1];
        for(int i = 1; i < N + 1; i++) {
            dp[i] = Double.parseDouble(br.readLine());
        }
        for(int i = 2; i < N + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i] * dp[i - 1]);
        }
        double answer = Double.MIN_VALUE;
        for(int i = 1; i < N + 1; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.printf("%.3f", answer);
        br.close();
    }
}
