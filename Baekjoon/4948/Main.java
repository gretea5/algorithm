import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static int MAX = (123456 * 2) + 1;

    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isPrime = new boolean[MAX];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        int sqrt = (int) Math.sqrt(MAX) + 1;

        for(int i = 2; i <= sqrt; i++) {
            if(!isPrime[i]) continue;

            for(int j = i * i; j < MAX; j += i) {
                isPrime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            sb.append(calCount(n)).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int calCount(int n) {
        int cnt = 0;

        for(int i = n + 1; i <= (2 * n); i++) {
            if(isPrime[i]) cnt += 1;
        }

        return cnt;
    }
}
