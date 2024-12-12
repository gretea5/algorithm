import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long mod = a + b;

            long sqrt = calSqrt(k, mod);

            long total = (a * sqrt) % mod;

            sb.append(Math.min(total, mod - total));
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static long calSqrt(long k, long mod) {
        if (k == 1) {
            return 2;
        }

        long half = calSqrt(k / 2, mod);

        long sum = (half * half) % mod;

        //k가 홀수라면,
        if ((k & 1) == 1) {
            sum = (sum * 2) % mod;
        }

        return sum;
    }
}
