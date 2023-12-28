import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int num_5 = 0;
        while(true) {
            if (N < 5 * num_5) {
                break;
            }
            int num_2 = 0;
            if ((N - (5 * num_5)) % 2 == 0) {
                num_2 += ((N - (5 * num_5)) / 2);
                if (min > (num_5 + num_2)) {
                    min = (num_5 + num_2);
                }
            }
            num_5++;
        }
        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }
        System.out.print(min);
        br.close();
    }
}

