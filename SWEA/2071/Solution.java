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
            double sum = 0.0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 10; i++) {
                sum += Double.parseDouble(st.nextToken());
            }
            int answer = (int) Math.round(sum / 10);
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}

