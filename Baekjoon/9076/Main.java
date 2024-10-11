import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t > 0) {
            int[] arr = new int[5];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < 5; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if (arr[4] - arr[1] >= 4) {
                sb.append("KIN");
            }
            else {
                sb.append(arr[1] + arr[2] + arr[3]);
            }

            sb.append("\n");

            t -= 1;
        }

        System.out.print(sb);

        br.close();
    }
}
