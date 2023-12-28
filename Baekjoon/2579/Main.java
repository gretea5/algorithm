import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new int[T + 1];
        dp = new int[T + 1];
        int sum = 0;
        for(int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        if (T <= 2) {
            System.out.print(sum);
            return;
        }
        dp[1] = arr[1];
        dp[2] = arr[2];
        dp[3] = arr[3];
        for(int i = 4; i <= T - 1; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 3]) + arr[i];
        }
        System.out.print(sum - Math.min(dp[T - 1], dp[T - 2]));
        br.close();
    }
}
