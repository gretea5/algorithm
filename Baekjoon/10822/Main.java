import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ",");

        int sum = 0;

        while(st.hasMoreTokens()) {
            int v = Integer.parseInt(st.nextToken());

            sum += v;
        }

        System.out.print(sum);

        br.close();
    }
}
