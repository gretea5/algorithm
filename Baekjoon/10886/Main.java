import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt_0 = 0;
        int cnt_1 = 0;

        while (n > 0) {
            int v = Integer.parseInt(br.readLine());

            if (v == 0) {
                cnt_0 += 1;
            }
            else {
                cnt_1 += 1;
            }

            n -= 1;
        }

        if (cnt_0 < cnt_1) {
            System.out.print("Junhee is cute!");
        }
        else {
            System.out.print("Junhee is not cute!");
        }

        br.close();
    }
}
