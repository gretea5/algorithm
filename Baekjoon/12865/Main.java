import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static class Thing {
        int weight;
        int value;

        Thing(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Thing[] arr = new Thing[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i] = new Thing(w, v);
        }

        //[i][j] => i번째 물건을 담았을때, 최대 j만큼의 무게를 넣었을때 최대 가치
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            //현재 물건을 가져옴
            Thing now = arr[i];

            for (int j = 1; j <= k; j++) {
                //현재 물건을 반영하지 않고의, 최대 가치를 가져옴
                dp[i][j] = dp[i - 1][j];

                //현재 물건을 배낭에 담을 수 있다면,
                if (j >= now.weight) {
                    //i - 1번째 물건을 반영했을때, 현재 물건의 무게를 확보한 가치와 물건의 가치를 더해서 비교
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - now.weight] + now.value);
                }
            }
        }

        //n번째 물건을 반영했을때, 최대 k의 무게를 가지는 가방에 넣었을때 최대 가치 출력
        System.out.print(dp[n][k]);

        br.close();
    }
}
