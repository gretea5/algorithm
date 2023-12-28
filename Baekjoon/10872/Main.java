import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.print(1);
            return;
        }
        int answer = 1;
        for(int i = 1; i <= N; i++) {
            answer *= i;
        }
        System.out.print(answer);
        br.close();
    }
}
