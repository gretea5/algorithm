import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int MAX = 201;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[MAX][MAX];

        for(int i = 0; i < MAX; i++) {
            dp[i][1] = 1;
        }

        for(int i = 0; i < MAX; i++) {
            dp[1][i] = i;
        }

        for(int i = 2;  i <MAX; i++) {
            for(int j = 2; j < MAX; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }

        System.out.print(dp[N][K]);

        br.close();
    }
}
