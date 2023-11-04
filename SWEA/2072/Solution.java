import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                int value = Integer.parseInt(st.nextToken());
                if(value % 2 == 1) sum += value;
            }
            sb.append("#").append(test).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
