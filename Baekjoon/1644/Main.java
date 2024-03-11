import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    private static final int max = 400_0001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.print(0);
            return;
        }

        boolean[] isPrime = new boolean[max];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        int sqrt = (int) Math.sqrt(max) + 1;

        for(int i = 2; i <= sqrt; i++) {
            if(!isPrime[i]) continue;

            for(int j = i * i; j < max; j += i) {
                isPrime[j] = false;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 2; i < N + 1; i++) {
            if(isPrime[i]) arr.add(i);
        }

        int left = 0;
        int right = 0;
        int sum = arr.get(0);
        int answer = 0;

        while(left < arr.size() && right < arr.size()) {
            if(sum == N) {
                answer += 1;
                sum -= arr.get(left);
                left += 1;
            }
            else if(sum > N) {
                sum -= arr.get(left);
                left += 1;
            }
            else {
                right += 1;
                if(right < arr.size()) {
                    sum += arr.get(right);
                }
            }
        }

        System.out.print(answer);

        br.close();
    }
}
