import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++) {
            String[] arr = br.readLine().split("X");

            int sum = 0;

            for(String s : arr) {
                int n = s.length();
                sum += (n * (n + 1)) / 2;
            }

            sb.append(sum + "\n");
        }

        System.out.print(sb);
        br.close();
    }
}
