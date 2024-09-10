import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        int t = 0;

        t += (l / 5);

        if (l % 5 > 0) {
            t += 1;
        }

        System.out.print(t);

        br.close();
    }
}
