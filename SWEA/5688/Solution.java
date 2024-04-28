import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            long n = Long.parseLong(br.readLine());

            long answer = -1;
            long num = 1;

            while(true) {
                long sqrt3 = num * num * num;

                if (sqrt3 == n) {
                    answer = num;
                    break;
                }
                else if (sqrt3 > n) {
                    break;
                }

                num += 1;
            }

            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
