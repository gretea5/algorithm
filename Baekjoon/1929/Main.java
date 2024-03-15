import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[MAX];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        int sqrt = (int) Math.sqrt(MAX);

        for(int i = 2; i <= sqrt; i++) {
            if(!isPrime[i]) continue;

            for(int j = i * i; j < MAX; j += i) {
                isPrime[j] = false;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int i = M; i <= N; i++) {
            if(isPrime[i]) sb.append(i).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
