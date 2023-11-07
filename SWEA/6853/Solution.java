import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(br.readLine());
            int out = 0;
            int in = 0;
            int onLine = 0;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(x1 < x && x < x2 && y1 < y && y < y2) {
                    in += 1;
                }
                else if(x1 == x && y1 <= y && y <= y2) {
                    onLine += 1;
                }
                else if(x2 == x && y1 <= y && y <= y2) {
                    onLine += 1;
                }
                else if(y1 == y && x1 <= x && x <= x2) {
                    onLine += 1;
                }
                else if(y2 == y && x1 <= x && x <= x2) {
                    onLine += 1;
                }
                else {
                    out += 1;
                }
            }
            sb.append("#").append(test).append(" ")
                    .append(in).append(" ")
                    .append(onLine).append(" ")
                    .append(out).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
