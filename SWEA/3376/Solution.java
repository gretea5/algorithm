import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] p = new long[101];
        p[1] = 1;
        p[2] = 1;
        for(int i = 3; i <= 100; i++) {
            p[i] = p[i - 2] + p[i - 3];
        }
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("#").append(test).append(" ").append(p[N]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
