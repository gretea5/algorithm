import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        //색상 비용 배열
        int[][] color = new int[3][n + 1];
        
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            for (int j = 0; j < 3; j++) {
                color[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        //dp 배열
        int[][] dp = new int[3][n + 1];
        
        //dp에서 가질 수 있는 최댓값 + 1 (문제에서 무한 값)
        int INF = (1000 * 1000) + 1;
        
        int answer = Integer.MAX_VALUE;
        
        //s는 첫번째로 칠해진 색의 인덱스(중요)
        for (int s = 0; s < 3; s++) {
            
            //첫번째 색을 하나만 칠함
            for (int i = 0; i < 3; i++) {
                if (s == i) {
                    dp[i][1] = color[i][1];
                    continue;
                }
                
                dp[i][1] = INF;
            }
            
            //인접하지 않은 색에 대해 dp값을 구함
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + color[0][i];
                dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + color[1][i];
                dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + color[2][i];
            }
            
            //마지막 색에서 첫번째 색과 다른 값들을 최솟값을 갱신
            for (int i = 0; i < 3; i++) {
                if (s == i) {
                    continue;
                }
                
                answer = Math.min(answer, dp[i][n]);
            }
        }
        
        //최솟값 출력
        System.out.print(answer);
        
        br.close();
    }
}
