import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            int n = Integer.parseInt(br.readLine());

            int cnt = 0;

            for(int x = n * -1; x <= n; x++) {
                for(int y = n * -1; y <= n; y++) {
                    int sqrtX = x * x;
                    int sqrtY = y * y;

                    if (sqrtX + sqrtY <= n * n) {
                        cnt += 1;
                    }
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
