import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    //하나의 문자에서 나올 수 있는 경우의 수를 넘는 소수를 주면 거의 다 들어온다.
    private static final int K1 = 67;
    private static final int K2 = 71;
    private static final int K3 = 73;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            String b = br.readLine();
            String s = br.readLine();

            int bCnt = b.length();
            int sCnt = s.length();

            int bHash1 = 0;
            int sHash1 = 0;

            int bHash2 = 0;
            int sHash2 = 0;

            int bHash3 = 0;
            int sHash3 = 0;

            int power1 = 1;
            int power2 = 1;
            int power3 = 1;

            int answer = 0;

            for (int i = 0; i <= bCnt - sCnt; i++) {
                //i가 0이라면 s 길이 만큼의 해시값들을 구함
                if (i == 0) {
                    for (int j = 0; j < sCnt; j++) {
                        bHash1 += hash(b.charAt(sCnt - 1 - j), power1);
                        sHash1 += hash(s.charAt(sCnt - 1 - j), power1);

                        bHash2 += hash(b.charAt(sCnt - 1 - j), power2);
                        sHash2 += hash(s.charAt(sCnt - 1 - j), power2);

                        bHash3 += hash(b.charAt(sCnt - 1 - j), power3);
                        sHash3 += hash(s.charAt(sCnt - 1 - j), power3);

                        if (j < sCnt - 1) {
                            power1 *= K1;
                            power2 *= K2;
                            power3 *= K3;
                        }
                    }
                }
                else {
                    bHash1 = K1 * (bHash1 - hash(b.charAt(i - 1), power1)) + b.charAt(i + sCnt -  1);
                    bHash2 = K2 * (bHash2 - hash(b.charAt(i - 1), power2)) + b.charAt(i + sCnt -  1);
                    bHash3 = K3 * (bHash3 - hash(b.charAt(i - 1), power3)) + b.charAt(i + sCnt -  1);
                }

                if (bHash1 == sHash1 && bHash2 == sHash2 && bHash3 == sHash3) {
                    answer += 1;
                }
            }

            sb.append(answer);
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int hash(int value, int power) {
        return value * power;
    }
}
