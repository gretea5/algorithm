import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;

        for(int i = 0; i < N; i++) {
            if(checkPrime(Integer.parseInt(st.nextToken()))) cnt += 1;
        }

        System.out.print(cnt);

        br.close();
    }

    private static boolean checkPrime(int n) {
        if(n == 1) {
            return false;
        }

        for(int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
