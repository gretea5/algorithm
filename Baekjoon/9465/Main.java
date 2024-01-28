import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++) {
            //n 입력
            int n = Integer.parseInt(br.readLine());

            //dp, sticker 점수 배열 선언
            int[][] sticker = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            //sticker 점수 입력
            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //초기 dp 값
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            //dp 구하기
            for(int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1] , dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1] , dp[0][i - 2]) + sticker[1][i];
            }

            //최댓값 기록
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }

        //출력
        System.out.print(sb);
        br.close();
    }
}
