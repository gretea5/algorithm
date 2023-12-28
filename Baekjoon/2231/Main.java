import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            int sum = i;
            String str = String.valueOf(i);
            for(int j = 0; j < str.length(); j++) {
                sum += (int) str.charAt(j) - '0';
            }
            if (sum == N) {
                answer = i;
                break;
            }
        }
        System.out.print(answer);
        br.close();
    }
}
