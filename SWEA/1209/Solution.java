import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= 10; test++) {
            int t = Integer.parseInt(br.readLine());

            int max = Integer.MIN_VALUE;

            int[][] arr = new int[100][100];

            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int s1 = 0;
            int s2 = 0;

            for(int i = 0; i < 100; i++) {
                s1 = 0;
                s2 = 0;

                for(int j = 0; j < 100; j++) {
                    s1 += arr[i][j];
                }

                for(int j = 0; j < 100; j++) {
                    s2 += arr[j][i];
                }

                max = Math.max(max, s1);
                max = Math.max(max, s2);
            }

            s1 = 0;
            s2 = 0;

            for(int i = 0; i < 100; i++) {
                s1 += arr[i][i];
                s2 += arr[100 - i - 1][i];
            }

            max = Math.max(max, s1);
            max = Math.max(max, s2);

            sb.append("#").append(t).append(" ");
            sb.append(max).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
