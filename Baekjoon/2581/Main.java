import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final int MAX = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[MAX];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        int sqrt = (int) Math.sqrt(MAX) + 1;

        for(int i = 2; i < sqrt; i++) {
            if(!isPrime[i]) continue;

            for(int j = i*i; j < MAX; j += i) {
                isPrime[j] = false;
            }
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        for(int i = M; i <= N; i++) {
            if(isPrime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if(sum == 0) {
            System.out.print(-1);
            return;
        }

        System.out.println(sum);
        System.out.print(min);

        br.close();
    }
}
