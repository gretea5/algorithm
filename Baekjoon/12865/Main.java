import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static class Good {
        int w;
        int v;

        Good(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Good[] goods = new Good[N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            goods[i] = new Good(w, v);
        }

        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            int weight = goods[i].w;
            int value = goods[i].v;

            for(int j = 1; j <= K; j++) {
                //i - 1번째까지에서 j무게의 최대 가치를 가져온다.
                dp[i][j] = dp[i - 1][j];

                //j가 현재 무게보다 작다면, 즉 여분의 무게가 있다면,
                if(j >= weight) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight] + value);
                }
            }
        }

        System.out.print(dp[N][K]);
        
        br.close();
    }
}
