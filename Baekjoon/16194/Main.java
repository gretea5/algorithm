import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력
        int N = Integer.parseInt(br.readLine());

        //배열 선언
        int[] p = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //초기값 설정
        for(int i = 1; i < N + 1; i++) {
            int v = Integer.parseInt(st.nextToken());
            p[i] = v;
            dp[i] = v;
        }

        for(int i = 2; i < N + 1; i++) {
            for(int j = 1; j < i; j++) {
                //최솟값 비교
                dp[i] = Math.min(dp[i], dp[i - j] + p[j]);
            }
        }

        //출력
        System.out.print(dp[N]);

        br.close();
    }
}
