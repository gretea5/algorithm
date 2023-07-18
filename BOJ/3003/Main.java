import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] set = {1, 1, 2, 2, 2, 8};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(set[i] - num).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
