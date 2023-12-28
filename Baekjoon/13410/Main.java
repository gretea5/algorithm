import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= K; i++) {
            answer = Math.max(answer, reverseNumber(N * i));
        }
        System.out.print(answer);
        br.close();
    }
    private static int reverseNumber(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        return Integer.parseInt(sb.reverse().toString());
    }
}
