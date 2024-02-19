import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N % 2 == 1) {
            System.out.print(0);
            return;
        }
        else {
            int[] dp = new int[N + 1];

            dp[0] = 1;

            //15 * 15
            for(int i = 2; i < N + 1; i += 2) {
                dp[i] = dp[i - 2] * 3;
                for(int j = i - 4; j >= 0; j -= 2) {
                    //예외의 쌍은 2가지
                    dp[i] += dp[j] * 2;
                }
            }

            System.out.print(dp[N]);
        }
        br.close();
    }
}
