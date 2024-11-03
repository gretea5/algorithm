import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase += 1) {
            sb.append("#").append(testCase).append(" ");

            int n = Integer.parseInt(br.readLine());

            //1 ~ 9번 비트가 모두 1로 채위짐
            int total = (1 << 10) - 1;

            int bitValue = 0;

            int count = 1;

            while (true) {
                char[] arr = String.valueOf(count * n).toCharArray();

                for (char ch : arr) {
                    int v = ch - '0';

                    //1을 v를 bit연산한 것과 or 연산을 해서 체크
                    bitValue = (bitValue | (1 << v));
                }

                //모두 비트가 채워졌다면,
                if (total == bitValue) {
                    break;
                }

                count += 1;
            }

            //양을 출력
            sb.append(count * n).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
