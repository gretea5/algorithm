import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            int n = Integer.parseInt(br.readLine());
            boolean[] locked = new boolean[n + 1];
            Arrays.fill(locked, true);
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(j % i == 0) {
                        locked[j] = !locked[j];
                    }
                }
            }
            int count = 0;
            for(int i = 1; i <= n; i++) {
                if(!locked[i]) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
