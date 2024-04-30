import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = new boolean[1000001];

        int sqrt = (int) Math.sqrt(1000001) + 1;

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i < sqrt; i++) {
            if(!isPrime[i]) {
                continue;
            }

            for(int j = i * i; j < 1000001; j += i) {
                isPrime[j] = false;
            }
        }

        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String d = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int count = 0;

            for(int i = a; i <= b; i++) {
                if (isPrime[i] && String.valueOf(i).contains(d)) {
                    count += 1;
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(count).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
