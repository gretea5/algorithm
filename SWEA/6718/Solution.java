import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");

            int d = Integer.parseInt(br.readLine());

            if (d < 100) {
                sb.append(0);
            }
            else if (d < 1000) {
                sb.append(1);
            }
            else if (d < 10000) {
                sb.append(2);
            }
            else if (d < 100000) {
                sb.append(3);
            }
            else if (d < 1000000) {
                sb.append(4);
            }
            else {
                sb.append(5);
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
