import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];

        //1번 인덱스 초기화
        dp[1] = 1;

        //한변의 길이 계산
        for(int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        //둘레 출력
        System.out.print((dp[N] * 4) + (dp[N - 1] * 2));
        br.close();
    }
}
