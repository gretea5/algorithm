import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            //a 배열이 더 짧을 때,
            boolean flag = true;
            int length = n;

            //b 배열이 더 짧을 때,
            if (n > m) {
                flag = false;
                length = m;
            }

            int startIdx = 0;
            int dist = Math.abs(n - m);

            int answer = 0;

            while(startIdx <= dist) {
                int sum = 0;

                //m의 길이가 더 클때,
                if (flag) {
                    for(int i = 0; i < length; i++) {
                        sum += (a[i] * b[i + startIdx]);
                    }
                }
                else {
                    for(int i = 0; i < length; i++) {
                        sum += (a[i + startIdx] * b[i]);
                    }
                }

                answer = Math.max(answer, sum);

                startIdx += 1;
            }

            sb.append("#").append(test).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
