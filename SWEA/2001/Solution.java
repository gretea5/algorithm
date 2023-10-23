import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Solution {
    private static int[][] arr;
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //T 입력
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //N, M 입력
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            //배열 입력
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = Integer.MIN_VALUE;
            for(int i = 0; i <= N - M; i++) {
                for(int j = 0; j <= N - M; j++) {
                    answer = Math.max(answer, calCount(i, j));
                }
            }
            //출력 형식 저장
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
    //파리 개수 구하기
    private static int calCount(int r, int c) {
        int sum = 0;
        for(int i = r; i < r + M; i++) {
            for(int j = c; j < c + M; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
