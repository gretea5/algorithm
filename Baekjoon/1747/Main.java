import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final int SIZE = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[SIZE];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        int sqrt = (int) Math.sqrt(SIZE) + 1;

        for(int i = 2; i < sqrt; i++) {
            if(!isPrime[i]) {
                continue;
            }

            for(int j = i * i; j < SIZE; j += i) {
                isPrime[j] = false;
            }
        }

        int answer = -1;

        for(int i = N; i < SIZE; i++) {
            if(isPrime[i] && check(String.valueOf(i))) {
                answer = i;
                break;
            }
        }

        System.out.print(answer);

        br.close();
    }

    private static boolean check(String str) {
        String reverseStr = new StringBuilder(str).reverse().toString();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != reverseStr.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}
