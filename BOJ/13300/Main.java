import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[2][7];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            arr[gender][level] += 1;
        }
        int answer = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 1; j <= 6; j++) {
                int element = arr[i][j];
                answer += (element / K);
                if (element % K > 0) {
                    answer += 1;
                }
            }
        }
        System.out.print(answer);
        br.close();
    }
}
