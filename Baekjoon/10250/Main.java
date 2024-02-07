import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int height = -1;
            int width = -1;

            if(N % H == 0) {
                height = H;
                width = (N / H);
            } else {
                height = (N % H);
                width = (N / H) + 1;
            }

            sb.append(height);

            if(width < 10) {
                sb.append(0).append(width);
            } else {
                sb.append(width);
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
