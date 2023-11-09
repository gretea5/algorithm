import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            //N 입력
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            int[][] dp = new int[2][N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //배열 입력
            for(int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            //dp 배열 초기값 설정
            dp[0][0] = 0;
            dp[0][1] = 0;
            //dp 값 구하기
            for(int i = 1; i <= N; i++) {
                dp[0][i] = Math.max(dp[0][i - 1] * arr[i], dp[1][i - 1] * arr[i]);
                dp[1][i] = Math.max(dp[0][i - 1] + arr[i], dp[1][i - 1] + arr[i]);
            }
            //최댓값 계산
            int max = Math.max(dp[0][N], dp[1][N]);
            //출력 형식 저장
            sb.append("#").append(test).append(" ").append(max).append("\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
}
