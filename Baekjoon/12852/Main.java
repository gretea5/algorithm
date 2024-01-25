import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //경우의 수
        int[] dp = new int[N + 1];
        //이전 인덱스 기록
        int[] trace = new int[N + 1];
        
        //초기화
        dp[1] = 0;
        trace[1] = 0;

        for(int i = 2; i <= N; i++) {
            //1 이전의 경우의 수에서 가져옴
            dp[i] = dp[i - 1] + 1;
            //이전 수를 기록
            trace[i] = i - 1;

            //2로 나누어 떨어질 경우의 수를 비교
            if(i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                trace[i] = i/2;
            }

            //3으로 나누어 떨어질 경우의 수를 비교
            if(i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                trace[i] = i/3;
            }
        }

        //N을 만드는 최소의 경우의 수
        int min = dp[N];
        //기록 첫번째 숫자
        int idx = N;

        StringBuilder sb = new StringBuilder();

        sb.append(min + "\n");

        for(int i = 0; i <= min; i++) {
            sb.append(idx + " ");
            //이전에 기록 되었던 수를 가져온다.
            idx = trace[idx];
        }

        //출력
        System.out.print(sb);
        br.close();
    }
}
