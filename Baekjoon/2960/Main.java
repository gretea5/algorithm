import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, false);

        int answer = -1;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                continue;
            }

            for(int j = i; j <= n; j += i) {
                if (isPrime[j]) {
                    continue;
                }

                isPrime[j] = true;
                k -= 1;

                if (k == 0) {
                    answer = j;
                    break;
                }
            }

            if (answer != -1) {
                break;
            }
        }

        System.out.print(answer);

        br.close();
    }
}
