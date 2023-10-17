import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            String reverseStr = new StringBuilder(str).reverse().toString();
            sb.append("#").append(i + 1).append(" ").append(str.equals(reverseStr) ? 1 : 0).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
