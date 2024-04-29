import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            String t = st.nextToken();

            int minLength = calMinLength(s, t);

            int sCount = minLength / s.length();
            int tCount = minLength / t.length();

            StringBuilder ssb = new StringBuilder();

            for(int i = 0; i < sCount; i++) {
                ssb.append(s);
            }

            StringBuilder tsb = new StringBuilder();

            for(int i = 0; i < tCount; i++) {
                tsb.append(t);
            }

            String sSum = ssb.toString();
            String tSum = tsb.toString();

            sb.append("#").append(test).append(" ");

            if (sSum.equals(tSum)) {
                sb.append("yes");
            }
            else {
                sb.append("no");
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int calMinLength(String s, String t) {
        BigInteger b1 = new BigInteger(String.valueOf(s.length()));
        BigInteger b2 = new BigInteger(String.valueOf(t.length()));

        BigInteger gcd = b1.gcd(b2);

        return gcd.multiply(b1).multiply(b2).intValue();
    }
}
