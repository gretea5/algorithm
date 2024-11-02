import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= t; test_case += 1) {
            sb.append("#").append(test_case).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            //n개의 비트가 모두 켜져있는 변수를 담음
            int lastBit = (1 << n) - 1;

            //m이랑 and 연산을 수행했을 경우, 값이 동일하다면, on
            if (lastBit == (lastBit & m)) {
                sb.append("ON");
            }
            //아니면 off
            else {
                sb.append("OFF");
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
