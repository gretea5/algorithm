import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            double aWin = Double.parseDouble(st.nextToken());
            double aTotal = Double.parseDouble(st.nextToken());

            double bWin = Double.parseDouble(st.nextToken());
            double bTotal = Double.parseDouble(st.nextToken());

            double ap = (aWin / aTotal) * 100.0;
            double bp = (bWin / bTotal) * 100.0;

            sb.append("#").append(test).append(" ");

            if (ap > bp) {
                sb.append("ALICE");
            }
            else if (ap < bp) {
                sb.append("BOB");
            }
            else {
                sb.append("DRAW");
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
