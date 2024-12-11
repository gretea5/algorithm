import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            HashSet<String> set = new HashSet<>();

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < n; i++) {
                set.add(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");

            int answer = 0;

            for (int i = 0; i < m; i++) {
                String s = st.nextToken();

                if (set.contains(s)) {
                    answer += 1;
                }
            }

            sb.append(answer);
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
