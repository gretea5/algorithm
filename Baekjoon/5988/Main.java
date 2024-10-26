import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            String s = br.readLine();

            int v = s.charAt(s.length() - 1) - '0';

            sb.append(v % 2 == 0 ? "even" : "odd").append("\n");

            n -= 1;
        }

        System.out.print(sb);

        br.close();
    }
}
