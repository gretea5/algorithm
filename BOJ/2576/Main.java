import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 == 1) {
                sum += num;
                min = Math.min(num, min);
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
        br.close();
    }
}
