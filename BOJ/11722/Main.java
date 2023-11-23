import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //배열 선언
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //배열 데이터 입력
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //모든 하나의 요소에서 최대 길이는 1
        Arrays.fill(dp, 1);
        for(int i = 2; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                //이전 요소가 더 클 경우
                if(arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                //값이 같은 경우 경우의 수가 동일
                else if (arr[j] == arr[i]) {
                    dp[i] = dp[j];
                }
            }
        }
        //최대 경우의 수 출력
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.print(answer);
        br.close();
    }
}
