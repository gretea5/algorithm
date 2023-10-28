import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String result;
            if(N % 2 == 1) {
                result = "No";
            }
            else {
                result = str.substring(0, N/2).equals(str.substring(N/2)) ? "Yes" : "No";
            }
            sb.append("#").append(test).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
