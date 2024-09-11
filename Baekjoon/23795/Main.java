import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        while (true) {
            int v = Integer.parseInt(br.readLine());

            if (v == -1) {
                break;
            }

            sum += v;
        }

        System.out.print(sum);

        br.close();
    }
}
