import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            int c = Integer.parseInt(br.readLine());

            sb.append(c / 25).append(" ");

            c %= 25;

            sb.append(c / 10).append(" ");

            c %= 10;

            sb.append(c / 5).append(" ");

            c %= 5;

            sb.append(c / 1).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
