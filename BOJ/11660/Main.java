import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
                arr[i][j] = sum;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int j = startX; j <= endX; j++) {
                sum += arr[j][endY] - arr[j][startY - 1];
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
